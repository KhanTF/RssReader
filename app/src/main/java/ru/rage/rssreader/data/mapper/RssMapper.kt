package ru.rage.rssreader.data.mapper

import ru.rage.rssreader.data.network.rss.pojo.RssDto
import ru.rage.rssreader.domain.entity.RssEntity

object RssMapper {

    fun map(rssDto: RssDto): RssEntity {
        return RssEntity(
            rssDto.channel?.title.orEmpty(),
            rssDto.channel?.description.orEmpty(),
            rssDto.channel?.link.orEmpty(),
            rssDto.channel?.items?.map(RssFeedMapper::map)?: emptyList()
        )
    }

}