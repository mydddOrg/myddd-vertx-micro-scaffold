package org.myddd.vertx.document

import io.grpc.BindableService
import org.myddd.vertx.distributed.application.DistributedIdApplication
import org.myddd.vertx.document.application.DocumentApplication
import org.myddd.vertx.grpc.GrpcBootstrapVerticle

class AbstractGrpcBootstrapVerticle: GrpcBootstrapVerticle() {

    override fun services(): List<BindableService> {
        return arrayListOf(
            DistributedIdApplication(),
            DocumentApplication()
        )
    }

}