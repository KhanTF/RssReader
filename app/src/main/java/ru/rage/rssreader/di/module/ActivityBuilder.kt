package ru.rage.rssreader.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.rage.rssreader.presentation.ui.MainActivity
import ru.rage.rssreader.presentation.ui.MainModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun buildMainActivity(): MainActivity

}