package org.myddd.vertx.document.application.assembler

import org.myddd.vertx.document.api.DocumentDTO
import org.myddd.vertx.document.api.NullableDocumentDTO
import org.myddd.vertx.document.domain.Document
import org.myddd.vertx.document.domain.DocumentType


fun Document.toNullableDTO():NullableDocumentDTO {
    return NullableDocumentDTO.newBuilder()
        .setData(this.toDTO()).build()
}

fun Document.toDTO():DocumentDTO {
    return DocumentDTO.newBuilder()
        .setId(this.id)
        .setName(this.name)
        .setMediaId(this.mediaId)
        .setDocumentType(this.documentType.toString())
        .setMd5(this.md5)
        .build()
}

fun DocumentDTO.toEntity():Document {
    val document = Document()
    document.id = this.id
    document.name = this.name
    document.mediaId = this.mediaId
    document.documentType = DocumentType.valueOf(this.documentType)
    document.md5 = this.md5
    return document
}