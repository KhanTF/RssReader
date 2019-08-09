package ru.rage.rssreader.data.network.rss.pojo

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
class RssDto {
    @field:Element(name = "channel", required = true)
    var channel: RssChannelDto? = null

    override fun toString(): String {
        return channel?.toString() ?: "null"
    }
}