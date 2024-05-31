package org.antop.shorten.encoder

interface IdEncoder {
    /** 값을 인코드 */
    fun encode(v: Long): String

    /** 인코딩된 값을 디코드 */
    fun decode(encoded: String): Long
}
