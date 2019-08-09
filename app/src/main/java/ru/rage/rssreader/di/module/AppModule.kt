package ru.rage.rssreader.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.rage.rssreader.RssApplication
import ru.rage.rssreader.presentation.base.BaseNavControllerRouter
import javax.inject.Singleton

@Module(includes = [ActivityBuilder::class])
class AppModule {

    @Provides
    fun provideContext(rssApplication: RssApplication): Context = rssApplication

    @Provides
    @Singleton
    fun provideBaseNavControllerRouter() : BaseNavControllerRouter = BaseNavControllerRouter()

}