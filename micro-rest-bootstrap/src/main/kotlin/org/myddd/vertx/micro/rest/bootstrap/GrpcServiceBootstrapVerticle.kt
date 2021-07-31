package org.myddd.vertx.micro.rest.bootstrap

import com.google.inject.AbstractModule
import io.grpc.BindableService
import io.vertx.core.Vertx
import org.myddd.vertx.distributed.application.DistributedIdApplication
import org.myddd.vertx.document.application.DocumentApplication
import org.myddd.vertx.grpc.GrpcBootstrapVerticle

class GrpcServiceBootstrapVerticle:GrpcBootstrapVerticle() {

    override fun abstractModules(vertx: Vertx): AbstractModule? {
        return null
    }

    override fun services(): List<BindableService> {
        return arrayListOf(
            DocumentApplication(),
            DistributedIdApplication()
        )
    }
}