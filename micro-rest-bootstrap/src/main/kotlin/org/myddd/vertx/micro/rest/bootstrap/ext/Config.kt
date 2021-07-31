package org.myddd.vertx.micro.rest.bootstrap.ext

import org.myddd.vertx.config.Config

fun Config.isStandalone():Boolean {
    return this.getBoolean("standalone")
}