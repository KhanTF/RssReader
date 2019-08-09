package ru.rage.rssreader.presentation.ui

import android.os.Bundle
import androidx.navigation.ui.setupWithNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.rage.rssreader.R
import ru.rage.rssreader.presentation.base.BaseActivity
import ru.rage.rssreader.presentation.base.BaseNavControllerRouter
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : BaseActivity(), IMainView {

    @Inject
    lateinit var presenterProvider : Provider<MainPresenter>

    @Inject
    lateinit var navControllerHolder: BaseNavControllerRouter.NavControllerHolder

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() : MainPresenter =  presenterProvider.get()

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navControllerHolder.getRequireController())
    }

    override fun onResume() {
        super.onResume()
        navControllerHolder.attach()
    }

    override fun onPause() {
        navControllerHolder.detach()
        super.onPause()
    }

}
