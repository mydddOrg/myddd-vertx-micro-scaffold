package org.myddd.vertx.document.application

import org.myddd.vertx.document.application.assembler.toDocument
import org.myddd.vertx.document.application.assembler.toDocumentDTO
import io.vertx.core.Future
import io.vertx.kotlin.coroutines.await
import org.myddd.vertx.document.api.DocumentApplication
import org.myddd.vertx.document.api.DocumentDTO
import org.myddd.vertx.document.domain.Document
import java.util.*

class DocumentApplicationImpl: DocumentApplication {

    override suspend fun createDocument(documentDTO: DocumentDTO): Future<DocumentDTO> {
        return try {
            val created = toDocument(documentDTO).createDocument().await()
            Future.succeededFuture(toDocumentDTO(created))
        }catch (t:Throwable){
            Future.failedFuture(t)
        }
    }

    override suspend fun queryDocumentById(id: Long): Future<DocumentDTO?> {
        return try {
            val queryDocument = Document.queryDocumentById(id).await()
            if(Objects.nonNull(queryDocument)){
                Future.succeededFuture(toDocumentDTO(queryDocument!!))
            }else{
                Future.succeededFuture(null)
            }
        }catch (t:Throwable){
            Future.failedFuture(t)
        }
    }
}