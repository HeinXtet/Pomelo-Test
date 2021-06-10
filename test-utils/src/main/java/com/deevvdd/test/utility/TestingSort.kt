package com.deevvdd.test.utility

import android.location.Location
import com.deevvdd.domain.model.result.Pickup
import com.deevvdd.test.utility.mock.PickupLocationMockData

/**
 * Created by heinhtet deevvdd@gmail.com on 09,June,2021
 */
class TestingSort {

    fun sortedTest(): ArrayList<Pickup> {
        val location = Location("Test")
        location.latitude = 16.801487
        location.longitude = 96.178338
        val pickupList = ArrayList(PickupLocationMockData.TO_SORT_PICK_UP_LIST_ACTUAL)
        pickupList.sortWith { pickUp1, pickUp2 ->
            (pickUp1.getLocation().distanceTo(location) - pickUp2.getLocation()
                .distanceTo(location)).toInt()
        }
        return pickupList
    }
}