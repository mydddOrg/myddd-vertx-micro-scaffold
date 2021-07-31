package org.myddd.vertx.distributed.bootstrap

import com.google.inject.AbstractModule
import io.vertx.core.Vertx
import io.vertx.ext.web.client.WebClient
import org.myddd.vertx.distributed.application.DistributedIdApplication
import org.myddd.vertx.file.FileDigest
import org.myddd.vertx.file.FileDigestProvider
import org.myddd.vertx.grpc.GrpcInstanceProvider
import org.myddd.vertx.grpc.ServiceDiscoveryGrpcInstanceProvider
import org.myddd.vertx.i18n.I18N
import org.myddd.vertx.i18n.provider.I18NVertxProvider
import org.myddd.vertx.string.RandomIDString
import org.myddd.vertx.string.RandomIDStringProvider

abstract class AbstractWebModule(private val vertx: Vertx) : AbstractModule() {


    override fun configure(){
        bind(Vertx::class.java).toInstance(vertx)
        bind(GrpcInstanceProvider::class.java).to(ServiceDiscoveryGrpcInstanceProvider::class.java)

        bind(WebClient::class.java).toInstance(WebClient.create(vertx))
        bind(RandomIDString::class.java).to(RandomIDStringProvider::class.java)
        bind(FileDigest::class.java).to(FileDigestProvider::class.java)
        bind(I18N::class.java).to(I18NVertxProvider::class.java)

    }

}