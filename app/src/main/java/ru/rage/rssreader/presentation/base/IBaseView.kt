package ru.rage.rssreader.presentation.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface IBaseView : MvpView{
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(text: String)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(text: Int)
}