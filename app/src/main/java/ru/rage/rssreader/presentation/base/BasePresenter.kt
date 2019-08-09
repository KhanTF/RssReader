package ru.rage.rssreader.presentation.base

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<T : IBaseView> : MvpPresenter<T>(), IBasePresenter {

    private val clearCompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        clearCompositeDisposable.clear()
    }

    protected fun Disposable.disposeWhenDestroy() {
        clearCompositeDisposable.add(this)
    }

}