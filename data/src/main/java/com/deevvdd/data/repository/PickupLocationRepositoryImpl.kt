package com.deevvdd.data.repository

import android.location.Location
import com.deevvdd.domain.datasource.LocalDataSource
import com.deevvdd.domain.datasource.RemoteDataSource
import com.deevvdd.domain.model.result.Pickup
import com.deevvdd.domain.repository.PickupLocationRepository
import com.deevvdd.domain.type.Either
import com.deevvdd.domain.type.exception.DataException
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
class PickupLocationRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    PickupLocationRepository {
    override suspend fun fetchPickupLocation(): Either<DataException, List<Pickup>> {
        return remoteDataSource.fetchPickupLocations().collect({
            Either.Left(it)
        }, {
            val activePickupList = it.filter { pickup -> pickup.active }
            GlobalScope.launch { localDataSource.updatePickupLocation(activePickupList) }
            Either.Right(activePickupList)
        })
    }

    override fun updatePickupLocation(locations: List<Pickup>) {
        localDataSource.updatePickupLocation(locations)
    }

    override suspend fun filterByLocation(location: Location): List<Pickup> {
        return localDataSource.filterByLocation(location)
    }
}