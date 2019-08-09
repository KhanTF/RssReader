package ru.rage.rssreader.presentation.ui

import com.arellomobile.mvp.InjectViewState
import ru.rage.rssreader.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor() : BasePresenter<IMainView>(), IMainPresenter