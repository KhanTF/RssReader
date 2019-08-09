package ru.rage.rssreader.di.module.data

import dagger.Binds
import dagger.Module
import ru.rage.rssreader.data.repository.RssRepositoryImpl
import ru.rage.rssreader.data.repository.RssUrlRepositoryImpl
import ru.rage.rssreader.domain.repository.RssRepository
import ru.rage.rssreader.domain.repository.RssUrlRepository

@Module
abstract class RepositoryBinder {

    @Binds
    abstract fun bindRssRepository(rssRepositoryImpl: RssRepositoryImpl): RssRepository

    @Binds
    abstract fun bindRssUrlRepository(rssUrlRepositoryImpl: RssUrlRepositoryImpl): RssUrlRepository

}