package ru.rage.rssreader.domain.repository

import io.reactivex.Single
import ru.rage.rssreader.domain.entity.RssEntity

interface RssRepository {
    fun getRssByUrl(url: String) : Single<RssEntity>
}