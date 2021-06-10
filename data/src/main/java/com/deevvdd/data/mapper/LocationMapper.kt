package com.deevvdd.data.mapper

import com.deevvdd.domain.model.response.PickupData
import com.deevvdd.domain.model.response.PickupLocationData
import com.deevvdd.domain.model.result.Pickup
import javax.inject.Inject

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
class LocationMapper @Inject constructor() {

    fun toDomain(pickupLocationData: PickupLocationData?): List<Pickup> {
        return pickupLocationData?.pickup?.map { toDomain(it) }?.filter { it.active }.orEmpty()
    }

    private fun toDomain(locationData: PickupData?): Pickup {
        return Pickup(
            id = locationData?.id_pickup_location ?: 0,
            alias = locationData?.alias.orEmpty(),
            address1 = locationData?.address1.orEmpty(),
            city = locationData?.city.orEmpty(),
            active = locationData?.active ?: false,
            latitude = locationData?.latitude ?: 0.0,
            longitude = locationData?.longitude ?: 0.0
        )
    }
}