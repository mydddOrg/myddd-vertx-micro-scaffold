package org.myddd.vertx.document.api

import java.beans.ConstructorProperties

data class DocumentDTO
@ConstructorProperties(value = ["id","mediaId","name","documentType","md5","suffix"])
constructor(val id:Long = 0, val mediaId:String, val name:String, val documentType:String, val md5:String, val suffix:String)
