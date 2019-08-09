package ru.rage.rssreader.presentation.model.mapper

import ru.rage.rssreader.domain.entity.RssEntity
import ru.rage.rssreader.presentation.model.RssModel

object RssModelMapper {
    fun map(rssEntity: RssEntity): RssModel =
        RssModel(
            rssEntity.title,
            rssEntity.description,
            rssEntity.feeds.map(RssFeedModelMapper::map)
        )
}