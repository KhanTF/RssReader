package ru.rage.rssreader.presentation.base.common.exception

import android.content.Context
import ru.rage.rssreader.R
import ru.rage.rssreader.domain.exceptions.InternetConnectionException
import ru.rage.rssreader.domain.exceptions.rss.RssNotFoundException

class ExceptionMapperImpl constructor(private val context: Context): ExceptionMapper{

    private fun getString(res: Int) : String = context.getString(res)

    override fun process(t: Throwable): String {
        return when(t){
            is InternetConnectionException -> getString(R.string.error_not_internet_connection)
            is RssNotFoundException -> getString(R.string.error_rss_not_found)
            else-> getString(R.string.error)
        }
    }

}