package ru.rage.rssreader.data.helper

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class FirstLaunchHelper @Inject constructor(private val context: Context) {

    companion object {
        private const val FIRST_LAUNCH_FLAG_PREFERENCES = "FIRST_LAUNCH_FLAG_PREFERENCES"
        private const val KEY_FIRST_LAUNCH = "KEY_FIRST_LAUNCH"
    }

    private val preferences: SharedPreferences
        get() = context.getSharedPreferences(FIRST_LAUNCH_FLAG_PREFERENCES, Context.MODE_PRIVATE)

    var isFirstLaunch: Boolean = false
        private set

    init {
        isFirstLaunch = preferences.getBoolean(KEY_FIRST_LAUNCH, true)
        if(isFirstLaunch){
            preferences
                    .edit()
                    .putBoolean(KEY_FIRST_LAUNCH,false)
                    .apply()
        }
    }

}