package ru.rage.rssreader

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.rage.rssreader.di.DaggerRssComponent
import timber.log.Timber

class RssApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerRssComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}