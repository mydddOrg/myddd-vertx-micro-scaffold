package org.myddd.vertx.micro.rest.bootstrap.route

import io.vertx.core.Vertx
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.myddd.vertx.micro.rest.bootstrap.AbstractTest

class TestNodeRoute:AbstractTest() {

    @Test
    fun testNodeInfo(vertx: Vertx,testContext: VertxTestContext){
        GlobalScope.launch(vertx.dispatcher()) {
            try {
                val response = webClient.get(port,host,"/v1/node")
                    .send()
                    .await()

                testContext.verify {
                    Assertions.assertEquals(200,response.statusCode())
                }
            }catch (t:Throwable){
                testContext.failNow(t)
            }
            testContext.completeNow()
        }
    }
}