package com.deevvdd.data.network

import com.deevvdd.domain.model.response.PickupLocationData
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
interface ApiService {
    @GET("pickup-locations")
    suspend fun fetchPickUpLocation(): Response<PickupLocationData>
}