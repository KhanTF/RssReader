package ru.rage.rssreader.presentation.ui.rss.detail

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_rss_feed_detail.*
import ru.rage.rssreader.R
import ru.rage.rssreader.presentation.base.BaseFragment
import javax.inject.Inject
import javax.inject.Provider

class RssFeedDetailFragment : BaseFragment(), IRssFeedDetailView {

    @Inject
    lateinit var presenterProvider : Provider<RssFeedDetailPresenter>
    @InjectPresenter
    lateinit var presenter : RssFeedDetailPresenter
    @ProvidePresenter
    fun providePresenter() : RssFeedDetailPresenter = presenterProvider.get()

    override val layoutId: Int
        get() = R.layout.fragment_rss_feed_detail

    override fun setDescription(description: String) {
        this.description.text = description
    }

    override fun setLink(link: String) {
        this.link.text= link
    }

    override fun setTitle(title: String) {
        this.title.text = title
    }
}