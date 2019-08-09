package ru.rage.rssreader.domain.usecase

import io.reactivex.Completable
import ru.rage.rssreader.domain.repository.RssUrlRepository
import javax.inject.Inject

class DeleteRssUrlUseCase @Inject constructor(private val rssUrlRepository: RssUrlRepository){

    fun deleteRss(url: String): Completable{
        return rssUrlRepository
            .deleteUrl(url)
    }

}