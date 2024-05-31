package org.antop.shorten.app

import org.antop.shorten.encoder.IdEncoder
import org.antop.shorten.id.IdGenerator
import org.antop.shorten.model.ShortenUrl
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ShortenUrlService(
    val idGenerator: IdGenerator,
    val idEncoder: IdEncoder
) {
    @Transactional(readOnly = true)
    fun findOriginalUrl(shortUrl: String): String? {
        val id = idEncoder.decode(shortUrl)
        return ShortenUrl.findById(id)?.originalUrl
    }

    @Transactional
    fun shorten(url: String): String {
        val id = idGenerator.next()
        val shortUrl = idEncoder.encode(id)
        ShortenUrl.new(id) {
            this.shortUrl = shortUrl
            this.originalUrl = url
        }
        return shortUrl
    }
}
