package org.myddd.vertx.document.infra

import io.vertx.core.Future
import io.vertx.kotlin.coroutines.await
import org.myddd.vertx.distributed.api.DistributedGrpcService
import org.myddd.vertx.distributed.api.VertxDistributedIdApplicationGrpc
import org.myddd.vertx.document.domain.DistributeID
import org.myddd.vertx.grpc.GrpcInstanceFactory

class GrpcDistributeID:DistributeID {

    private val distributeApplication by lazy {
        GrpcInstanceFactory.getInstance< VertxDistributedIdApplicationGrpc.DistributedIdApplicationVertxStub>(DistributedGrpcService.DistributedId)
    }

    override suspend fun nextId(): Future<Long> {
        return try {
             val nextId = distributeApplication.rpcRun {
                it.distributedId(com.google.protobuf.Empty.getDefaultInstance())
            }.await()
            Future.succeededFuture(nextId.value)
        }catch (t:Throwable){
            Future.failedFuture(t)
        }
    }
}