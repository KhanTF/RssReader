package ru.rage.rssreader.data.network.rss.pojo


import org.simpleframework.xml.*

@Root(name = "channel", strict = false)
class RssChannelDto {
    @field:Path("title")
    @field:Text(required = false)
    var title: String? = null
    @field:Path("description")
    @field:Text(required = false)
    var description: String? = null
    @field:Path("link")
    @field:Text(required = false)
    var link: String? = null
    @field:ElementList(name = "item", inline = true)
    var items: List<RssItemDto>? = null

    override fun toString(): String {
        return buildString {
            append(title).append(description).append(link).append("\n")
            for (item in items ?: emptyList()) {
                append(item.toString()).append("\n")
            }
        }
    }
}