package org.antop.shorten.model

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column

object ShortenUrlEntity : IdTable<Long>("SHORTEN_URL") {
    override val id: Column<EntityID<Long>> = long("GUID").entityId()
    val shortUrl = varchar("SHORT_URL", 10)
    // https://stackoverflow.com/questions/417142/what-is-the-maximum-length-of-a-url-in-different-browsers/417184#417184
    val originalUrl = varchar("ORIGINAL_URL", 2000)
}
