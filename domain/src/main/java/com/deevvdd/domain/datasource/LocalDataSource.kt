package com.deevvdd.domain.datasource

import android.location.Location
import com.deevvdd.domain.model.result.Pickup

/**
 * Created by heinhtet deevvdd@gmail.com on 09,June,2021
 */
interface LocalDataSource {
    suspend fun filterByLocation(location: Location): List<Pickup>

    fun updatePickupLocation(locations: List<Pickup>)
}