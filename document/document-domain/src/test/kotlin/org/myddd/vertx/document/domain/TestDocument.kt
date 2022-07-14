package org.myddd.vertx.document.domain

import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.myddd.vertx.junit.execute

class TestDocument : AbstractTest() {

    @Test
    fun testCreateDocument(testContext: VertxTestContext){
        testContext.execute {
            val created = randomCreateDocument().await()
            testContext.verify {
                Assertions.assertNotNull(created)
            }
        }
    }

    @Test
    fun testQueryById(testContext: VertxTestContext){
        testContext.execute {
            val created = randomCreateDocument().await()
            testContext.verify {
                Assertions.assertNotNull(created)
            }

            val query = Document.queryDocumentById(created.id).await()
            testContext.verify {
                Assertions.assertNotNull(query)
            }

            val notExists = Document.queryDocumentById(-1).await()
            testContext.verify {
                Assertions.assertNull(notExists)
            }
        }
    }


    @Test
    fun testQueryByMediaId(testContext: VertxTestContext){
        testContext.execute {
            val created = randomCreateDocument().await()
            testContext.verify {
                Assertions.assertNotNull(created)
            }

            val query = Document.queryDocumentByMediaId(mediaId = created.mediaId).await()
            testContext.verify {
                Assertions.assertNotNull(query)
            }

            val notExists = Document.queryDocumentByMediaId(mediaId = randomString()).await()
            testContext.verify {
                Assertions.assertNull(notExists)
            }
        }
    }

    private suspend fun randomCreateDocument(): Future<Document> {
        return try {
            val document = Document()
            document.mediaId = randomString()
            document.name = randomString()
            document.documentType = DocumentType.File
            document.md5 = randomString()
            document.suffix = randomString()

            document.createDocument()
        }catch (t:Throwable){
            Future.failedFuture(t)
        }
    }
}