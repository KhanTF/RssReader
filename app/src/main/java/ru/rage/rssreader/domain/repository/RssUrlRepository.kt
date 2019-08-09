package ru.rage.rssreader.domain.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.rage.rssreader.domain.entity.RssUrlEntity

interface RssUrlRepository {
    fun saveUrl(name: String, url: String): Completable
    fun deleteUrl(url: String): Completable
    fun getByUrl(url: String): Single<RssUrlEntity>
    fun getAll(): Observable<RssUrlEntity>
}