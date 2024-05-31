package org.antop.shorten.app

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/v1")
class ShortenUrlController(val shortenUrlService: ShortenUrlService) {

    @GetMapping("/{shortUrl:[a-zA-Z0-9]+}")
    fun longUrl(@PathVariable shortUrl: String): ResponseEntity<Unit> =
        shortenUrlService.findOriginalUrl(shortUrl)?.let {
            ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION, it)
                .build()
        } ?: ResponseEntity.notFound().build()

    @PostMapping("/data/shorten")
    @ResponseBody
    fun shorten(@RequestBody request: ShortenRequest) = run {
        val shortUrl = shortenUrlService.shorten(request.originalUrl)
        ShortenResponse(shortUrl)
    }

    data class ShortenRequest(val originalUrl: String)

    data class ShortenResponse(val shortUrl: String)

}
