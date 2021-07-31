package org.myddd.vertx.document.api;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Document.proto")
public final class DocumentApplicationGrpc {

  private DocumentApplicationGrpc() {}

  public static final String SERVICE_NAME = "org.myddd.vertx.document.api.DocumentApplication";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<DocumentDTO,
      NullableDocumentDTO> getCreateDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createDocument",
      requestType = DocumentDTO.class,
      responseType = NullableDocumentDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DocumentDTO,
      NullableDocumentDTO> getCreateDocumentMethod() {
    io.grpc.MethodDescriptor<DocumentDTO, NullableDocumentDTO> getCreateDocumentMethod;
    if ((getCreateDocumentMethod = DocumentApplicationGrpc.getCreateDocumentMethod) == null) {
      synchronized (DocumentApplicationGrpc.class) {
        if ((getCreateDocumentMethod = DocumentApplicationGrpc.getCreateDocumentMethod) == null) {
          DocumentApplicationGrpc.getCreateDocumentMethod = getCreateDocumentMethod =
              io.grpc.MethodDescriptor.<DocumentDTO, NullableDocumentDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createDocument"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DocumentDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  NullableDocumentDTO.getDefaultInstance()))
              .setSchemaDescriptor(new DocumentApplicationMethodDescriptorSupplier("createDocument"))
              .build();
        }
      }
    }
    return getCreateDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      NullableDocumentDTO> getQueryDocumentByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "queryDocumentById",
      requestType = com.google.protobuf.Int64Value.class,
      responseType = NullableDocumentDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      NullableDocumentDTO> getQueryDocumentByIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int64Value, NullableDocumentDTO> getQueryDocumentByIdMethod;
    if ((getQueryDocumentByIdMethod = DocumentApplicationGrpc.getQueryDocumentByIdMethod) == null) {
      synchronized (DocumentApplicationGrpc.class) {
        if ((getQueryDocumentByIdMethod = DocumentApplicationGrpc.getQueryDocumentByIdMethod) == null) {
          DocumentApplicationGrpc.getQueryDocumentByIdMethod = getQueryDocumentByIdMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Int64Value, NullableDocumentDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "queryDocumentById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int64Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  NullableDocumentDTO.getDefaultInstance()))
              .setSchemaDescriptor(new DocumentApplicationMethodDescriptorSupplier("queryDocumentById"))
              .build();
        }
      }
    }
    return getQueryDocumentByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DocumentApplicationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentApplicationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocumentApplicationStub>() {
        @Override
        public DocumentApplicationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocumentApplicationStub(channel, callOptions);
        }
      };
    return DocumentApplicationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocumentApplicationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentApplicationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocumentApplicationBlockingStub>() {
        @Override
        public DocumentApplicationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocumentApplicationBlockingStub(channel, callOptions);
        }
      };
    return DocumentApplicationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DocumentApplicationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentApplicationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocumentApplicationFutureStub>() {
        @Override
        public DocumentApplicationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocumentApplicationFutureStub(channel, callOptions);
        }
      };
    return DocumentApplicationFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DocumentApplicationImplBase implements io.grpc.BindableService {

    /**
     */
    public void createDocument(DocumentDTO request,
                               io.grpc.stub.StreamObserver<NullableDocumentDTO> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDocumentMethod(), responseObserver);
    }

    /**
     */
    public void queryDocumentById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<NullableDocumentDTO> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryDocumentByIdMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                DocumentDTO,
                NullableDocumentDTO>(
                  this, METHODID_CREATE_DOCUMENT)))
          .addMethod(
            getQueryDocumentByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int64Value,
                NullableDocumentDTO>(
                  this, METHODID_QUERY_DOCUMENT_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class DocumentApplicationStub extends io.grpc.stub.AbstractAsyncStub<DocumentApplicationStub> {
    private DocumentApplicationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DocumentApplicationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentApplicationStub(channel, callOptions);
    }

    /**
     */
    public void createDocument(DocumentDTO request,
                               io.grpc.stub.StreamObserver<NullableDocumentDTO> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDocumentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void queryDocumentById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<NullableDocumentDTO> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryDocumentByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DocumentApplicationBlockingStub extends io.grpc.stub.AbstractBlockingStub<DocumentApplicationBlockingStub> {
    private DocumentApplicationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DocumentApplicationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentApplicationBlockingStub(channel, callOptions);
    }

    /**
     */
    public NullableDocumentDTO createDocument(DocumentDTO request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDocumentMethod(), getCallOptions(), request);
    }

    /**
     */
    public NullableDocumentDTO queryDocumentById(com.google.protobuf.Int64Value request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryDocumentByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DocumentApplicationFutureStub extends io.grpc.stub.AbstractFutureStub<DocumentApplicationFutureStub> {
    private DocumentApplicationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DocumentApplicationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentApplicationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<NullableDocumentDTO> createDocument(
        DocumentDTO request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDocumentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<NullableDocumentDTO> queryDocumentById(
        com.google.protobuf.Int64Value request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryDocumentByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DOCUMENT = 0;
  private static final int METHODID_QUERY_DOCUMENT_BY_ID = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DocumentApplicationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DocumentApplicationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DOCUMENT:
          serviceImpl.createDocument((DocumentDTO) request,
              (io.grpc.stub.StreamObserver<NullableDocumentDTO>) responseObserver);
          break;
        case METHODID_QUERY_DOCUMENT_BY_ID:
          serviceImpl.queryDocumentById((com.google.protobuf.Int64Value) request,
              (io.grpc.stub.StreamObserver<NullableDocumentDTO>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DocumentApplicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentApplicationBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DocumentApplicationProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DocumentApplication");
    }
  }

  private static final class DocumentApplicationFileDescriptorSupplier
      extends DocumentApplicationBaseDescriptorSupplier {
    DocumentApplicationFileDescriptorSupplier() {}
  }

  private static final class DocumentApplicationMethodDescriptorSupplier
      extends DocumentApplicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DocumentApplicationMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DocumentApplicationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DocumentApplicationFileDescriptorSupplier())
              .addMethod(getCreateDocumentMethod())
              .addMethod(getQueryDocumentByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
