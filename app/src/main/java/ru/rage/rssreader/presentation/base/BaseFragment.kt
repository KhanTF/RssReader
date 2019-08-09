package ru.rage.rssreader.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpAppCompatFragment
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragment : MvpAppCompatFragment(), HasSupportFragmentInjector, IBaseView {

    abstract val layoutId: Int

    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentInjector
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun showMessage(text: Int) {
        val view = view
        if (view != null)
            Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
    }

    override fun showMessage(text: String) {
        val view = view
        if (view != null)
            Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
    }

}