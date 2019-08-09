package ru.rage.rssreader.presentation.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity(), HasSupportFragmentInjector, IBaseView {

    abstract val layoutId: Int

    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }

    private fun getRoot(): View = window.decorView.findViewById(android.R.id.content)

    override fun showMessage(text: Int) {
        Snackbar.make(getRoot(), text, Snackbar.LENGTH_LONG).show()
    }

    override fun showMessage(text: String) {
        Snackbar.make(getRoot(), text, Snackbar.LENGTH_LONG).show()
    }

}