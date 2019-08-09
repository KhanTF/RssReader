package ru.rage.rssreader.presentation.ui.rss.subscriptions

import ru.rage.rssreader.presentation.model.RssUrlModel
import ru.rage.rssreader.presentation.base.IBasePresenter

interface IRssSubscriptionListPresenter : IBasePresenter{
    fun onAddRssUrl(name: String,url: String)
    fun onDeleteRssUrl(rssUrlModel: RssUrlModel)
    fun onSelectRssUrl(rssUrlModel: RssUrlModel)
}