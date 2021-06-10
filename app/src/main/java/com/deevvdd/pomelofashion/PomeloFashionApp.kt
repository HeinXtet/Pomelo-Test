package com.deevvdd.pomelofashion

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
@HiltAndroidApp
class PomeloFashionApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
