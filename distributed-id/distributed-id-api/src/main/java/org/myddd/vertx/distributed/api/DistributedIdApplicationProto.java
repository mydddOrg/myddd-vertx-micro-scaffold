// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DistributedApplication.proto

package org.myddd.vertx.distributed.api;

public final class DistributedIdApplicationProto {
  private DistributedIdApplicationProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\034DistributedApplication.proto\022\037org.mydd" +
      "d.vertx.distributed.api\032\033google/protobuf" +
      "/empty.proto\032\036google/protobuf/wrappers.p" +
      "roto2b\n\030DistributedIdApplication\022F\n\rdist" +
      "ributedId\022\026.google.protobuf.Empty\032\033.goog" +
      "le.protobuf.Int64Value\"\000BB\n\037org.myddd.ve" +
      "rtx.distributed.apiB\035DistributedIdApplic" +
      "ationProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
