package org.myddd.vertx.micro.rest.strategy

import com.google.inject.AbstractModule
import io.vertx.core.Vertx
import io.vertx.kotlin.coroutines.CoroutineVerticle
import org.myddd.vertx.micro.strategy.BuildStrategy

class LocalBuildStrategy: BuildStrategy {

    override fun guiceModule(vertx: Vertx): AbstractModule {
        return LocalGuiceModule(vertx)
    }

    override fun verticleList(vertx: Vertx): List<CoroutineVerticle> {
        return arrayListOf(
            GrpcServiceBootstrapVerticle()
        )
    }
}