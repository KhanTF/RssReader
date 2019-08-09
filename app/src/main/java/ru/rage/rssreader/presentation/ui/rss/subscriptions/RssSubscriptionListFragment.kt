package ru.rage.rssreader.presentation.ui.rss.subscriptions

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_rss_subscription_list.*
import ru.rage.rssreader.R
import ru.rage.rssreader.presentation.base.common.decorator.DeletionSwipeItemTouchHelperCallback
import ru.rage.rssreader.presentation.base.common.decorator.MarginItemDecorator
import ru.rage.rssreader.presentation.ui.dialogs.AddRssUrlDialog
import ru.rage.rssreader.presentation.model.RssUrlModel
import ru.rage.rssreader.presentation.base.BaseFragment
import javax.inject.Inject
import javax.inject.Provider

class RssSubscriptionListFragment : BaseFragment(), IRssSubscriptionListView, AddRssUrlDialog.AddOrDeleteCallback {

    companion object {
        private const val TAG_ADD_RSS = "TAG_ADD_RSS"
    }

    @Inject
    lateinit var presenterProvider: Provider<RssSubscriptionListPresenter>
    @InjectPresenter
    lateinit var presenter: RssSubscriptionListPresenter

    @ProvidePresenter
    fun providePresenter(): RssSubscriptionListPresenter = presenterProvider.get()

    private val adapter = RssSubscriptionListAdapter()
    private val touchHelper = ItemTouchHelper(DeletionSwipeItemTouchHelperCallback(adapter))

    override val layoutId: Int
        get() = R.layout.fragment_rss_subscription_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_rss_subscription_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.add) {
            AddRssUrlDialog
                .getInstance()
                .show(childFragmentManager, TAG_ADD_RSS)
            true
        } else
            super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.callback = object : RssSubscriptionListAdapter.RssListCallback {
            override fun onDelete(rssUrlModel: RssUrlModel) {
                presenter.onDeleteRssUrl(rssUrlModel)
            }

            override fun onRssUrl(rssUrlModel: RssUrlModel) {
                presenter.onSelectRssUrl(rssUrlModel)
            }
        }
        touchHelper.attachToRecyclerView(rss_list)
        rss_list.adapter = adapter
        rss_list.layoutManager = LinearLayoutManager(context)
        rss_list.addItemDecoration(MarginItemDecorator(resources.getDimensionPixelSize(R.dimen.margin_item_list)))
    }

    override fun showRssList(rssUrlList: List<RssUrlModel>) {
        adapter.list = rssUrlList
    }

    override fun setEmptyVisible(visible: Boolean) {
        empty.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun setProgressVisible(visible: Boolean) {
        progress.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun onAdd(name: String, url: String) {
        presenter.onAddRssUrl(name, url)
    }

}