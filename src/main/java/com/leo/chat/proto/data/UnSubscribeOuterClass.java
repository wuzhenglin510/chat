// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data/UnSubscribe.proto

package com.leo.chat.proto.data;

public final class UnSubscribeOuterClass {
  private UnSubscribeOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface UnSubscribeOrBuilder extends
      // @@protoc_insertion_point(interface_extends:data.UnSubscribe)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string uid = 1;</code>
     * @return The uid.
     */
    java.lang.String getUid();
    /**
     * <code>string uid = 1;</code>
     * @return The bytes for uid.
     */
    com.google.protobuf.ByteString
        getUidBytes();

    /**
     * <code>repeated string topics = 2;</code>
     * @return A list containing the topics.
     */
    java.util.List<java.lang.String>
        getTopicsList();
    /**
     * <code>repeated string topics = 2;</code>
     * @return The count of topics.
     */
    int getTopicsCount();
    /**
     * <code>repeated string topics = 2;</code>
     * @param index The index of the element to return.
     * @return The topics at the given index.
     */
    java.lang.String getTopics(int index);
    /**
     * <code>repeated string topics = 2;</code>
     * @param index The index of the value to return.
     * @return The bytes of the topics at the given index.
     */
    com.google.protobuf.ByteString
        getTopicsBytes(int index);
  }
  /**
   * Protobuf type {@code data.UnSubscribe}
   */
  public static final class UnSubscribe extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:data.UnSubscribe)
      UnSubscribeOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use UnSubscribe.newBuilder() to construct.
    private UnSubscribe(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private UnSubscribe() {
      uid_ = "";
      topics_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new UnSubscribe();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private UnSubscribe(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
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
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              uid_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                topics_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000001;
              }
              topics_.add(s);
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
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          topics_ = topics_.getUnmodifiableView();
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.leo.chat.proto.data.UnSubscribeOuterClass.internal_static_data_UnSubscribe_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.leo.chat.proto.data.UnSubscribeOuterClass.internal_static_data_UnSubscribe_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe.class, com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe.Builder.class);
    }

    public static final int UID_FIELD_NUMBER = 1;
    private volatile java.lang.Object uid_;
    /**
     * <code>string uid = 1;</code>
     * @return The uid.
     */
    @java.lang.Override
    public java.lang.String getUid() {
      java.lang.Object ref = uid_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        uid_ = s;
        return s;
      }
    }
    /**
     * <code>string uid = 1;</code>
     * @return The bytes for uid.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getUidBytes() {
      java.lang.Object ref = uid_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        uid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TOPICS_FIELD_NUMBER = 2;
    private com.google.protobuf.LazyStringList topics_;
    /**
     * <code>repeated string topics = 2;</code>
     * @return A list containing the topics.
     */
    public com.google.protobuf.ProtocolStringList
        getTopicsList() {
      return topics_;
    }
    /**
     * <code>repeated string topics = 2;</code>
     * @return The count of topics.
     */
    public int getTopicsCount() {
      return topics_.size();
    }
    /**
     * <code>repeated string topics = 2;</code>
     * @param index The index of the element to return.
     * @return The topics at the given index.
     */
    public java.lang.String getTopics(int index) {
      return topics_.get(index);
    }
    /**
     * <code>repeated string topics = 2;</code>
     * @param index The index of the value to return.
     * @return The bytes of the topics at the given index.
     */
    public com.google.protobuf.ByteString
        getTopicsBytes(int index) {
      return topics_.getByteString(index);
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getUidBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, uid_);
      }
      for (int i = 0; i < topics_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, topics_.getRaw(i));
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getUidBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, uid_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < topics_.size(); i++) {
          dataSize += computeStringSizeNoTag(topics_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getTopicsList().size();
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe)) {
        return super.equals(obj);
      }
      com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe other = (com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe) obj;

      if (!getUid()
          .equals(other.getUid())) return false;
      if (!getTopicsList()
          .equals(other.getTopicsList())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + UID_FIELD_NUMBER;
      hash = (53 * hash) + getUid().hashCode();
      if (getTopicsCount() > 0) {
        hash = (37 * hash) + TOPICS_FIELD_NUMBER;
        hash = (53 * hash) + getTopicsList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code data.UnSubscribe}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:data.UnSubscribe)
        com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribeOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.leo.chat.proto.data.UnSubscribeOuterClass.internal_static_data_UnSubscribe_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.leo.chat.proto.data.UnSubscribeOuterClass.internal_static_data_UnSubscribe_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe.class, com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe.Builder.class);
      }

      // Construct using com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        uid_ = "";

        topics_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.leo.chat.proto.data.UnSubscribeOuterClass.internal_static_data_UnSubscribe_descriptor;
      }

      @java.lang.Override
      public com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe getDefaultInstanceForType() {
        return com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe.getDefaultInstance();
      }

      @java.lang.Override
      public com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe build() {
        com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe buildPartial() {
        com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe result = new com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe(this);
        int from_bitField0_ = bitField0_;
        result.uid_ = uid_;
        if (((bitField0_ & 0x00000001) != 0)) {
          topics_ = topics_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.topics_ = topics_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe) {
          return mergeFrom((com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe other) {
        if (other == com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe.getDefaultInstance()) return this;
        if (!other.getUid().isEmpty()) {
          uid_ = other.uid_;
          onChanged();
        }
        if (!other.topics_.isEmpty()) {
          if (topics_.isEmpty()) {
            topics_ = other.topics_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureTopicsIsMutable();
            topics_.addAll(other.topics_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object uid_ = "";
      /**
       * <code>string uid = 1;</code>
       * @return The uid.
       */
      public java.lang.String getUid() {
        java.lang.Object ref = uid_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          uid_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string uid = 1;</code>
       * @return The bytes for uid.
       */
      public com.google.protobuf.ByteString
          getUidBytes() {
        java.lang.Object ref = uid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          uid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string uid = 1;</code>
       * @param value The uid to set.
       * @return This builder for chaining.
       */
      public Builder setUid(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        uid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string uid = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearUid() {
        
        uid_ = getDefaultInstance().getUid();
        onChanged();
        return this;
      }
      /**
       * <code>string uid = 1;</code>
       * @param value The bytes for uid to set.
       * @return This builder for chaining.
       */
      public Builder setUidBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        uid_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.LazyStringList topics_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureTopicsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          topics_ = new com.google.protobuf.LazyStringArrayList(topics_);
          bitField0_ |= 0x00000001;
         }
      }
      /**
       * <code>repeated string topics = 2;</code>
       * @return A list containing the topics.
       */
      public com.google.protobuf.ProtocolStringList
          getTopicsList() {
        return topics_.getUnmodifiableView();
      }
      /**
       * <code>repeated string topics = 2;</code>
       * @return The count of topics.
       */
      public int getTopicsCount() {
        return topics_.size();
      }
      /**
       * <code>repeated string topics = 2;</code>
       * @param index The index of the element to return.
       * @return The topics at the given index.
       */
      public java.lang.String getTopics(int index) {
        return topics_.get(index);
      }
      /**
       * <code>repeated string topics = 2;</code>
       * @param index The index of the value to return.
       * @return The bytes of the topics at the given index.
       */
      public com.google.protobuf.ByteString
          getTopicsBytes(int index) {
        return topics_.getByteString(index);
      }
      /**
       * <code>repeated string topics = 2;</code>
       * @param index The index to set the value at.
       * @param value The topics to set.
       * @return This builder for chaining.
       */
      public Builder setTopics(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureTopicsIsMutable();
        topics_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string topics = 2;</code>
       * @param value The topics to add.
       * @return This builder for chaining.
       */
      public Builder addTopics(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureTopicsIsMutable();
        topics_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string topics = 2;</code>
       * @param values The topics to add.
       * @return This builder for chaining.
       */
      public Builder addAllTopics(
          java.lang.Iterable<java.lang.String> values) {
        ensureTopicsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, topics_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string topics = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearTopics() {
        topics_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string topics = 2;</code>
       * @param value The bytes of the topics to add.
       * @return This builder for chaining.
       */
      public Builder addTopicsBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        ensureTopicsIsMutable();
        topics_.add(value);
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:data.UnSubscribe)
    }

    // @@protoc_insertion_point(class_scope:data.UnSubscribe)
    private static final com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe();
    }

    public static com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<UnSubscribe>
        PARSER = new com.google.protobuf.AbstractParser<UnSubscribe>() {
      @java.lang.Override
      public UnSubscribe parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new UnSubscribe(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<UnSubscribe> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<UnSubscribe> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.leo.chat.proto.data.UnSubscribeOuterClass.UnSubscribe getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_data_UnSubscribe_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_data_UnSubscribe_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026data/UnSubscribe.proto\022\004data\"*\n\013UnSubs" +
      "cribe\022\013\n\003uid\030\001 \001(\t\022\016\n\006topics\030\002 \003(\tB\031\n\027co" +
      "m.leo.chat.proto.datab\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_data_UnSubscribe_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_data_UnSubscribe_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_data_UnSubscribe_descriptor,
        new java.lang.String[] { "Uid", "Topics", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
