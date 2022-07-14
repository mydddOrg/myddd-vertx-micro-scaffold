package org.myddd.vertx.micro.rest.bootstrap

import com.google.inject.Guice
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.kotlin.coroutines.await
import org.myddd.vertx.ioc.InstanceFactory
import org.myddd.vertx.ioc.guice.GuiceInstanceProvider
import org.myddd.vertx.micro.rest.bootstrap.route.DocumentRoute
import org.myddd.vertx.micro.rest.bootstrap.route.NodeRoute
import org.myddd.vertx.micro.strategy.BuildStrategy
import org.myddd.vertx.web.router.BootstrapVerticle

class WebBootstrapVerticle(private val buildStrategy: BuildStrategy): BootstrapVerticle(port = 8080) {



    override suspend fun initIOC(vertx: Vertx) {
        vertx.executeBlocking<Unit> {
            InstanceFactory.setInstanceProvider(GuiceInstanceProvider(Guice.createInjector(buildStrategy.guiceModule(vertx))))
            it.complete()
        }.await()
    }

    override fun routers(vertx: Vertx, router: Router): () -> Unit {
        return {
            DocumentRoute(vertx,router,this)
            NodeRoute(vertx,router,this)
        }
    }
}