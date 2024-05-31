package org.antop.shorten.id

fun interface IdGenerator {
    fun next(): Long
}
