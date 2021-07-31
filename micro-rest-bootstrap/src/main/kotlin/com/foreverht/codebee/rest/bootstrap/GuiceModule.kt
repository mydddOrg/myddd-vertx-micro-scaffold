package com.foreverht.codebee.rest.bootstrap

import io.vertx.core.Vertx

class GuiceModule(vertx: Vertx):AbstractWebModule(vertx = vertx) {

    override fun configure() {
        super.configure()
    }
}