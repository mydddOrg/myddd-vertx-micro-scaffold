package org.myddd.vertx.micro.rest.bootstrap

import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.await
import org.myddd.vertx.micro.strategy.BuildStrategy

class MyBootstrapVerticle: CoroutineVerticle() {

    companion object {
        private val deployIds = mutableListOf<String>()
        private val buildStrategy by lazy {
            BuildStrategy.getBuildStrategy()
        }
    }

    override suspend fun start() {
        super.start()
        deployIds.add(vertx.deployVerticle(WebBootstrapVerticle(buildStrategy)).await())
        val verticleList = buildStrategy.verticleList(vertx)
        verticleList.forEach {
            deployIds.add(vertx.deployVerticle(it).await())
        }
    }

    override suspend fun stop() {
        super.stop()
        deployIds.forEach {
            vertx.undeploy(it).await()
        }
    }
}