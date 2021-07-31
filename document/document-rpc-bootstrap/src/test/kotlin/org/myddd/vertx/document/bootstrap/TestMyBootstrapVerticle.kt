package org.myddd.vertx.document.bootstrap

import com.google.protobuf.Empty
import io.vertx.core.Vertx
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.myddd.vertx.distributed.api.DistributedGrpcService
import org.myddd.vertx.distributed.api.VertxDistributedIdApplicationGrpc
import org.myddd.vertx.grpc.GrpcInstanceFactory

class TestMyBootstrapVerticle: AbstractTest() {

    private val distributedIdApplication by lazy {
        GrpcInstanceFactory.getInstance<VertxDistributedIdApplicationGrpc.DistributedIdApplicationVertxStub>(DistributedGrpcService.DistributedId)
    }

    @Test
    fun testGrpcBootstrap(vertx: Vertx,testContext: VertxTestContext){
        GlobalScope.launch(vertx.dispatcher()) {
            try {

                val id = distributedIdApplication.rpcRun {
                    it.distributedId(Empty.getDefaultInstance())
                }.await()


                testContext.verify { Assertions.assertNotNull(id) }

            }catch (t:Throwable){
                testContext.failNow(t)
            }
            testContext.completeNow()
        }
    }

}