package ru.rage.rssreader.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.rage.rssreader.RssApplication
import ru.rage.rssreader.di.module.AppModule
import ru.rage.rssreader.di.module.data.DataModule
import javax.inject.Singleton

@Component(modules = [AndroidSupportInjectionModule::class, DataModule::class, AppModule::class])
@Singleton
interface RssComponent : AndroidInjector<RssApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<RssApplication>()

}