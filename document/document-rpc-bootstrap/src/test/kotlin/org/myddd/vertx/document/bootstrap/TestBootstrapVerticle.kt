package org.myddd.vertx.document.bootstrap

import com.google.inject.AbstractModule
import io.grpc.BindableService
import io.vertx.core.Vertx
import org.myddd.vertx.distributed.application.DistributedIdApplication
import org.myddd.vertx.document.application.DocumentApplication
import org.myddd.vertx.grpc.GrpcBootstrapVerticle
import org.myddd.vertx.ioc.InstanceFactory

class TestBootstrapVerticle : GrpcBootstrapVerticle(){


    override suspend fun start() {
        super.start()
    }

    override fun abstractModules(vertx: Vertx): AbstractModule? {
        return TestGuiceModule(vertx)
    }


    override fun services(): List<BindableService> {
        return arrayListOf(
            DocumentApplication(),
            DistributedIdApplication()

        )
    }
}