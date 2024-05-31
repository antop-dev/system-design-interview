package org.antop.shorten.config

import com.github.f4b6a3.tsid.TsidFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TsidConfig(val snowflakeProperties: SnowflakeProperties) {
    @Bean
    fun tsidFactory(): TsidFactory {
        val datacenter = snowflakeProperties.dataCenter
        val worker = snowflakeProperties.worker
        val node = datacenter shl 5 or worker
        return TsidFactory.builder()
            .withCustomEpoch(snowflakeProperties.epoch.toInstant())
            .withNode(node)
            .build()
    }
}
