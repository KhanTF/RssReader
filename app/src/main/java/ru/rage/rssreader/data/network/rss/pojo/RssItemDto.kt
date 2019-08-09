package ru.rage.rssreader.data.network.rss.pojo

import org.simpleframework.xml.Element
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "item", strict = false)
class RssItemDto {
    @field:Path("title")
    @field:Text(required = false)
    var title: String? = null
    @field:Path("description")
    @field:Text(required = false)
    var description: String? = null
    @field:Path("link")
    @field:Text(required = false)
    var link: String? = null

    override fun toString(): String {
        return "$title $description $link"
    }
}