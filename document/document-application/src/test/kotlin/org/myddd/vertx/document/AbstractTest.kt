package org.myddd.vertx.document

import com.google.inject.AbstractModule
import com.google.inject.Guice
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.hibernate.reactive.mutiny.Mutiny
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.extension.ExtendWith
import org.myddd.vertx.document.domain.DistributeID
import org.myddd.vertx.document.domain.DocumentRepository
import org.myddd.vertx.document.infra.DocumentRepositoryHibernate
import org.myddd.vertx.document.infra.GrpcDistributeID
import org.myddd.vertx.grpc.GrpcInstanceProvider
import org.myddd.vertx.grpc.ServiceDiscoveryGrpcInstanceProvider
import org.myddd.vertx.id.IDGenerator
import org.myddd.vertx.id.SnowflakeDistributeId
import org.myddd.vertx.ioc.InstanceFactory
import org.myddd.vertx.ioc.guice.GuiceInstanceProvider
import org.myddd.vertx.string.RandomIDString
import org.myddd.vertx.string.RandomIDStringProvider
import javax.persistence.Persistence

@ExtendWith(VertxExtension::class)
abstract class AbstractTest {

    companion object {

        private lateinit var deployId:String

        @BeforeAll
        @JvmStatic
        fun beforeAll(vertx: Vertx,testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    initIOC(vertx).await()
                    startVerticle(vertx).await()
                }catch (t:Throwable){
                    testContext.failNow(t)
                }
                testContext.completeNow()
            }
        }

        fun afterAll(vertx: Vertx,testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    stopVerticle(vertx).await()
                }catch (t:Throwable){
                    testContext.failNow(t)
                }
                testContext.completeNow()
            }
        }

        private suspend fun startVerticle(vertx: Vertx):Future<Unit>{
            return try {
                deployId = vertx.deployVerticle(AbstractGrpcBootstrapVerticle()).await()
                Future.succeededFuture()
            }catch (t:Throwable){
                Future.failedFuture(t)
            }
        }

        private suspend fun stopVerticle(vertx: Vertx):Future<Unit>{
            return try {
                vertx.undeploy(deployId).await()
                Future.succeededFuture()
            }catch (t:Throwable){
                Future.failedFuture(t)
            }
        }

        private fun initIOC(vertx: Vertx):Future<Unit>{
            return try {
                InstanceFactory.setInstanceProvider(GuiceInstanceProvider(Guice.createInjector(object : AbstractModule(){
                    override fun configure() {
                        bind(Vertx::class.java).toInstance(vertx)
                        bind(Mutiny.SessionFactory::class.java).toInstance(
                            Persistence.createEntityManagerFactory("default")
                                .unwrap(Mutiny.SessionFactory::class.java))
                        bind(IDGenerator::class.java).toInstance(SnowflakeDistributeId())

                        bind(RandomIDString::class.java).to(RandomIDStringProvider::class.java)
                        bind(DocumentRepository::class.java).to(DocumentRepositoryHibernate::class.java)

                        bind(DistributeID::class.java).to(GrpcDistributeID::class.java)
                        bind(GrpcInstanceProvider::class.java).to(ServiceDiscoveryGrpcInstanceProvider::class.java)
                    }
                })))
                Future.succeededFuture()
            }catch (t:Throwable){
                Future.failedFuture(t)
            }
        }
    }
}