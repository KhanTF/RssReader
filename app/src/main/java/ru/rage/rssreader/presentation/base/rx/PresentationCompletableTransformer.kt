package ru.rage.rssreader.presentation.base.rx

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresentationCompletableTransformer : CompletableTransformer{
    override fun apply(upstream: Completable): Completable {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(Throwable::printStackTrace)
    }

}