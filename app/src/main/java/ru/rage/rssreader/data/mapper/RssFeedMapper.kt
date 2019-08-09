package ru.rage.rssreader.data.mapper

import ru.rage.rssreader.data.network.rss.pojo.RssItemDto
import ru.rage.rssreader.domain.entity.RssFeedEntity

object RssFeedMapper {

    fun map(item: RssItemDto): RssFeedEntity{
        return RssFeedEntity(item.title.orEmpty(),item.description.orEmpty(),item.link.orEmpty())
    }

}