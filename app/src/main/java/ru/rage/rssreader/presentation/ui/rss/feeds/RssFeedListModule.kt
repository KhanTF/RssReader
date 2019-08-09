package ru.rage.rssreader.presentation.ui.rss.feeds

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RssFeedListModule{

    @Provides
    @Named("url_argument")
    fun provideUrl(rssFeedListFragment: RssFeedListFragment) : String = RssFeedListFragmentArgs.fromBundle(rssFeedListFragment.requireArguments()).url

}