package com.deevvdd.domain.model.response

import com.squareup.moshi.Json

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */

data class PickupLocationData(
    @field:Json(name = "number_of_new_locations")
    val number_of_new_locations: Int,

    @field:Json(name = "pickup")
    val pickup: List<PickupData>
)