package com.deevvdd.domain.model.result

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */

data class PickupLocation(
    val numberOfNewLocations: Int,
    val pickupLocation: List<Pickup>
)