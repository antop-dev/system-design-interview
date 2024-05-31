package org.antop.shorten.config

import org.springframework.boot.context.properties.ConfigurationProperties
import java.time.ZonedDateTime

@ConfigurationProperties(prefix = "tsid.snowflake")
data class SnowflakeProperties(
    val epoch: ZonedDateTime,
    val dataCenter: Int,
    val worker: Int
)
