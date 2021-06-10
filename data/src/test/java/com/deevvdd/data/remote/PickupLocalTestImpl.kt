package com.deevvdd.data.remote

import android.location.Location
import android.location.LocationManager
import com.deevvdd.data.datasource.LocalDataSourceImpl
import com.deevvdd.domain.datasource.LocalDataSource
import com.deevvdd.test.utility.mock.PickupLocationMockData
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Created by heinhtet deevvdd@gmail.com on 09,June,2021
 */
@RunWith(RobolectricTestRunner::class)
class PickupLocalTestImpl {

    private lateinit var localSourceImpl: LocalDataSource

    @Before
    fun setUp() {
        localSourceImpl = LocalDataSourceImpl()
        localSourceImpl.updatePickupLocation(PickupLocationMockData.TO_SORT_PICK_UP_LIST_ACTUAL)
    }

    @Test
    fun `should return closet location when filter from pickup locations`() = runBlocking {
        val currentLocation = Location(LocationManager.GPS_PROVIDER)
        currentLocation.latitude = 16.801491
        currentLocation.longitude = 96.178335
        val result = localSourceImpl.filterByLocation(currentLocation)
        Truth.assertThat(result).isEqualTo(PickupLocationMockData.TO_SORT_PICK_UP_LIST_EXPECTED)
    }
}