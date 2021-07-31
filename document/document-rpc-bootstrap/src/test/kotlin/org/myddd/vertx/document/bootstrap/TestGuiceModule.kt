package org.myddd.vertx.document.bootstrap

import io.vertx.core.Vertx
import org.myddd.vertx.distributed.application.DistributedIdApplication
import org.myddd.vertx.document.application.DocumentApplication
import org.myddd.vertx.document.domain.DistributeID
import org.myddd.vertx.document.domain.DocumentRepository
import org.myddd.vertx.document.infra.DocumentRepositoryHibernate
import org.myddd.vertx.document.infra.GrpcDistributeID
import org.myddd.vertx.grpc.GrpcInstanceProvider
import org.myddd.vertx.grpc.ServiceDiscoveryGrpcInstanceProvider

class TestGuiceModule(vertx: Vertx):AbstractWebModule(vertx) {

    override fun configure() {
        super.configure()
        bind(DocumentRepository::class.java).to(DocumentRepositoryHibernate::class.java)
        bind(DistributeID::class.java).to(GrpcDistributeID::class.java)
        bind(DocumentApplication::class.java)

        //test need
        bind(DistributedIdApplication::class.java)
    }
}