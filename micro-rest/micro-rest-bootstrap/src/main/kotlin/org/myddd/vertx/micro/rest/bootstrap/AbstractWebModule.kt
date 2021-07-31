package org.myddd.vertx.micro.rest.bootstrap

import com.google.inject.AbstractModule
import io.vertx.core.Vertx
import io.vertx.ext.web.client.WebClient
import org.myddd.vertx.grpc.GrpcInstanceProvider
import org.myddd.vertx.grpc.ServiceDiscoveryGrpcInstanceProvider
import org.myddd.vertx.string.RandomIDString
import org.myddd.vertx.string.RandomIDStringProvider

open abstract class AbstractWebModule(private val vertx: Vertx) : AbstractModule() {

    override fun configure(){
        bind(Vertx::class.java).toInstance(vertx)
        bind(GrpcInstanceProvider::class.java).to(ServiceDiscoveryGrpcInstanceProvider::class.java)
        bind(RandomIDString::class.java).to(RandomIDStringProvider::class.java)
        bind(WebClient::class.java).toInstance(WebClient.create(vertx))
    }

}