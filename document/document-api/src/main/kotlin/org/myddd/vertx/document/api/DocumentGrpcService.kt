package org.myddd.vertx.document.api

import org.myddd.vertx.grpc.GrpcService

enum class DocumentGrpcService: GrpcService {

    DocumentService;

    override fun serviceClass(): Class<*> {
        return VertxDocumentApplicationGrpc::class.java
    }

    override fun stubClass(): Class<*> {
        return VertxDocumentApplicationGrpc.DocumentApplicationVertxStub::class.java
    }}