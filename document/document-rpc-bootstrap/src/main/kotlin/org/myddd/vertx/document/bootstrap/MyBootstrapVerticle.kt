package org.myddd.vertx.document.bootstrap

import com.google.inject.AbstractModule
import io.grpc.BindableService
import io.vertx.core.Vertx
import org.myddd.vertx.document.application.DocumentApplication
import org.myddd.vertx.grpc.GrpcBootstrapVerticle
import org.myddd.vertx.ioc.InstanceFactory

class MyBootstrapVerticle : GrpcBootstrapVerticle(){


    override suspend fun start() {
        super.start()
    }

    override fun abstractModules(vertx: Vertx): AbstractModule? {
        return GuiceModule(vertx)
    }


    override fun services(): List<BindableService> {
        return arrayListOf(
            InstanceFactory.getInstance(DocumentApplication::class.java)
        )
    }
}