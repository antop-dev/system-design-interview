package org.antop.shorten.encoder

import org.springframework.stereotype.Component

@Component
class Base62IdEncoder : IdEncoder {
    private val base = 62

    // 문자와 숫자를 조금 꼬았다
    private val characters = "01234ABCDEabcdeFGHIJfghijKLMNOklmnoPQRSTpqrstUVWXYZuvwxyz56789"

    override fun encode(v: Long) = buildString {
        var quotient = v
        while (quotient > 0) {
            append(characters[(quotient % 62).toInt()])
            quotient /= 62
        }
    }

    override fun decode(encoded: String): Long {
        var pow = 1L
        var v = 0L
        for (ch in encoded) {
            v += pow * characters.indexOf(ch)
            pow *= base
        }
        return v
    }
}
