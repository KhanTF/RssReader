package ru.rage.rssreader.domain.usecase

import io.reactivex.Single
import ru.rage.rssreader.domain.entity.RssEntity
import ru.rage.rssreader.domain.repository.RssRepository
import javax.inject.Inject

class GetRssUseCase @Inject constructor(private val rssRepository: RssRepository){

    fun getRss(url: String) : Single<RssEntity> =
            rssRepository.getRssByUrl(url)

}