package com.foreverht.codebee.rest.bootstrap

import com.google.inject.AbstractModule
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import org.myddd.vertx.web.router.BootstrapVerticle

class WebBootstrapVerticle: BootstrapVerticle(port = 8080) {

    override fun abstractModules(vertx: Vertx): AbstractModule {
        return GuiceModule(vertx)
    }

    override fun routers(vertx: Vertx, router: Router): () -> Unit {
        return {

        }
    }
}