package org.myddd.vertx.document.application

import com.google.protobuf.Int64Value
import com.google.protobuf.NullValue
import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.impl.future.PromiseImpl
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.myddd.vertx.document.api.DocumentDTO
import org.myddd.vertx.document.api.DocumentGrpcService
import org.myddd.vertx.document.api.NullableDocumentDTO
import org.myddd.vertx.document.api.VertxDocumentApplicationGrpc
import org.myddd.vertx.document.application.assembler.toDTO
import org.myddd.vertx.document.application.assembler.toEntity
import org.myddd.vertx.document.application.assembler.toNullableDTO
import org.myddd.vertx.document.domain.Document
import org.myddd.vertx.grpc.BindingGrpcService
import org.myddd.vertx.grpc.GrpcService
import org.myddd.vertx.ioc.InstanceFactory
import java.util.*

class DocumentApplication:VertxDocumentApplicationGrpc.DocumentApplicationVertxImplBase(),BindingGrpcService {

    private val vertx by lazy { InstanceFactory.getInstance(Vertx::class.java) }

    override fun queryDocumentById(request: Int64Value?): Future<NullableDocumentDTO> {
        requireNotNull(request)

        val promise = PromiseImpl<NullableDocumentDTO>()
        GlobalScope.launch {
            try {
                val document = Document.queryDocumentById(request.value).await()
                if(Objects.nonNull(document)){
                    promise.onSuccess(document!!.toNullableDTO())
                }
                promise.onSuccess(NullableDocumentDTO.newBuilder().setNull(NullValue.NULL_VALUE).build())
            }catch (t:Throwable){
                t.printStackTrace()
                promise.fail(t)
            }
        }
        return promise
    }


    override fun createDocument(request: DocumentDTO?): Future<NullableDocumentDTO> {
        requireNotNull(request)

        val promise = PromiseImpl<NullableDocumentDTO>()
        GlobalScope.launch(vertx.dispatcher()) {
            try {
                val created = request.toEntity().createDocument().await()
                promise.onSuccess(created.toNullableDTO())
            }catch (t:Throwable){
                t.printStackTrace()
                promise.fail(t)
            }
        }
        return promise
    }

    override fun grpcService(): GrpcService {
        return DocumentGrpcService.DocumentService
    }
}