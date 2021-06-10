package com.deevvdd.data.datasource

import com.deevvdd.data.mapper.LocationMapper
import com.deevvdd.data.network.ApiService
import com.deevvdd.data.network.BaseRemoteRepository
import com.deevvdd.domain.datasource.RemoteDataSource
import com.deevvdd.domain.model.result.Pickup
import com.deevvdd.domain.type.Either
import com.deevvdd.domain.type.exception.DataException
import javax.inject.Inject

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: LocationMapper
) :
    RemoteDataSource, BaseRemoteRepository() {
    override suspend fun fetchPickupLocations(): Either<DataException, List<Pickup>> {
        return safeApiCall(
            apiCall = { apiService.fetchPickUpLocation() },
            mapper = {
                mapper.toDomain(it)
            })
    }
}