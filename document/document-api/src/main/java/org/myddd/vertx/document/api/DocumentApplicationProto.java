// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Document.proto

package org.myddd.vertx.document.api;

public final class DocumentApplicationProto {
  private DocumentApplicationProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_myddd_vertx_document_api_DocumentDTO_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_myddd_vertx_document_api_DocumentDTO_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_myddd_vertx_document_api_NullableDocumentDTO_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_myddd_vertx_document_api_NullableDocumentDTO_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\016Document.proto\022\034org.myddd.vertx.docume" +
      "nt.api\032\033google/protobuf/empty.proto\032\036goo" +
      "gle/protobuf/wrappers.proto\032\034google/prot" +
      "obuf/struct.proto\"[\n\013DocumentDTO\022\n\n\002id\030\001" +
      " \001(\003\022\017\n\007mediaId\030\002 \001(\t\022\014\n\004name\030\003 \001(\t\022\024\n\014d" +
      "ocumentType\030\004 \001(\t\022\013\n\003md5\030\005 \001(\t\"\204\001\n\023Nulla" +
      "bleDocumentDTO\022*\n\004null\030\001 \001(\0162\032.google.pr" +
      "otobuf.NullValueH\000\0229\n\004data\030\002 \001(\0132).org.m" +
      "yddd.vertx.document.api.DocumentDTOH\000B\006\n" +
      "\004kind2\352\001\n\023DocumentApplication\022n\n\016createD" +
      "ocument\022).org.myddd.vertx.document.api.D" +
      "ocumentDTO\0321.org.myddd.vertx.document.ap" +
      "i.NullableDocumentDTO\022c\n\021queryDocumentBy" +
      "Id\022\033.google.protobuf.Int64Value\0321.org.my" +
      "ddd.vertx.document.api.NullableDocumentD" +
      "TOB:\n\034org.myddd.vertx.document.apiB\030Docu" +
      "mentApplicationProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
          com.google.protobuf.StructProto.getDescriptor(),
        });
    internal_static_org_myddd_vertx_document_api_DocumentDTO_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_myddd_vertx_document_api_DocumentDTO_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_myddd_vertx_document_api_DocumentDTO_descriptor,
        new String[] { "Id", "MediaId", "Name", "DocumentType", "Md5", });
    internal_static_org_myddd_vertx_document_api_NullableDocumentDTO_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_org_myddd_vertx_document_api_NullableDocumentDTO_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_myddd_vertx_document_api_NullableDocumentDTO_descriptor,
        new String[] { "Null", "Data", "Kind", });
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
    com.google.protobuf.StructProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
