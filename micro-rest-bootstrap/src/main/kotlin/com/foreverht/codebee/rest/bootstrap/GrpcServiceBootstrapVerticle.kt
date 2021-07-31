package com.foreverht.codebee.rest.bootstrap

import com.google.inject.AbstractModule
import io.grpc.BindableService
import io.vertx.core.Vertx
import org.myddd.vertx.grpc.GrpcBootstrapVerticle

class GrpcServiceBootstrapVerticle:GrpcBootstrapVerticle() {

    override fun abstractModules(vertx: Vertx): AbstractModule? {
        return null
    }

    override fun services(): List<BindableService> {
        return arrayListOf(
        )
    }
}