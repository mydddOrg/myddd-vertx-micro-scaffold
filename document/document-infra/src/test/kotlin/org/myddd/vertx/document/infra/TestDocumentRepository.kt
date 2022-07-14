package org.myddd.vertx.document.infra

import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.myddd.vertx.document.domain.Document
import org.myddd.vertx.document.domain.DocumentRepository
import org.myddd.vertx.document.domain.DocumentType
import org.myddd.vertx.ioc.InstanceFactory
import kotlin.random.Random
import kotlin.random.nextULong

class TestDocumentRepository:AbstractTest() {


    private val documentRepository by lazy { InstanceFactory.getInstance(DocumentRepository::class.java) }


    @Test
    fun testQueryByMediaId(vertx: Vertx,testContext: VertxTestContext){
        GlobalScope.launch(vertx.dispatcher()) {
            try {
                val created = randomCreateDocument().await()
                testContext.verify {
                    Assertions.assertNotNull(created)
                }

                val query = documentRepository.queryDocumentByMediaId(mediaId = created.mediaId).await()
                testContext.verify {
                    Assertions.assertNotNull(query)
                }

                val notExists = documentRepository.queryDocumentByMediaId(mediaId = randomString()).await()
                testContext.verify {
                    Assertions.assertNull(notExists)
                }
            }catch (t:Throwable){
                testContext.failNow(t)
            }
            testContext.completeNow()
        }
    }

    private suspend fun randomCreateDocument():Future<Document>{
        return try {
            val document = Document()
            document.id = Random.nextLong(1,Long.MAX_VALUE);
            document.mediaId = randomString()
            document.name = randomString()
            document.documentType = DocumentType.File
            document.md5 = randomString()
            document.suffix = randomString()

            documentRepository.save(document)
        }catch (t:Throwable){
            Future.failedFuture(t)
        }
    }

}