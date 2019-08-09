package ru.rage.rssreader.data.network.cache

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response

class CacheInterceptor(private val context: Context) : Interceptor {

    companion object {
        private const val CACHE_TIME = 7 * 24 * 60 * 60
    }

    private fun isOnline(): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        val networkInfo = manager?.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return if (request.method == "GET") {
            if (isOnline()) {
                chain
                    .proceed(
                        request
                            .newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, max-age=30")
                            .build()
                    )
                    .newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, max-age=$CACHE_TIME")
                    .build()
            } else {
                chain.proceed(
                    request
                        .newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=$CACHE_TIME")
                        .build()
                )
            }
        } else {
            chain.proceed(request)
        }
    }

}