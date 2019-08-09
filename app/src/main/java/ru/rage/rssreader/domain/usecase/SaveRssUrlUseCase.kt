package ru.rage.rssreader.domain.usecase

import io.reactivex.Completable
import ru.rage.rssreader.domain.repository.RssRepository
import ru.rage.rssreader.domain.repository.RssUrlRepository
import javax.inject.Inject

class SaveRssUrlUseCase @Inject constructor(private val rssUrlRepository: RssUrlRepository) {

    fun addRss(name: String,url: String): Completable = rssUrlRepository.saveUrl(name,url)

}