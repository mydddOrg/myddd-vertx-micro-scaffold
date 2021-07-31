package org.myddd.vertx.document.domain

import org.myddd.vertx.domain.Entity
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
abstract class DistributeIDEntity: Entity {

    @Id
    var id:Long = 0

    @Version
    var version:Long = 0

    override var created:Long = 0

    override var updated:Long = 0

    init {
        this.created = System.currentTimeMillis()
    }

    override fun getId(): Long {
        return id
    }

}