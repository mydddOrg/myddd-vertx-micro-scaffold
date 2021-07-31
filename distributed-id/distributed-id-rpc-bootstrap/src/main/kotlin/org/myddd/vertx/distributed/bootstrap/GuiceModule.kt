package org.myddd.vertx.distributed.bootstrap

import io.vertx.core.Vertx
import org.myddd.vertx.distributed.application.DistributedIdApplication
import org.myddd.vertx.id.IDGenerator
import org.myddd.vertx.id.SnowflakeDistributeId

class GuiceModule(vertx: Vertx): AbstractWebModule(vertx = vertx) {

    override fun configure() {
        super.configure()
        bind(IDGenerator::class.java).toInstance(SnowflakeDistributeId())
        bind(DistributedIdApplication::class.java)
    }
}