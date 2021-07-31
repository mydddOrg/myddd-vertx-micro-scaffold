package org.myddd.vertx.micro.rest.bootstrap

import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.await
import org.myddd.vertx.config.Config
import org.myddd.vertx.grpc.GrpcHealthCheckVerticle
import org.myddd.vertx.micro.rest.bootstrap.ext.isStandalone

class MyBootstrapVerticle: CoroutineVerticle() {

    companion object {
        private val deployIds = mutableListOf<String>()
    }
    override suspend fun start() {
        super.start()
        deployIds.add(vertx.deployVerticle(WebBootstrapVerticle()).await())

        if(Config.isStandalone()){
            deployIds.add(vertx.deployVerticle(GrpcServiceBootstrapVerticle()).await())
        }
    }

    override suspend fun stop() {
        super.stop()
        deployIds.forEach {
            vertx.undeploy(it).await()
        }
    }
}