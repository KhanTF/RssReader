package ru.rage.rssreader.presentation.ui.rss.feeds

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_rss_feed_list.*
import ru.rage.rssreader.R
import ru.rage.rssreader.presentation.base.common.decorator.MarginItemDecorator
import ru.rage.rssreader.presentation.model.RssFeedModel
import ru.rage.rssreader.presentation.base.BaseFragment
import javax.inject.Inject
import javax.inject.Provider

class RssFeedListFragment : BaseFragment(), IRssFeedListView {

    @Inject
    lateinit var presenterProvider : Provider<RssFeedListPresenter>
    @InjectPresenter
    lateinit var presenter : RssFeedListPresenter
    @ProvidePresenter
    fun providePresenter() : RssFeedListPresenter = presenterProvider.get()

    override val layoutId: Int
        get() = R.layout.fragment_rss_feed_list

    private val adapter = RssFeedListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rss_feed_list.adapter = adapter
        rss_feed_list.layoutManager = LinearLayoutManager(context)
        rss_feed_list.addItemDecoration(MarginItemDecorator(resources.getDimensionPixelSize(R.dimen.margin_item_list)))

        refresh.setOnRefreshListener {
            presenter.onUpdate()
        }

        adapter.listener = presenter::onSelectFeed
    }

    override fun showRssFeedList(list: List<RssFeedModel>) {
        adapter.list = list
    }

    override fun setProgressVisible(visible: Boolean) {
        refresh.isRefreshing = visible
    }

}