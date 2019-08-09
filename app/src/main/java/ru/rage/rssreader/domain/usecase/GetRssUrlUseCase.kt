package ru.rage.rssreader.domain.usecase

import io.reactivex.Observable
import ru.rage.rssreader.domain.entity.RssEntity
import ru.rage.rssreader.domain.entity.RssUrlEntity
import ru.rage.rssreader.domain.repository.RssRepository
import ru.rage.rssreader.domain.repository.RssUrlRepository
import javax.inject.Inject

class GetRssUrlUseCase @Inject constructor(private val rssUrlRepository: RssUrlRepository) {

    fun getRssUrl(): Observable<RssUrlEntity> = rssUrlRepository.getAll()

}