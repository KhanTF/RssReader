package ru.rage.rssreader.presentation.ui.rss.feeds

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.rage.rssreader.presentation.model.RssFeedModel
import ru.rage.rssreader.presentation.base.IBaseView

interface IRssFeedListView : IBaseView{
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showRssFeedList(list: List<RssFeedModel>)
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProgressVisible(visible: Boolean)
}