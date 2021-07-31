package org.myddd.vertx.micro.rest.bootstrap

import com.google.inject.AbstractModule
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import org.myddd.vertx.micro.rest.bootstrap.route.DocumentRoute
import org.myddd.vertx.micro.rest.bootstrap.route.NodeRoute
import org.myddd.vertx.micro.strategy.BuildStrategy
import org.myddd.vertx.web.router.BootstrapVerticle

class WebBootstrapVerticle(private val buildStrategy: BuildStrategy): BootstrapVerticle(port = 8080) {

    override fun abstractModules(vertx: Vertx): AbstractModule {
        return buildStrategy.guiceModule(vertx)
    }

    override fun routers(vertx: Vertx, router: Router): () -> Unit {
        return {
            DocumentRoute(vertx,router)
            NodeRoute(vertx,router)
        }
    }
}