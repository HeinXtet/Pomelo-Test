package com.deevvdd.domain.datasource

import com.deevvdd.domain.model.result.Pickup
import com.deevvdd.domain.type.Either
import com.deevvdd.domain.type.exception.DataException

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */

interface RemoteDataSource {
    suspend fun fetchPickupLocations(): Either<DataException, List<Pickup>>
}