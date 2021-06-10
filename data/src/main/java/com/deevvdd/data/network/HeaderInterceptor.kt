package com.deevvdd.data.network

import com.deevvdd.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by heinhtet deevvdd@gmail.com on 09,June,2021
 */
class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        original = original.newBuilder()
            .addHeader("x-api-key", BuildConfig.API_KEY)
            .build()
        return chain.proceed(original)
    }
}
