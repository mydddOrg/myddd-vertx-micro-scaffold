package org.myddd.vertx.micro.rest.bootstrap

import io.vertx.core.Vertx
import io.vertx.core.impl.logging.LoggerFactory
import io.vertx.ext.web.client.WebClient
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.extension.ExtendWith
import org.myddd.vertx.ioc.InstanceFactory
import java.util.*

@ExtendWith(VertxExtension::class)
open class AbstractTest {

    companion object {

        private lateinit var deployId:String

        val logger by lazy { LoggerFactory.getLogger(AbstractTest::class.java) }

        const val host = "127.0.0.1"

        const val port = 8080

        val webClient: WebClient by lazy {
            InstanceFactory.getInstance(WebClient::class.java)
        }


        @BeforeAll
        @JvmStatic
        fun beforeAll(vertx: Vertx,testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    deployId = vertx.deployVerticle(MyBootstrapVerticle()).await()
                }catch (t:Throwable){
                    testContext.failNow(t)
                }
                testContext.completeNow()
            }
        }

        fun afterAll(vertx: Vertx,testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    vertx.undeploy(deployId).await()
                }catch (t:Throwable){
                    testContext.failNow(t)
                }
            }
        }

        fun randomString():String {
            return UUID.randomUUID().toString()
        }
    }


}