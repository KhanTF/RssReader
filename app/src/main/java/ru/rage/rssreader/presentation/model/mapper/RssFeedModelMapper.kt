package ru.rage.rssreader.presentation.model.mapper

import ru.rage.rssreader.domain.entity.RssFeedEntity
import ru.rage.rssreader.presentation.model.RssFeedModel

object RssFeedModelMapper {

    fun map(rssFeedEntity: RssFeedEntity) : RssFeedModel{
        return RssFeedModel(
            rssFeedEntity.title,
            rssFeedEntity.description,
            rssFeedEntity.link
        )
    }

}