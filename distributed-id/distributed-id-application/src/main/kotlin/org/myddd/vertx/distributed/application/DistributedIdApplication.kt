package org.myddd.vertx.distributed.application

import com.google.protobuf.Empty
import com.google.protobuf.Int64Value
import io.vertx.core.Future
import org.myddd.vertx.distributed.api.DistributedGrpcService
import org.myddd.vertx.distributed.api.VertxDistributedIdApplicationGrpc
import org.myddd.vertx.grpc.BindingGrpcService
import org.myddd.vertx.grpc.GrpcService
import org.myddd.vertx.id.IDGenerator
import org.myddd.vertx.ioc.InstanceFactory

class DistributedIdApplication:VertxDistributedIdApplicationGrpc.DistributedIdApplicationVertxImplBase(),
    BindingGrpcService {

    private val idGenerator by lazy { InstanceFactory.getInstance(IDGenerator::class.java) }

    override fun distributedId(request: Empty?): Future<Int64Value> {
        return try {
            Future.succeededFuture(Int64Value.of(idGenerator.nextId()))
        }catch (t:Throwable){
            t.printStackTrace()
            Future.failedFuture(t)
        }
    }

    override fun grpcService(): GrpcService {
        return DistributedGrpcService.DistributedId
    }

}