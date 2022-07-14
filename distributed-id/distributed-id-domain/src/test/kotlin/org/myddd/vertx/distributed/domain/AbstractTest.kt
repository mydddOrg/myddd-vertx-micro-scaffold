package org.myddd.vertx.distributed.domain

import com.google.inject.AbstractModule
import com.google.inject.Guice
import io.vertx.core.Vertx
import io.vertx.core.impl.logging.LoggerFactory
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.hibernate.reactive.mutiny.Mutiny
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.extension.ExtendWith
import org.myddd.vertx.id.IDGenerator
import org.myddd.vertx.id.SnowflakeDistributeId
import org.myddd.vertx.ioc.InstanceFactory
import org.myddd.vertx.ioc.guice.GuiceInstanceProvider
import org.myddd.vertx.repository.hibernate.MydddServiceContributor
import org.myddd.vertx.string.RandomIDString
import org.myddd.vertx.string.RandomIDStringProvider
import java.util.*
import javax.persistence.Persistence

@ExtendWith(VertxExtension::class)
abstract class AbstractTest {

    val logger by lazy { LoggerFactory.getLogger(AbstractTest::class.java) }

    companion object {

        private val vertx by lazy { Vertx.vertx() }

        @BeforeAll
        @JvmStatic
        fun beforeAll(testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
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
                            }
                        })))

                        it.complete()
                    }.await()

                }catch (t:Throwable){
                    testContext.failNow(t)
                }
                testContext.completeNow()
            }
        }
    }

    fun randomString():String {
        return UUID.randomUUID().toString()
    }


}