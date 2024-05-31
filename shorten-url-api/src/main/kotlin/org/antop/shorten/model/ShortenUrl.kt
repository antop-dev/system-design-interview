package org.antop.shorten.model

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID

class ShortenUrl(id: EntityID<Long>) : LongEntity(id) {
    companion object : EntityClass<Long, ShortenUrl>(ShortenUrlEntity)

    var shortUrl by ShortenUrlEntity.shortUrl
    var originalUrl by ShortenUrlEntity.originalUrl
}
