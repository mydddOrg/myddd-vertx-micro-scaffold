package org.myddd.vertx.document.domain

import io.vertx.core.Future

interface DistributeID {
    suspend fun nextId():Future<Long>
}