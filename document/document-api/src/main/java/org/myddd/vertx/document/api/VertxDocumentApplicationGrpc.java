package org.myddd.vertx.document.api;

import static org.myddd.vertx.document.api.DocumentApplicationGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by VertxGrpc generator",
comments = "Source: Document.proto")
public final class VertxDocumentApplicationGrpc {
    private VertxDocumentApplicationGrpc() {}

    public static DocumentApplicationVertxStub newVertxStub(io.grpc.Channel channel) {
        return new DocumentApplicationVertxStub(channel);
    }

    
    public static final class DocumentApplicationVertxStub extends io.grpc.stub.AbstractStub<DocumentApplicationVertxStub> {
        private final io.vertx.core.impl.ContextInternal ctx;
        private DocumentApplicationGrpc.DocumentApplicationStub delegateStub;

        private DocumentApplicationVertxStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = DocumentApplicationGrpc.newStub(channel);
            this.ctx = (io.vertx.core.impl.ContextInternal) io.vertx.core.Vertx.currentContext();
        }

        private DocumentApplicationVertxStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = DocumentApplicationGrpc.newStub(channel).build(channel, callOptions);
            this.ctx = (io.vertx.core.impl.ContextInternal) io.vertx.core.Vertx.currentContext();
        }

        @Override
        protected DocumentApplicationVertxStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentApplicationVertxStub(channel, callOptions);
        }

        
        public io.vertx.core.Future<NullableDocumentDTO> createDocument(DocumentDTO request) {
            return io.vertx.grpc.stub.ClientCalls.oneToOne(ctx, request, delegateStub::createDocument);
        }

        
        public io.vertx.core.Future<NullableDocumentDTO> queryDocumentById(com.google.protobuf.Int64Value request) {
            return io.vertx.grpc.stub.ClientCalls.oneToOne(ctx, request, delegateStub::queryDocumentById);
        }

    }

    
    public static abstract class DocumentApplicationVertxImplBase implements io.grpc.BindableService {
        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public DocumentApplicationVertxImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        
        public io.vertx.core.Future<NullableDocumentDTO> createDocument(DocumentDTO request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        
        public io.vertx.core.Future<NullableDocumentDTO> queryDocumentById(com.google.protobuf.Int64Value request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            DocumentApplicationGrpc.getCreateDocumentMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            DocumentDTO,
                                            NullableDocumentDTO>(
                                            this, METHODID_CREATE_DOCUMENT, compression)))
                    .addMethod(
                            DocumentApplicationGrpc.getQueryDocumentByIdMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.google.protobuf.Int64Value,
                                            NullableDocumentDTO>(
                                            this, METHODID_QUERY_DOCUMENT_BY_ID, compression)))
                    .build();
        }
    }

    private static final int METHODID_CREATE_DOCUMENT = 0;
    private static final int METHODID_QUERY_DOCUMENT_BY_ID = 1;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final DocumentApplicationVertxImplBase serviceImpl;
        private final int methodId;
        private final String compression;

        MethodHandlers(DocumentApplicationVertxImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE_DOCUMENT:
                    io.vertx.grpc.stub.ServerCalls.oneToOne(
                            (DocumentDTO) request,
                            (io.grpc.stub.StreamObserver<NullableDocumentDTO>) responseObserver,
                            compression,
                            serviceImpl::createDocument);
                    break;
                case METHODID_QUERY_DOCUMENT_BY_ID:
                    io.vertx.grpc.stub.ServerCalls.oneToOne(
                            (com.google.protobuf.Int64Value) request,
                            (io.grpc.stub.StreamObserver<NullableDocumentDTO>) responseObserver,
                            compression,
                            serviceImpl::queryDocumentById);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

}
