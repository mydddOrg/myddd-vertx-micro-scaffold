package org.myddd.vertx.distributed.api

import org.myddd.vertx.grpc.GrpcService

enum class DistributedGrpcService: GrpcService {


    DistributedId {
        override fun serviceClass(): Class<*> {
            return VertxDistributedIdApplicationGrpc::class.java
        }

        override fun stubClass(): Class<*> {
            return VertxDistributedIdApplicationGrpc.DistributedIdApplicationVertxStub::class.java
        }
    }


}