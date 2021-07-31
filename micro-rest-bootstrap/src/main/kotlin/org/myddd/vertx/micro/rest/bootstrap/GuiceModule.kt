package org.myddd.vertx.micro.rest.bootstrap

import io.vertx.core.Vertx
import org.myddd.vertx.config.Config
import org.myddd.vertx.distributed.application.DistributedIdApplication
import org.myddd.vertx.document.application.DocumentApplication
import org.myddd.vertx.document.domain.DistributeID
import org.myddd.vertx.document.domain.DocumentRepository
import org.myddd.vertx.document.infra.DocumentRepositoryHibernate
import org.myddd.vertx.document.infra.GrpcDistributeID
import org.myddd.vertx.micro.rest.bootstrap.ext.isStandalone

class GuiceModule(vertx: Vertx): AbstractWebModule(vertx = vertx) {

    override fun configure() {
        super.configure()
        if(Config.isStandalone()){
            bind(DocumentRepository::class.java).to(DocumentRepositoryHibernate::class.java)
            bind(DistributeID::class.java).to(GrpcDistributeID::class.java)
            bind(DocumentApplication::class.java)
            //test need
            bind(DistributedIdApplication::class.java)
        }
    }
}