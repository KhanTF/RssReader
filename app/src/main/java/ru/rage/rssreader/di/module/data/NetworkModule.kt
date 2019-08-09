package ru.rage.rssreader.di.module.data

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import ru.rage.rssreader.data.network.cache.CacheInterceptor
import ru.rage.rssreader.data.network.rss.RssService
import ru.rage.rssreader.data.network.rss.RssServiceWrapper
import timber.log.Timber
import java.io.File
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val TAG = "NetworkTraffic"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(CacheInterceptor(context))
        .addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.tag(TAG).v(message)
            }
        }).apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .cache(Cache(File(context.cacheDir, "retrofit"), 10 * 1024 * 1024))
        .build()

    @Provides
    @Singleton
    fun provideRssService(okHttpClient: OkHttpClient): RssService = RssServiceWrapper(
        Retrofit
            .Builder()
            .client(okHttpClient)
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("http://localhost")
            .build()
            .create(RssService::class.java)
    )

}