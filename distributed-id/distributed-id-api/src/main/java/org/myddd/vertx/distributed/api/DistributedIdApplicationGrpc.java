package org.myddd.vertx.distributed.api;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: DistributedApplication.proto")
public final class DistributedIdApplicationGrpc {

  private DistributedIdApplicationGrpc() {}

  public static final String SERVICE_NAME = "org.myddd.vertx.distributed.api.DistributedIdApplication";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Int64Value> getDistributedIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "distributedId",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Int64Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Int64Value> getDistributedIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Int64Value> getDistributedIdMethod;
    if ((getDistributedIdMethod = DistributedIdApplicationGrpc.getDistributedIdMethod) == null) {
      synchronized (DistributedIdApplicationGrpc.class) {
        if ((getDistributedIdMethod = DistributedIdApplicationGrpc.getDistributedIdMethod) == null) {
          DistributedIdApplicationGrpc.getDistributedIdMethod = getDistributedIdMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Int64Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "distributedId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int64Value.getDefaultInstance()))
              .setSchemaDescriptor(new DistributedIdApplicationMethodDescriptorSupplier("distributedId"))
              .build();
        }
      }
    }
    return getDistributedIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DistributedIdApplicationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DistributedIdApplicationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DistributedIdApplicationStub>() {
        @Override
        public DistributedIdApplicationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DistributedIdApplicationStub(channel, callOptions);
        }
      };
    return DistributedIdApplicationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DistributedIdApplicationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DistributedIdApplicationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DistributedIdApplicationBlockingStub>() {
        @Override
        public DistributedIdApplicationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DistributedIdApplicationBlockingStub(channel, callOptions);
        }
      };
    return DistributedIdApplicationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DistributedIdApplicationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DistributedIdApplicationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DistributedIdApplicationFutureStub>() {
        @Override
        public DistributedIdApplicationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DistributedIdApplicationFutureStub(channel, callOptions);
        }
      };
    return DistributedIdApplicationFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DistributedIdApplicationImplBase implements io.grpc.BindableService {

    /**
     */
    public void distributedId(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDistributedIdMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDistributedIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.google.protobuf.Int64Value>(
                  this, METHODID_DISTRIBUTED_ID)))
          .build();
    }
  }

  /**
   */
  public static final class DistributedIdApplicationStub extends io.grpc.stub.AbstractAsyncStub<DistributedIdApplicationStub> {
    private DistributedIdApplicationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DistributedIdApplicationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DistributedIdApplicationStub(channel, callOptions);
    }

    /**
     */
    public void distributedId(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDistributedIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DistributedIdApplicationBlockingStub extends io.grpc.stub.AbstractBlockingStub<DistributedIdApplicationBlockingStub> {
    private DistributedIdApplicationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DistributedIdApplicationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DistributedIdApplicationBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Int64Value distributedId(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDistributedIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DistributedIdApplicationFutureStub extends io.grpc.stub.AbstractFutureStub<DistributedIdApplicationFutureStub> {
    private DistributedIdApplicationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected DistributedIdApplicationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DistributedIdApplicationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Int64Value> distributedId(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDistributedIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DISTRIBUTED_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DistributedIdApplicationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DistributedIdApplicationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DISTRIBUTED_ID:
          serviceImpl.distributedId((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value>) responseObserver);
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

  private static abstract class DistributedIdApplicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DistributedIdApplicationBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DistributedIdApplicationProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DistributedIdApplication");
    }
  }

  private static final class DistributedIdApplicationFileDescriptorSupplier
      extends DistributedIdApplicationBaseDescriptorSupplier {
    DistributedIdApplicationFileDescriptorSupplier() {}
  }

  private static final class DistributedIdApplicationMethodDescriptorSupplier
      extends DistributedIdApplicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DistributedIdApplicationMethodDescriptorSupplier(String methodName) {
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
      synchronized (DistributedIdApplicationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DistributedIdApplicationFileDescriptorSupplier())
              .addMethod(getDistributedIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
