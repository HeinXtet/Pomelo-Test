package com.deevvdd.pomelofashion.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
object RecyclerBindingUtils {
    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        recyclerView.adapter = adapter
    }
}
