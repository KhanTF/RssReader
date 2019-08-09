package ru.rage.rssreader.presentation.ui.rss.detail

import com.arellomobile.mvp.InjectViewState
import ru.rage.rssreader.presentation.model.RssFeedModel
import ru.rage.rssreader.presentation.base.BasePresenter
import javax.inject.Inject
import javax.inject.Named

@InjectViewState
class RssFeedDetailPresenter @Inject constructor(
    @Named("feed_argument")
    private val feed: RssFeedModel
) : BasePresenter<IRssFeedDetailView>(), IRssFeedDetailPresenter {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState?.setTitle(feed.title)
        viewState?.setLink(feed.link)
        viewState?.setDescription(feed.description)
    }

}