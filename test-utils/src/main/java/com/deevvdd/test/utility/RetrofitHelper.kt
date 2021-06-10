package com.deevvdd.test.utility

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by heinhtet deevvdd@gmail.com on 09,June,2021
 */
fun createRetrofitClient(url: HttpUrl, interceptor: Interceptor):
        Retrofit = Retrofit.Builder()
    .baseUrl(url)
    .client(createOkHttpClient(interceptor))
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

fun createOkHttpClient(interceptor: Interceptor): OkHttpClient =
    OkHttpClient.Builder().apply {
        addInterceptor(interceptor)
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(30, TimeUnit.SECONDS)
        writeTimeout(30, TimeUnit.SECONDS)
        callTimeout(30, TimeUnit.SECONDS)
    }.build()
