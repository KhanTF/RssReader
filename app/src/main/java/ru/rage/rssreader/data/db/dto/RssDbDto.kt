package ru.rage.rssreader.data.db.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import okhttp3.HttpUrl

@Entity(tableName = "rss_urls")
class RssDbDto constructor(
        @PrimaryKey
        val url: String,
        val name: String
) {

    constructor(httpUrl: HttpUrl, name: String) : this(httpUrl.toString(), name)

}