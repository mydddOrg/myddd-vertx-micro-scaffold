package org.myddd.vertx.distributed.api;

import static org.myddd.vertx.distributed.api.DistributedIdApplicationGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by VertxGrpc generator",
comments = "Source: DistributedApplication.proto")
public final class VertxDistributedIdApplicationGrpc {
    private VertxDistributedIdApplicationGrpc() {}

    public static DistributedIdApplicationVertxStub newVertxStub(io.grpc.Channel channel) {
        return new DistributedIdApplicationVertxStub(channel);
    }

    
    public static final class DistributedIdApplicationVertxStub extends io.grpc.stub.AbstractStub<DistributedIdApplicationVertxStub> {
        private final io.vertx.core.impl.ContextInternal ctx;
        private DistributedIdApplicationGrpc.DistributedIdApplicationStub delegateStub;

        private DistributedIdApplicationVertxStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = DistributedIdApplicationGrpc.newStub(channel);
            this.ctx = (io.vertx.core.impl.ContextInternal) io.vertx.core.Vertx.currentContext();
        }

        private DistributedIdApplicationVertxStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = DistributedIdApplicationGrpc.newStub(channel).build(channel, callOptions);
            this.ctx = (io.vertx.core.impl.ContextInternal) io.vertx.core.Vertx.currentContext();
        }

        @Override
        protected DistributedIdApplicationVertxStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DistributedIdApplicationVertxStub(channel, callOptions);
        }

        
        public io.vertx.core.Future<com.google.protobuf.Int64Value> distributedId(com.google.protobuf.Empty request) {
            return io.vertx.grpc.stub.ClientCalls.oneToOne(ctx, request, delegateStub::distributedId);
        }

    }

    
    public static abstract class DistributedIdApplicationVertxImplBase implements io.grpc.BindableService {
        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public DistributedIdApplicationVertxImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        
        public io.vertx.core.Future<com.google.protobuf.Int64Value> distributedId(com.google.protobuf.Empty request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            DistributedIdApplicationGrpc.getDistributedIdMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.google.protobuf.Empty,
                                            com.google.protobuf.Int64Value>(
                                            this, METHODID_DISTRIBUTED_ID, compression)))
                    .build();
        }
    }

    private static final int METHODID_DISTRIBUTED_ID = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final DistributedIdApplicationVertxImplBase serviceImpl;
        private final int methodId;
        private final String compression;

        MethodHandlers(DistributedIdApplicationVertxImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_DISTRIBUTED_ID:
                    io.vertx.grpc.stub.ServerCalls.oneToOne(
                            (com.google.protobuf.Empty) request,
                            (io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value>) responseObserver,
                            compression,
                            serviceImpl::distributedId);
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
