package org.myddd.vertx.distributed

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
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.extension.ExtendWith
import org.myddd.vertx.grpc.GrpcInstanceProvider
import org.myddd.vertx.grpc.ServiceDiscoveryGrpcInstanceProvider
import org.myddd.vertx.id.IDGenerator
import org.myddd.vertx.id.SnowflakeDistributeId
import org.myddd.vertx.ioc.InstanceFactory
import org.myddd.vertx.ioc.guice.GuiceInstanceProvider
import org.myddd.vertx.repository.hibernate.MydddServiceContributor

@ExtendWith(VertxExtension::class)
abstract class AbstractTest {

    companion object {

        private lateinit var deployId:String

        private val vertx by lazy { Vertx.vertx() }

        @BeforeAll
        @JvmStatic
        fun beforeAll(testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    initIOC().await()
                    startVerticle().await()
                }catch (t:Throwable){
                    testContext.failNow(t)
                }
                testContext.completeNow()
            }
        }

        fun afterAll(testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    stopVerticle().await()
                }catch (t:Throwable){
                    testContext.failNow(t)
                }
                testContext.completeNow()
            }
        }

        private suspend fun startVerticle():Future<Unit>{
            return try {
                deployId = vertx.deployVerticle(AbstractGrpcBootstrapVerticle()).await()
                Future.succeededFuture()
            }catch (t:Throwable){
                Future.failedFuture(t)
            }
        }

        private suspend fun stopVerticle():Future<Unit>{
            return try {
                vertx.undeploy(deployId).await()
                Future.succeededFuture()
            }catch (t:Throwable){
                Future.failedFuture(t)
            }
        }

        private suspend fun initIOC():Future<Unit>{
            return try {
                vertx.executeBlocking<Unit> {
                    InstanceFactory.setInstanceProvider(GuiceInstanceProvider(Guice.createInjector(object : AbstractModule(){
                        override fun configure() {
                            bind(Vertx::class.java).toInstance(vertx)
                            MydddServiceContributor.vertx = vertx
                            bind(IDGenerator::class.java).toInstance(SnowflakeDistributeId())
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
}