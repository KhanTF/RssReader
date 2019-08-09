package ru.rage.rssreader.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.TypeConverters
import io.reactivex.Single
import okhttp3.HttpUrl
import ru.rage.rssreader.data.db.converter.HttpUrlConverter
import ru.rage.rssreader.data.db.dto.RssDbDto

@Dao
interface RssDbDao : BaseDbDao<RssDbDto> {
    @Query("SELECT * FROM rss_urls GROUP BY name")
    fun getAll(): Single<List<RssDbDto>>

    @Query("SELECT * FROM rss_urls WHERE url=:url")
    fun getRss(@TypeConverters(HttpUrlConverter::class) url: HttpUrl): Single<RssDbDto>
}