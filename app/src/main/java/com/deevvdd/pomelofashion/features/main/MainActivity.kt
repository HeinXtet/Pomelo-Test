package com.deevvdd.pomelofashion.features.main

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.afollestad.materialdialogs.MaterialDialog
import com.deevvdd.pomelofashion.R
import com.deevvdd.pomelofashion.base.BaseActivity
import com.deevvdd.pomelofashion.databinding.ActivityMainBinding
import com.deevvdd.pomelofashion.utils.LocationHandler
import com.deevvdd.pomelofashion.utils.LocationHandler.Companion.REQUEST_CHECK_SETTINGS
import com.permissionx.guolindev.PermissionX
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, MainEvent>() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var pickupLocationAdapter: PickupLocationAdapter
    private var locationHandler: LocationHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        pickupLocationAdapter = PickupLocationAdapter()
        setSupportActionBar(binding.toolbar)
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = viewModel
            adapter = pickupLocationAdapter
        }
        locationHandler =
            LocationHandler(this, onLocationUpdated = {
                Timber.d("location updated -> $it")
                viewModel.filterLocation(it)
            }, onLocationUpdateOnError = {
                showLocationNotFoundDialog()
            })
        viewModel.pickupLocations.observe(this, { locations ->
            pickupLocationAdapter.submitList(
                locations
            ) { binding.rvPickupLocation.scrollToPosition(0) }
        })
    }

    private fun showLocationNotFoundDialog() {
        MaterialDialog(this).show {
            title(text = getString(R.string.common_error_title))
            message(text = getString(R.string.error_location_not_found_message))
            positiveButton(
                text =
                getString(R.string.btn_text_retry)
            ) { requestLocationPermission() }
            negativeButton(
                text =
                getString(R.string.btn_text_cancel)
            ) {}
        }
    }

    override fun getOrCreateViewModel() = viewModel
    override fun renderEvent(event: MainEvent) {
        when (event) {
            is MainEvent.FailToDetectLocation -> {
                showLocationNotFoundDialog()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_current_location -> {
                requestLocationPermission()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getUserLocation() {
        locationHandler?.requestLocation()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK &&
            requestCode == REQUEST_CHECK_SETTINGS
        ) {
            getUserLocation()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun requestLocationPermission() {
        PermissionX.init(this)
            .permissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ).explainReasonBeforeRequest()
            .onForwardToSettings { scope, deniedList ->
                scope.showForwardToSettingsDialog(
                    deniedList,
                    getString(R.string.text_suggest_to_give_permission),
                    getString(R.string.btn_ok),
                    getString(R.string.btn_cancel)
                )
            }
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    locationHandler?.requestLocation()
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        locationHandler = null
    }
}