package ru.rage.rssreader.data.mapper

import ru.rage.rssreader.data.db.dto.RssDbDto
import ru.rage.rssreader.domain.entity.RssUrlEntity

object RssUrlMapper{

    fun map(rssDbDto: RssDbDto) : RssUrlEntity{
        return RssUrlEntity(rssDbDto.name,rssDbDto.url)
    }

}