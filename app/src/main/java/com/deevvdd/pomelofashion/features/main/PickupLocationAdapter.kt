package com.deevvdd.pomelofashion.features.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.deevvdd.domain.model.result.Pickup
import com.deevvdd.pomelofashion.databinding.ItemPickLocationBinding

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
class PickupLocationAdapter : ListAdapter<Pickup, RecyclerView.ViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Pickup>() {
            override fun areItemsTheSame(oldItem: Pickup, newItem: Pickup): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Pickup, newItem: Pickup): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PickupLocationViewHolder(
            ItemPickLocationBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PickupLocationViewHolder) {
            holder.onBind(getItem(position))
        }
    }
}

class PickupLocationViewHolder(val binding: ItemPickLocationBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: Pickup) {
        binding.data = item
    }
}
