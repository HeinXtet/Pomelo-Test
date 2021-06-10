package com.deevvdd.domain.model.result

import android.location.Location

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
data class Pickup(
    val id: Int,
    val alias: String,
    val city: String,
    val address1: String,
    val active: Boolean,
    val latitude: Double,
    val longitude: Double
) {
    fun getLocation(): Location {
        val location = Location("Pickup $city")
        location.latitude = latitude
        location.longitude = longitude
        return location
    }
}