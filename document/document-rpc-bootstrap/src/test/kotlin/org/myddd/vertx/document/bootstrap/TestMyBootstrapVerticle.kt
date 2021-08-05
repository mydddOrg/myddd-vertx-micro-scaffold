package org.myddd.vertx.document.bootstrap

import com.google.protobuf.Empty
import io.vertx.core.Vertx
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.myddd.vertx.distributed.api.DistributedGrpcService
import org.myddd.vertx.distributed.api.VertxDistributedIdApplicationGrpc
import org.myddd.vertx.grpc.GrpcInstanceFactory

@ExtendWith(VertxExtension::class)
class TestMyBootstrapVerticle {

    private val distributedIdApplication by lazy {
        GrpcInstanceFactory.getInstance<VertxDistributedIdApplicationGrpc.DistributedIdApplicationVertxStub>(DistributedGrpcService.DistributedId)
    }


    companion object {

        private lateinit var deployId:String

        @BeforeAll
        @JvmStatic
        fun beforeAll(vertx: Vertx,testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    deployId = vertx.deployVerticle(TestBootstrapVerticle()).await()
                }catch (t:Throwable){
                    testContext.failNow(t)
                }
                testContext.completeNow()
            }
        }

        @AfterAll
        @JvmStatic
        fun afterAll(vertx: Vertx,testContext: VertxTestContext){
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    vertx.undeploy(deployId).await()
                }catch (t:Throwable){
                    testContext.failNow(t)
                }
                testContext.completeNow()
            }
        }
    }

    @Test
    fun testGrpcBootstrap(vertx: Vertx,testContext: VertxTestContext){
        GlobalScope.launch(vertx.dispatcher()) {
            try {

                val id = distributedIdApplication.rpcRun {
                    it.distributedId(Empty.getDefaultInstance())
                }.await()


                testContext.verify { Assertions.assertNotNull(id) }
                testContext.completeNow()

            }catch (t:Throwable){
                testContext.failNow(t)
            }
        }
    }

}