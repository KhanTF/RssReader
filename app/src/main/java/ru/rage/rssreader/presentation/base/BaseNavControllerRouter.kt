package ru.rage.rssreader.presentation.base

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation

class BaseNavControllerRouter {

    private var navController: NavController? = null

    fun perform(f: NavController.() -> Unit) {
        navController?.f()
    }

    class NavControllerHolder(
        private val baseNavControllerRouter: BaseNavControllerRouter,
        private val activity: Activity,
        private val navHostId: Int
    ) {

        private fun getController(): NavController? = Navigation.findNavController(activity, navHostId)

        fun getRequireController(): NavController = getController() ?: throw IllegalArgumentException("Controller not exist or activity not initiated yet")

        fun attach() {
            baseNavControllerRouter.navController = getController()
        }

        fun detach() {
            baseNavControllerRouter.navController = null
        }

    }

}