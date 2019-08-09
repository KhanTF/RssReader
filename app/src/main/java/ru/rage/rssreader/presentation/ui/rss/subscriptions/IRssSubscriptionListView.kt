package ru.rage.rssreader.presentation.ui.rss.subscriptions

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.rage.rssreader.presentation.model.RssUrlModel
import ru.rage.rssreader.presentation.base.IBaseView

interface IRssSubscriptionListView : IBaseView{
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showRssList(rssUrlList: List<RssUrlModel>)
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setEmptyVisible(visible: Boolean)
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProgressVisible(visible: Boolean)
}