package com.foreverht.codebee.rest.bootstrap

import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.await
import org.myddd.vertx.config.Config
import org.myddd.vertx.grpc.GrpcHealthCheckVerticle

class MyBootstrapVerticle: CoroutineVerticle() {

    companion object {
        private val deployIds = mutableListOf<String>()
    }
    override suspend fun start() {
        super.start()
        deployIds.add(vertx.deployVerticle(WebBootstrapVerticle()).await())
        if(Config.getBoolean("standalone",false)){
            deployIds.add(vertx.deployVerticle(GrpcServiceBootstrapVerticle()).await())
        }
//        else{
//            deployIds.add(vertx.deployVerticle(GrpcHealthCheckVerticle()).await())
//        }
    }

    override suspend fun stop() {
        super.stop()
        deployIds.forEach {
            vertx.undeploy(it).await()
        }
    }
}