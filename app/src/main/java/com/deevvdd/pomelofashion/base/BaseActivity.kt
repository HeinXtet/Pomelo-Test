package com.deevvdd.pomelofashion.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
abstract class BaseActivity<VM : BaseViewModel<E>, E> : AppCompatActivity() {
    var skipInjection = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getOrCreateViewModel().streamEvents().observeEvent(this, ::renderEvent)
    }

    abstract fun getOrCreateViewModel(): VM

    abstract fun renderEvent(event: E)
}
