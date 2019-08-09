package ru.rage.rssreader.presentation.model.mapper

import ru.rage.rssreader.domain.entity.RssUrlEntity
import ru.rage.rssreader.presentation.model.RssUrlModel

object RssUrlModelMapper {

    fun map(rssUrlEntity: RssUrlEntity) : RssUrlModel{
        return RssUrlModel(rssUrlEntity.name,rssUrlEntity.url)
    }

}