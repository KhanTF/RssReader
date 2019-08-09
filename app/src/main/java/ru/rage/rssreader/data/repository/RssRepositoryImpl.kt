package ru.rage.rssreader.data.repository

import io.reactivex.Single
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import ru.rage.rssreader.data.mapper.RssMapper
import ru.rage.rssreader.data.network.rss.RssService
import ru.rage.rssreader.domain.entity.RssEntity
import ru.rage.rssreader.domain.exceptions.rss.RssNotFoundException
import ru.rage.rssreader.domain.repository.RssRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RssRepositoryImpl @Inject constructor(
    private val rssService: RssService
) : RssRepository {

    override fun getRssByUrl(url: String): Single<RssEntity> {
        return Single
            .defer {
                if (url.toHttpUrlOrNull() == null) {
                    throw RssNotFoundException("Invalid url")
                } else {
                    rssService.getRss(url)
                }
            }
            .map(RssMapper::map)
    }

}