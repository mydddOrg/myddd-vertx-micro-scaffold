package org.myddd.vertx.document.domain

import io.vertx.core.Future
import org.myddd.vertx.repository.api.EntityRepository

interface DocumentRepository:EntityRepository {
    suspend fun queryDocumentByMediaId(mediaId: String): Future<Document?>
}