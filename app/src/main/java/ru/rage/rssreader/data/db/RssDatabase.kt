package ru.rage.rssreader.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.rage.rssreader.data.db.dao.RssDbDao
import ru.rage.rssreader.data.db.dto.RssDbDto

@Database(entities = [RssDbDto::class], version = 1)
abstract class RssDatabase : RoomDatabase(){
    abstract fun getRssDbDao(): RssDbDao
}