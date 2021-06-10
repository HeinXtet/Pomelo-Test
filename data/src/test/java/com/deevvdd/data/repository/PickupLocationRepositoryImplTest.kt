package com.deevvdd.data.repository

import com.deevvdd.domain.datasource.LocalDataSource
import com.deevvdd.domain.datasource.RemoteDataSource
import com.deevvdd.domain.repository.PickupLocationRepository
import com.deevvdd.domain.type.Either
import com.deevvdd.test.utility.mock.PickupLocationMockData
import com.google.common.truth.Truth
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Created by heinhtet deevvdd@gmail.com on 09,June,2021
 */

class PickupLocationRepositoryImplTest {

    private lateinit var repository: PickupLocationRepository
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var localDataSource: LocalDataSource

    @Before
    fun setUp() {
        remoteDataSource = mock()
        localDataSource = mock()
        repository = PickupLocationRepositoryImpl(
            remoteDataSource,
            localDataSource
        )
    }

    @Test
    fun `should return active pickup locations when fetchPickupLocations`() = runBlocking {
        whenever(remoteDataSource.fetchPickupLocations()).thenReturn(
            Either.Right(
                PickupLocationMockData.ACTIVE_PICKUP_LIVE
            )
        )
        val result = remoteDataSource.fetchPickupLocations()
        verify(remoteDataSource)
        Truth.assertThat(result.rightOrNull()?.value).isNotEmpty()
    }
}