package ru.rage.rssreader.presentation.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.rage.rssreader.presentation.ui.rss.detail.RssFeedDetailFragment
import ru.rage.rssreader.presentation.ui.rss.detail.RssFeedDetailModule
import ru.rage.rssreader.presentation.ui.rss.feeds.RssFeedListFragment
import ru.rage.rssreader.presentation.ui.rss.feeds.RssFeedListModule
import ru.rage.rssreader.presentation.ui.rss.subscriptions.RssSubscriptionListFragment

@Module
abstract class MainBuilder {

    @ContributesAndroidInjector
    abstract fun buildRssSubscriptionListFragment(): RssSubscriptionListFragment

    @ContributesAndroidInjector(modules = [RssFeedListModule::class])
    abstract fun buildRssFeedListFragment() : RssFeedListFragment

    @ContributesAndroidInjector(modules = [RssFeedDetailModule::class])
    abstract fun buildRssFeedDetailFragment() : RssFeedDetailFragment

}