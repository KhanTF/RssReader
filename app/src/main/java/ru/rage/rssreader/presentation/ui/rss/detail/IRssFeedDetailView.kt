package ru.rage.rssreader.presentation.ui.rss.detail

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.rage.rssreader.presentation.base.IBaseView

interface IRssFeedDetailView : IBaseView{
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setTitle(title: String)
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setLink(link: String)
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setDescription(description: String)
}