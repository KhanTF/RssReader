package ru.rage.rssreader.data.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import ru.rage.rssreader.data.db.dao.RssDbDao
import ru.rage.rssreader.data.db.dto.RssDbDto
import ru.rage.rssreader.data.helper.FirstLaunchHelper
import ru.rage.rssreader.data.mapper.RssUrlMapper
import ru.rage.rssreader.domain.entity.RssUrlEntity
import ru.rage.rssreader.domain.exceptions.rss.RssNotFoundException
import ru.rage.rssreader.domain.repository.RssUrlRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RssUrlRepositoryImpl @Inject constructor(
    private val rssDbDao: RssDbDao,
    private val firstLaunchHelper: FirstLaunchHelper
) : RssUrlRepository {

    companion object {
        private fun getHttpUrlSingle(url: String) = Single.fromCallable {
            url.toHttpUrlOrNull() ?: throw RssNotFoundException("Invalid url")
        }

        private val INITIAL_RSS_URLS = listOf(
            RssDbDto("http://feeds.bbci.co.uk/news/world/rss.xml", "BBC world news"),
            RssDbDto("http://www.cbn.com/cbnnews/world/feed", "CBN world news"),
            RssDbDto("http://feeds.reuters.com/Reuters/worldNews", "Reuters world news")
        )
    }

    private fun initialOnFirstLaunch(): Completable {
        return Single
            .fromCallable {
                firstLaunchHelper.isFirstLaunch
            }
            .flatMapObservable {
                if (it)
                    Observable.fromIterable(INITIAL_RSS_URLS)
                else
                    Observable.empty()
            }
            .flatMapSingle(rssDbDao::insert)
            .ignoreElements()
    }

    override fun saveUrl(name: String, url: String): Completable {
        return initialOnFirstLaunch()
            .andThen(getHttpUrlSingle(url))
            .map { RssDbDto(it, name) }
            .flatMap(rssDbDao::insert)
            .ignoreElement()
    }

    override fun deleteUrl(url: String): Completable {
        return initialOnFirstLaunch()
            .andThen(getHttpUrlSingle(url))
            .flatMap(rssDbDao::getRss)
            .flatMap(rssDbDao::delete)
            .ignoreElement()
    }

    override fun getByUrl(url: String): Single<RssUrlEntity> {
        return initialOnFirstLaunch()
            .andThen(getHttpUrlSingle(url))
            .flatMap(rssDbDao::getRss)
            .map(RssUrlMapper::map)
    }

    override fun getAll(): Observable<RssUrlEntity> {
        return initialOnFirstLaunch()
            .andThen(rssDbDao.getAll())
            .flatMapObservable { Observable.fromIterable(it) }
            .map(RssUrlMapper::map)
    }

}