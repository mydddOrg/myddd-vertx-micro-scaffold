package org.myddd.vertx.document.infra

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.protobuf.Empty
import io.smallrye.mutiny.Uni
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.hibernate.reactive.mutiny.Mutiny
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.myddd.vertx.distributed.api.DistributedGrpcService
import org.myddd.vertx.distributed.api.VertxDistributedIdApplicationGrpc
import org.myddd.vertx.document.domain.DocumentRepository
import org.myddd.vertx.grpc.GrpcInstanceFactory
import org.myddd.vertx.grpc.GrpcInstanceProvider
import org.myddd.vertx.grpc.ServiceDiscoveryGrpcInstanceProvider
import org.myddd.vertx.id.IDGenerator
import org.myddd.vertx.id.SnowflakeDistributeId
import org.myddd.vertx.ioc.InstanceFactory
import org.myddd.vertx.ioc.guice.GuiceInstanceProvider
import org.myddd.vertx.junit.execute
import org.myddd.vertx.repository.hibernate.MydddServiceContributor
import org.myddd.vertx.string.RandomIDString
import org.myddd.vertx.string.RandomIDStringProvider
import javax.persistence.Persistence

@ExtendWith(VertxExtension::class)
class TestDistributeID {

    private val distributedIdApplicationProxy by lazy {
        GrpcInstanceFactory.getInstance<VertxDistributedIdApplicationGrpc.DistributedIdApplicationVertxStub>(
            DistributedGrpcService.DistributedId)
    }


    companion object {

        private lateinit var deployId:String

        private val vertx by lazy { Vertx.vertx() }

        @BeforeAll
        @JvmStatic
        fun beforeAll(testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    initIOC().await()
                    deployId = vertx.deployVerticle(AbstractGrpcBootstrapVerticle()).await()
                }catch (t:Throwable){
                    testContext.failNow(t)
                }
                testContext.completeNow()
            }
        }

        @AfterAll
        @JvmStatic
        fun afterAll(testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    vertx.undeploy(deployId).await()
                }catch (t:Throwable){
                    testContext.failNow(t)
                }
                testContext.completeNow()
            }
        }

        private suspend fun initIOC():Future<Unit>{
            return try {
                vertx.executeBlocking<Unit> {
                    InstanceFactory.setInstanceProvider(GuiceInstanceProvider(Guice.createInjector(object : AbstractModule(){
                        override fun configure() {
                            bind(Vertx::class.java).toInstance(vertx)
                            MydddServiceContributor.vertx = vertx

                            bind(Mutiny.SessionFactory::class.java).toInstance(
                                Persistence.createEntityManagerFactory("default")
                                    .unwrap(Mutiny.SessionFactory::class.java))
                            bind(IDGenerator::class.java).toInstance(SnowflakeDistributeId())
                            bind(RandomIDString::class.java).to(RandomIDStringProvider::class.java)
                            bind(DocumentRepository::class.java).to(DocumentRepositoryHibernate::class.java)

                            bind(GrpcInstanceProvider::class.java).to(ServiceDiscoveryGrpcInstanceProvider::class.java)
                        }
                    })))

                    it.complete()
                }.await()


                Future.succeededFuture()
            }catch (t:Throwable){
                Future.failedFuture(t)
            }
        }
    }

    @Test
    fun testNextId(testContext: VertxTestContext){
        testContext.execute {
            val nextId = distributedIdApplicationProxy.rpcRun {
                it.distributedId(Empty.getDefaultInstance())
            }.await()

            testContext.verify {
                Assertions.assertNotNull(nextId)
            }
        }
    }

}