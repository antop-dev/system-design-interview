package org.antop.shorten.id

import com.github.f4b6a3.tsid.TsidFactory
import org.springframework.stereotype.Component

@Component
class TsidGenerator(private val tsidFactory: TsidFactory) : IdGenerator {
    override fun next() = tsidFactory.create().toLong()
}
