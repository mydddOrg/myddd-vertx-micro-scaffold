package org.myddd.vertx.document.infra

import io.vertx.core.Future
import org.myddd.vertx.document.domain.Document
import org.myddd.vertx.document.domain.DocumentRepository
import org.myddd.vertx.repository.hibernate.EntityRepositoryHibernate

class DocumentRepositoryHibernate:EntityRepositoryHibernate(), DocumentRepository {

    override suspend fun queryDocumentByMediaId(mediaId: String): Future<Document?> {
        return try {
            this.singleQuery(
                clazz = Document::class.java,
                sql = "from Document where mediaId = :mediaId",
                params = mapOf(
                    "mediaId" to mediaId
                )
            )
        }catch (t:Throwable){
            Future.failedFuture(t)
        }
    }
}