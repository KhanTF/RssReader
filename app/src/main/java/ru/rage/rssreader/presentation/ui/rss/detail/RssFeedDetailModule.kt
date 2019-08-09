package ru.rage.rssreader.presentation.ui.rss.detail

import dagger.Module
import dagger.Provides
import ru.rage.rssreader.presentation.model.RssFeedModel
import javax.inject.Named

@Module
class RssFeedDetailModule{

    @Provides
    @Named("feed_argument")
    fun provideFeed(rssFeedDetailFragment: RssFeedDetailFragment) : RssFeedModel = RssFeedDetailFragmentArgs.fromBundle(rssFeedDetailFragment.requireArguments()).feed
}