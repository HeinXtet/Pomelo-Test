package com.deevvdd.domain.repository

import android.location.Location
import com.deevvdd.domain.model.result.Pickup
import com.deevvdd.domain.type.Either
import com.deevvdd.domain.type.exception.DataException

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
interface PickupLocationRepository {

    suspend fun fetchPickupLocation(): Either<DataException, List<Pickup>>

    fun updatePickupLocation(locations: List<Pickup>)

    suspend fun filterByLocation(location: Location): List<Pickup>
}