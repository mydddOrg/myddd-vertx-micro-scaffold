package org.myddd.vertx.micro.rest.bootstrap.ext

import io.vertx.core.json.JsonObject
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import org.myddd.vertx.document.api.DocumentDTO

fun JsonObject.toDocumentDTO():DocumentDTO{
    return DocumentDTO.newBuilder()
        .setName(this.getString("name"))
        .setMediaId(this.getString("mediaId"))
        .setDocumentType(this.getString("documentType"))
        .setMd5(this.getString("md5"))
        .build()
}

fun DocumentDTO.toJsonObject():JsonObject {
    return json {
        obj(
            "id" to id,
            "name" to name,
            "mediaId" to mediaId,
            "documentType" to documentType,
            "md5" to md5
        )
    }
}