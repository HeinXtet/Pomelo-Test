package com.deevvdd.domain.model.response

import com.squareup.moshi.Json

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
data class PickupData(

    @field:Json(name = "id_pickup_location")
    val id_pickup_location: Int,

    @field:Json(name = "alias")
    val alias: String? = null,

    @field:Json(name = "address1")
    val address1: String? = null,

    @field:Json(name = "city")
    val city: String? = null,

    @field:Json(name = "active")
    val active: Boolean?,

    @field:Json(name = "latitude")
    val latitude: Double? = null,
    @field:Json(name = "longitude")
    val longitude: Double? = null
)