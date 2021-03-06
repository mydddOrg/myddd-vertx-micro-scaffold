package org.myddd.vertx.document.domain

import io.vertx.core.Future
import io.vertx.kotlin.coroutines.await
import org.myddd.vertx.ioc.InstanceFactory
import javax.persistence.*
import javax.persistence.Entity
import org.myddd.vertx.domain.BaseEntity
import java.io.Serializable

@Entity
@Table(name = "document",
    indexes = [
        Index(name = "index_media_id",columnList = "media_id"),
    ],
    uniqueConstraints = [UniqueConstraint(columnNames = ["media_id"])]
)
class Document: DistributeIDEntity() {

    @Column(nullable = false,length = 36)
    lateinit var name:String

    @Column(name = "media_id",nullable = false,length = 36)
    lateinit var mediaId:String

    lateinit var md5:String

    lateinit var suffix: String

    @Column(name = "document_type")
    lateinit var documentType: DocumentType

    companion object {
        private val repository by lazy { InstanceFactory.getInstance(DocumentRepository::class.java) }
        private val distributeID by lazy { InstanceFactory.getInstance(DistributeID::class.java) }

        suspend fun queryDocumentById(id:Long):Future<Document?>{
            return repository.get(Document::class.java,id)
        }

        suspend fun queryDocumentByMediaId(mediaId:String):Future<Document?>{
            return repository.queryDocumentByMediaId(mediaId = mediaId)
        }
    }

    suspend fun createDocument():Future<Document>{
        return try {
            this.id = distributeID.nextId().await()
            repository.save(this)
        }catch (t:Throwable){
            Future.failedFuture(t)
        }
    }

}