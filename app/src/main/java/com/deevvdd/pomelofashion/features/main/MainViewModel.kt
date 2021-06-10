package com.deevvdd.pomelofashion.features.main

import android.content.Context
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.deevvdd.domain.model.result.Pickup
import com.deevvdd.domain.repository.PickupLocationRepository
import com.deevvdd.pomelofashion.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Created by heinhtet deevvdd@gmail.com on 08,June,2021
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val repository: PickupLocationRepository
) : BaseViewModel<MainEvent>() {
    private val _pickupLocations = MutableLiveData<List<Pickup>>()
    private val _loading = MutableLiveData<Boolean>()
    private val _errorFetchingPickupLocation = MutableLiveData<String?>()

    val errorFetchingPickupLocation: LiveData<String?>
        get() {
            return _errorFetchingPickupLocation
        }

    val loading: LiveData<Boolean>
        get() {
            return _loading
        }

    val pickupLocations =
        Transformations.map(_pickupLocations) {
            it
        }

    init {
        fetchPickupLocation()
    }

    fun fetchPickupLocation() {
        _errorFetchingPickupLocation.value = null
        viewModelScope.launch {
            _loading.value = true
            repository.fetchPickupLocation().collect({
                _loading.value = false
                _errorFetchingPickupLocation.value = it.message
            }, {
                _errorFetchingPickupLocation.value = null
                _loading.value = false
                _pickupLocations.value = it
                Timber.d("data list $it")
            })
        }
    }

    fun filterLocation(location: Location) {
        viewModelScope.launch {
            repository.filterByLocation(location).let {
                _pickupLocations.value = it
            }
        }
    }
}
