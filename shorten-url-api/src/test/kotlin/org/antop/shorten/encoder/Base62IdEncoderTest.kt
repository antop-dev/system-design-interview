package org.antop.shorten.encoder

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class Base62IdEncoderTest {
    private val encoder = Base62IdEncoder()

    @Test
    fun encode() {
        assertThat(encoder.encode(1), `is`("1"))
        assertThat(encoder.encode(2), `is`("2"))
        assertThat(encoder.encode(3), `is`("3"))
        assertThat(encoder.encode(4), `is`("4"))
        assertThat(encoder.encode(5), `is`("A"))
        assertThat(encoder.encode(6), `is`("B"))
        assertThat(encoder.encode(7), `is`("C"))
        assertThat(encoder.encode(8), `is`("D"))
        assertThat(encoder.encode(9), `is`("E"))
        assertThat(encoder.encode(10), `is`("a"))
        assertThat(encoder.encode(11), `is`("b"))
        assertThat(encoder.encode(12), `is`("c"))
        assertThat(encoder.encode(13), `is`("d"))
        assertThat(encoder.encode(14), `is`("e"))
        assertThat(encoder.encode(15), `is`("F"))
        assertThat(encoder.encode(16), `is`("G"))
        assertThat(encoder.encode(61), `is`("9"))
        assertThat(encoder.encode(62), `is`("01"))
        assertThat(encoder.encode(557069327110878667), `is`("5PGRryWiEq"))
        assertThat(encoder.encode(557069327127655693), `is`("C3qUsyWiEq"))
        assertThat(encoder.encode(557069327127655694), `is`("D3qUsyWiEq"))
    }

    @Test
    fun decode() {
        assertThat(encoder.decode("1"), `is`(1))
        assertThat(encoder.decode("2"), `is`(2))
        assertThat(encoder.decode("3"), `is`(3))
        assertThat(encoder.decode("4"), `is`(4))
        assertThat(encoder.decode("A"), `is`(5))
        assertThat(encoder.decode("B"), `is`(6))
        assertThat(encoder.decode("C"), `is`(7))
        assertThat(encoder.decode("D"), `is`(8))
        assertThat(encoder.decode("E"), `is`(9))
        assertThat(encoder.decode("a"), `is`(10))
        assertThat(encoder.decode("b"), `is`(11))
        assertThat(encoder.decode("c"), `is`(12))
        assertThat(encoder.decode("d"), `is`(13))
        assertThat(encoder.decode("e"), `is`(14))
        assertThat(encoder.decode("F"), `is`(15))
        assertThat(encoder.decode("G"), `is`(16))
        assertThat(encoder.decode("9"), `is`(61))
        assertThat(encoder.decode("01"), `is`(62))
        assertThat(encoder.decode("5PGRryWiEq"), `is`(557069327110878667))
        assertThat(encoder.decode("C3qUsyWiEq"), `is`(557069327127655693))
        assertThat(encoder.decode("D3qUsyWiEq"), `is`(557069327127655694))
    }
}
