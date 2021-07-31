package org.myddd.vertx.distributed.application

import com.google.protobuf.Empty
import io.vertx.core.Vertx
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.myddd.vertx.distributed.AbstractTest
import org.myddd.vertx.distributed.api.DistributedGrpcService
import org.myddd.vertx.distributed.api.VertxDistributedIdApplicationGrpc
import org.myddd.vertx.grpc.GrpcInstanceFactory

class TestDistributedIdApplication:AbstractTest() {

    private val distributedIdApplicationProxy by lazy {
        GrpcInstanceFactory.getInstance<VertxDistributedIdApplicationGrpc.DistributedIdApplicationVertxStub>(DistributedGrpcService.DistributedId)
    }

    @Test
    fun testDistributeId(vertx: Vertx,testContext: VertxTestContext){
        GlobalScope.launch(vertx.dispatcher()) {
            try {
                val randomId = distributedIdApplicationProxy.rpcRun {
                    it.distributedId(Empty.getDefaultInstance())
                }.await()

                testContext.verify {
                    Assertions.assertNotNull(randomId)
                }
            }catch (t:Throwable){
                testContext.failNow(t)
            }
            testContext.completeNow()
        }

    }
}