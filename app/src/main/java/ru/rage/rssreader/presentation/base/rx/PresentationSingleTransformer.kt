package ru.rage.rssreader.presentation.base.rx

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresentationSingleTransformer<T> : SingleTransformer<T,T>{
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(Throwable::printStackTrace)
    }

}