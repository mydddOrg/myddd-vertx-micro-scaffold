package org.myddd.vertx.document.application.assembler

import org.myddd.vertx.document.api.DocumentDTO
import org.myddd.vertx.document.domain.Document
import org.myddd.vertx.document.domain.DocumentType


fun toDocument(documentDTO: DocumentDTO): Document {
    val document = Document()
    document.mediaId = documentDTO.mediaId
    document.name = documentDTO.name
    document.documentType = DocumentType.valueOf(documentDTO.documentType)
    document.md5 = documentDTO.md5
    document.suffix = documentDTO.suffix
    return document
}

fun toDocumentDTO(document: Document):DocumentDTO{
    return DocumentDTO(
        id = document.id,
        mediaId = document.mediaId,
        name = document.name,
        documentType = document.documentType.toString(),
        md5 = document.md5,
        suffix = document.suffix
    )
}