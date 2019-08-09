package ru.rage.rssreader.data.db.converter

import androidx.room.TypeConverter
import okhttp3.HttpUrl

class HttpUrlConverter {
    @TypeConverter
    fun convertHttpUrlToString(httpUrl: HttpUrl) : String = httpUrl.toString()
}