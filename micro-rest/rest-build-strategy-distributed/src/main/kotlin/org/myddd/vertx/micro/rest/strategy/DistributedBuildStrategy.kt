package org.myddd.vertx.micro.rest.strategy

import io.vertx.core.Vertx
import io.vertx.kotlin.coroutines.CoroutineVerticle
import org.myddd.vertx.micro.strategy.BuildStrategy

class DistributedBuildStrategy: BuildStrategy {

    override fun guiceModule(vertx: Vertx): DistributedWebModule {
        return DistributedWebModule(vertx)
    }

    override fun verticleList(vertx: Vertx): List<CoroutineVerticle> {
        return arrayListOf()
    }
}