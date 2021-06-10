package com.deevvdd.data.datasource

import android.location.Location
import com.deevvdd.domain.datasource.LocalDataSource
import com.deevvdd.domain.model.result.Pickup
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * Created by heinhtet deevvdd@gmail.com on 09,June,2021
 */
class LocalDataSourceImpl @Inject constructor() : LocalDataSource {

    private val cachedPickupLocations = ArrayList<Pickup>()

    override suspend fun filterByLocation(location: Location): List<Pickup> {
        cachedPickupLocations.sortWith { pickUp1, pickUp2 ->
            (pickUp1.getLocation().distanceTo(location) - pickUp2.getLocation()
                .distanceTo(location)).toInt()
        }
        return cachedPickupLocations
    }

    override fun updatePickupLocation(locations: List<Pickup>) {
        cachedPickupLocations.clear()
        cachedPickupLocations.addAll(locations)
    }
}