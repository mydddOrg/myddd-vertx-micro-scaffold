// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Document.proto

package org.myddd.vertx.document.api;

/**
 * Protobuf type {@code org.myddd.vertx.document.api.NullableDocumentDTO}
 */
public final class NullableDocumentDTO extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:org.myddd.vertx.document.api.NullableDocumentDTO)
    NullableDocumentDTOOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NullableDocumentDTO.newBuilder() to construct.
  private NullableDocumentDTO(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NullableDocumentDTO() {
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new NullableDocumentDTO();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NullableDocumentDTO(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();
            kindCase_ = 1;
            kind_ = rawValue;
            break;
          }
          case 18: {
            DocumentDTO.Builder subBuilder = null;
            if (kindCase_ == 2) {
              subBuilder = ((DocumentDTO) kind_).toBuilder();
            }
            kind_ =
                input.readMessage(DocumentDTO.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((DocumentDTO) kind_);
              kind_ = subBuilder.buildPartial();
            }
            kindCase_ = 2;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return DocumentApplicationProto.internal_static_org_myddd_vertx_document_api_NullableDocumentDTO_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return DocumentApplicationProto.internal_static_org_myddd_vertx_document_api_NullableDocumentDTO_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            NullableDocumentDTO.class, Builder.class);
  }

  private int kindCase_ = 0;
  private Object kind_;
  public enum KindCase
      implements com.google.protobuf.Internal.EnumLite,
          InternalOneOfEnum {
    NULL(1),
    DATA(2),
    KIND_NOT_SET(0);
    private final int value;
    private KindCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @Deprecated
    public static KindCase valueOf(int value) {
      return forNumber(value);
    }

    public static KindCase forNumber(int value) {
      switch (value) {
        case 1: return NULL;
        case 2: return DATA;
        case 0: return KIND_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public KindCase
  getKindCase() {
    return KindCase.forNumber(
        kindCase_);
  }

  public static final int NULL_FIELD_NUMBER = 1;
  /**
   * <code>.google.protobuf.NullValue null = 1;</code>
   * @return Whether the null field is set.
   */
  public boolean hasNull() {
    return kindCase_ == 1;
  }
  /**
   * <code>.google.protobuf.NullValue null = 1;</code>
   * @return The enum numeric value on the wire for null.
   */
  public int getNullValue() {
    if (kindCase_ == 1) {
      return (Integer) kind_;
    }
    return 0;
  }
  /**
   * <code>.google.protobuf.NullValue null = 1;</code>
   * @return The null.
   */
  public com.google.protobuf.NullValue getNull() {
    if (kindCase_ == 1) {
      @SuppressWarnings("deprecation")
      com.google.protobuf.NullValue result = com.google.protobuf.NullValue.valueOf(
          (Integer) kind_);
      return result == null ? com.google.protobuf.NullValue.UNRECOGNIZED : result;
    }
    return com.google.protobuf.NullValue.NULL_VALUE;
  }

  public static final int DATA_FIELD_NUMBER = 2;
  /**
   * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
   * @return Whether the data field is set.
   */
  @Override
  public boolean hasData() {
    return kindCase_ == 2;
  }
  /**
   * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
   * @return The data.
   */
  @Override
  public DocumentDTO getData() {
    if (kindCase_ == 2) {
       return (DocumentDTO) kind_;
    }
    return DocumentDTO.getDefaultInstance();
  }
  /**
   * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
   */
  @Override
  public DocumentDTOOrBuilder getDataOrBuilder() {
    if (kindCase_ == 2) {
       return (DocumentDTO) kind_;
    }
    return DocumentDTO.getDefaultInstance();
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (kindCase_ == 1) {
      output.writeEnum(1, ((Integer) kind_));
    }
    if (kindCase_ == 2) {
      output.writeMessage(2, (DocumentDTO) kind_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (kindCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, ((Integer) kind_));
    }
    if (kindCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (DocumentDTO) kind_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof NullableDocumentDTO)) {
      return super.equals(obj);
    }
    NullableDocumentDTO other = (NullableDocumentDTO) obj;

    if (!getKindCase().equals(other.getKindCase())) return false;
    switch (kindCase_) {
      case 1:
        if (getNullValue()
            != other.getNullValue()) return false;
        break;
      case 2:
        if (!getData()
            .equals(other.getData())) return false;
        break;
      case 0:
      default:
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    switch (kindCase_) {
      case 1:
        hash = (37 * hash) + NULL_FIELD_NUMBER;
        hash = (53 * hash) + getNullValue();
        break;
      case 2:
        hash = (37 * hash) + DATA_FIELD_NUMBER;
        hash = (53 * hash) + getData().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static NullableDocumentDTO parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NullableDocumentDTO parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NullableDocumentDTO parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NullableDocumentDTO parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NullableDocumentDTO parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NullableDocumentDTO parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NullableDocumentDTO parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static NullableDocumentDTO parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static NullableDocumentDTO parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static NullableDocumentDTO parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static NullableDocumentDTO parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static NullableDocumentDTO parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(NullableDocumentDTO prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code org.myddd.vertx.document.api.NullableDocumentDTO}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.myddd.vertx.document.api.NullableDocumentDTO)
      NullableDocumentDTOOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return DocumentApplicationProto.internal_static_org_myddd_vertx_document_api_NullableDocumentDTO_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return DocumentApplicationProto.internal_static_org_myddd_vertx_document_api_NullableDocumentDTO_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              NullableDocumentDTO.class, Builder.class);
    }

    // Construct using org.myddd.vertx.document.api.NullableDocumentDTO.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      kindCase_ = 0;
      kind_ = null;
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return DocumentApplicationProto.internal_static_org_myddd_vertx_document_api_NullableDocumentDTO_descriptor;
    }

    @Override
    public NullableDocumentDTO getDefaultInstanceForType() {
      return NullableDocumentDTO.getDefaultInstance();
    }

    @Override
    public NullableDocumentDTO build() {
      NullableDocumentDTO result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public NullableDocumentDTO buildPartial() {
      NullableDocumentDTO result = new NullableDocumentDTO(this);
      if (kindCase_ == 1) {
        result.kind_ = kind_;
      }
      if (kindCase_ == 2) {
        if (dataBuilder_ == null) {
          result.kind_ = kind_;
        } else {
          result.kind_ = dataBuilder_.build();
        }
      }
      result.kindCase_ = kindCase_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof NullableDocumentDTO) {
        return mergeFrom((NullableDocumentDTO)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(NullableDocumentDTO other) {
      if (other == NullableDocumentDTO.getDefaultInstance()) return this;
      switch (other.getKindCase()) {
        case NULL: {
          setNullValue(other.getNullValue());
          break;
        }
        case DATA: {
          mergeData(other.getData());
          break;
        }
        case KIND_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      NullableDocumentDTO parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (NullableDocumentDTO) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int kindCase_ = 0;
    private Object kind_;
    public KindCase
        getKindCase() {
      return KindCase.forNumber(
          kindCase_);
    }

    public Builder clearKind() {
      kindCase_ = 0;
      kind_ = null;
      onChanged();
      return this;
    }


    /**
     * <code>.google.protobuf.NullValue null = 1;</code>
     * @return Whether the null field is set.
     */
    @Override
    public boolean hasNull() {
      return kindCase_ == 1;
    }
    /**
     * <code>.google.protobuf.NullValue null = 1;</code>
     * @return The enum numeric value on the wire for null.
     */
    @Override
    public int getNullValue() {
      if (kindCase_ == 1) {
        return ((Integer) kind_).intValue();
      }
      return 0;
    }
    /**
     * <code>.google.protobuf.NullValue null = 1;</code>
     * @param value The enum numeric value on the wire for null to set.
     * @return This builder for chaining.
     */
    public Builder setNullValue(int value) {
      kindCase_ = 1;
      kind_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.NullValue null = 1;</code>
     * @return The null.
     */
    @Override
    public com.google.protobuf.NullValue getNull() {
      if (kindCase_ == 1) {
        @SuppressWarnings("deprecation")
        com.google.protobuf.NullValue result = com.google.protobuf.NullValue.valueOf(
            (Integer) kind_);
        return result == null ? com.google.protobuf.NullValue.UNRECOGNIZED : result;
      }
      return com.google.protobuf.NullValue.NULL_VALUE;
    }
    /**
     * <code>.google.protobuf.NullValue null = 1;</code>
     * @param value The null to set.
     * @return This builder for chaining.
     */
    public Builder setNull(com.google.protobuf.NullValue value) {
      if (value == null) {
        throw new NullPointerException();
      }
      kindCase_ = 1;
      kind_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.google.protobuf.NullValue null = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNull() {
      if (kindCase_ == 1) {
        kindCase_ = 0;
        kind_ = null;
        onChanged();
      }
      return this;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        DocumentDTO, DocumentDTO.Builder, DocumentDTOOrBuilder> dataBuilder_;
    /**
     * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
     * @return Whether the data field is set.
     */
    @Override
    public boolean hasData() {
      return kindCase_ == 2;
    }
    /**
     * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
     * @return The data.
     */
    @Override
    public DocumentDTO getData() {
      if (dataBuilder_ == null) {
        if (kindCase_ == 2) {
          return (DocumentDTO) kind_;
        }
        return DocumentDTO.getDefaultInstance();
      } else {
        if (kindCase_ == 2) {
          return dataBuilder_.getMessage();
        }
        return DocumentDTO.getDefaultInstance();
      }
    }
    /**
     * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
     */
    public Builder setData(DocumentDTO value) {
      if (dataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        kind_ = value;
        onChanged();
      } else {
        dataBuilder_.setMessage(value);
      }
      kindCase_ = 2;
      return this;
    }
    /**
     * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
     */
    public Builder setData(
        DocumentDTO.Builder builderForValue) {
      if (dataBuilder_ == null) {
        kind_ = builderForValue.build();
        onChanged();
      } else {
        dataBuilder_.setMessage(builderForValue.build());
      }
      kindCase_ = 2;
      return this;
    }
    /**
     * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
     */
    public Builder mergeData(DocumentDTO value) {
      if (dataBuilder_ == null) {
        if (kindCase_ == 2 &&
            kind_ != DocumentDTO.getDefaultInstance()) {
          kind_ = DocumentDTO.newBuilder((DocumentDTO) kind_)
              .mergeFrom(value).buildPartial();
        } else {
          kind_ = value;
        }
        onChanged();
      } else {
        if (kindCase_ == 2) {
          dataBuilder_.mergeFrom(value);
        }
        dataBuilder_.setMessage(value);
      }
      kindCase_ = 2;
      return this;
    }
    /**
     * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
     */
    public Builder clearData() {
      if (dataBuilder_ == null) {
        if (kindCase_ == 2) {
          kindCase_ = 0;
          kind_ = null;
          onChanged();
        }
      } else {
        if (kindCase_ == 2) {
          kindCase_ = 0;
          kind_ = null;
        }
        dataBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
     */
    public DocumentDTO.Builder getDataBuilder() {
      return getDataFieldBuilder().getBuilder();
    }
    /**
     * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
     */
    @Override
    public DocumentDTOOrBuilder getDataOrBuilder() {
      if ((kindCase_ == 2) && (dataBuilder_ != null)) {
        return dataBuilder_.getMessageOrBuilder();
      } else {
        if (kindCase_ == 2) {
          return (DocumentDTO) kind_;
        }
        return DocumentDTO.getDefaultInstance();
      }
    }
    /**
     * <code>.org.myddd.vertx.document.api.DocumentDTO data = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        DocumentDTO, DocumentDTO.Builder, DocumentDTOOrBuilder>
        getDataFieldBuilder() {
      if (dataBuilder_ == null) {
        if (!(kindCase_ == 2)) {
          kind_ = DocumentDTO.getDefaultInstance();
        }
        dataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            DocumentDTO, DocumentDTO.Builder, DocumentDTOOrBuilder>(
                (DocumentDTO) kind_,
                getParentForChildren(),
                isClean());
        kind_ = null;
      }
      kindCase_ = 2;
      onChanged();;
      return dataBuilder_;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:org.myddd.vertx.document.api.NullableDocumentDTO)
  }

  // @@protoc_insertion_point(class_scope:org.myddd.vertx.document.api.NullableDocumentDTO)
  private static final NullableDocumentDTO DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new NullableDocumentDTO();
  }

  public static NullableDocumentDTO getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NullableDocumentDTO>
      PARSER = new com.google.protobuf.AbstractParser<NullableDocumentDTO>() {
    @Override
    public NullableDocumentDTO parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NullableDocumentDTO(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NullableDocumentDTO> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<NullableDocumentDTO> getParserForType() {
    return PARSER;
  }

  @Override
  public NullableDocumentDTO getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

