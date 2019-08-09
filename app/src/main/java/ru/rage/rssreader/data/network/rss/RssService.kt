package ru.rage.rssreader.data.network.rss

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url
import ru.rage.rssreader.data.network.rss.pojo.RssDto

interface RssService {
    @GET
    fun getRss(@Url url: String): Single<RssDto>
}