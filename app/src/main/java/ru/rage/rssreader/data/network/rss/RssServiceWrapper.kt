package ru.rage.rssreader.data.network.rss

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.functions.Consumer
import retrofit2.HttpException
import ru.rage.rssreader.data.network.rss.pojo.RssDto
import ru.rage.rssreader.domain.exceptions.InternetConnectionException
import ru.rage.rssreader.domain.exceptions.rss.RssNotFoundException
import java.io.IOException

class RssServiceWrapper(private val rssService: RssService) : RssService {

    private class RssErrorConsumer : Consumer<Throwable> {
        override fun accept(t: Throwable) {
            when (t) {
                is HttpException -> throw RssNotFoundException(t)
                is IOException -> throw InternetConnectionException(t)
            }
        }
    }

    private class RssComposer<T> : SingleTransformer<T, T> {
        override fun apply(upstream: Single<T>): SingleSource<T> {
            return upstream.doOnError(RssErrorConsumer())
        }
    }

    override fun getRss(url: String): Single<RssDto> {
        return rssService.getRss(url).compose(RssComposer())
    }
}