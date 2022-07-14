package org.myddd.vertx.document.application

import com.google.protobuf.Int64Value
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.myddd.vertx.document.AbstractTest
import org.myddd.vertx.document.api.DocumentDTO
import org.myddd.vertx.document.api.DocumentGrpcService
import org.myddd.vertx.document.api.VertxDocumentApplicationGrpc
import org.myddd.vertx.document.domain.DocumentType
import org.myddd.vertx.grpc.GrpcInstanceFactory
import org.myddd.vertx.junit.execute
import java.util.*

class TestDocumentApplication:AbstractTest() {

    private val documentApplication by lazy {
        GrpcInstanceFactory.getInstance<VertxDocumentApplicationGrpc.DocumentApplicationVertxStub>(DocumentGrpcService.DocumentService)
    }

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
    fun testQueryByMediaId(vertx: Vertx, testContext: VertxTestContext){
        testContext.execute {
            val created = randomCreateDocument().await()

            val queryDocument = documentApplication.rpcRun {
                it.queryDocumentById(Int64Value.of(created.id))
            }.await()

            testContext.verify {
                Assertions.assertNotNull(queryDocument)
            }

            val notExists = documentApplication.rpcRun {
                it.queryDocumentById(Int64Value.of(-1))
            }.await()

            testContext.verify {
                Assertions.assertFalse(notExists.hasData())
            }
        }
    }

    private suspend fun randomCreateDocument(): Future<DocumentDTO> {
        return try {
            val documentDto = DocumentDTO.newBuilder()
                .setName(UUID.randomUUID().toString())
                .setMediaId(UUID.randomUUID().toString())
                .setDocumentType(DocumentType.File.toString())
                .setMd5(UUID.randomUUID().toString())
                .build()

            val created  = documentApplication.rpcRun {
                it.createDocument(documentDto)
            }.await()

            Future.succeededFuture(created.data)
        }catch (t:Throwable){
            Future.failedFuture(t)
        }
    }

}