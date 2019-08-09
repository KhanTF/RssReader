package ru.rage.rssreader.presentation.ui.rss.feeds

import ru.rage.rssreader.presentation.model.RssFeedModel
import ru.rage.rssreader.presentation.base.IBasePresenter

interface IRssFeedListPresenter : IBasePresenter{
    fun onUpdate()
    fun onSelectFeed(rssFeedModel: RssFeedModel)
}