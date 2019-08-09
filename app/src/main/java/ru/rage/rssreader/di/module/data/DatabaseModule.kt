package ru.rage.rssreader.di.module.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.rage.rssreader.data.db.RssDatabase
import ru.rage.rssreader.data.db.dao.RssDbDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRssDatabase(context: Context): RssDatabase =
        Room
                .databaseBuilder(context, RssDatabase::class.java, "rss.db")
                .build()

    @Provides
    @Singleton
    fun provideRssDbDao(rssDatabase: RssDatabase) : RssDbDao = rssDatabase.getRssDbDao()

}