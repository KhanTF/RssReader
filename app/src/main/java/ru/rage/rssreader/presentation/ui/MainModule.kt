package ru.rage.rssreader.presentation.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.rage.rssreader.R
import ru.rage.rssreader.presentation.base.BaseNavControllerRouter
import ru.rage.rssreader.presentation.base.common.exception.ExceptionMapper
import ru.rage.rssreader.presentation.base.common.exception.ExceptionMapperImpl

@Module(includes = [MainBuilder::class])
class MainModule{

    @Provides
    fun provideNavControllerHolder(navControllerRouter: BaseNavControllerRouter, mainActivity: MainActivity) : BaseNavControllerRouter.NavControllerHolder = BaseNavControllerRouter.NavControllerHolder(navControllerRouter,mainActivity, R.id.nav_host_fragment)

    @Provides
    fun provideExceptionMapper(context: Context) : ExceptionMapper = ExceptionMapperImpl(context)

}