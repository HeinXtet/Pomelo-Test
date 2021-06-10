package com.deevvdd.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.deevvdd.data.datasource.RemoteDataSourceImpl
import com.deevvdd.data.mapper.LocationMapper
import com.deevvdd.data.network.ApiService
import com.deevvdd.data.network.HeaderInterceptor
import com.deevvdd.data.network.URL
import com.deevvdd.domain.datasource.RemoteDataSource
import com.deevvdd.domain.type.exception.DataException
import com.deevvdd.test.utility.MainCoroutineRule
import com.deevvdd.test.utility.MockWebServerTest
import com.deevvdd.test.utility.createRetrofitClient
import com.deevvdd.test.utility.mock.PickupLocationMockData.CREATE_PICKUP_RESPONSE
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.SocketPolicy
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by heinhtet deevvdd@gmail.com on 09,June,2021
 */
class MainRemoteImplTest : MockWebServerTest() {

    private lateinit var mainRemote: RemoteDataSource

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    override fun setUp() {
        super.setUp()
        val url = mockServer.url("/")
        val retrofit = createRetrofitClient(url, HeaderInterceptor())
        mainRemote = RemoteDataSourceImpl(
            retrofit.create(ApiService::class.java),
            LocationMapper()
        )
    }

    @Test
    fun `should use pickup location path url when fetchPickupLocations`() = runBlocking {
        enqueueFromString("")
        mainRemote.fetchPickupLocations().collect({}, {})
        val request = mockServer.takeRequest()
        Truth.assertThat(request.path).endsWith(URL.PICKUP_LOCATION)
    }

    @Test
    fun `should include x-api-key HEADER to fetchPickupLocations  call`() = runBlocking {
        enqueueFromString("{}")
        mainRemote.fetchPickupLocations().collect({}, {})
        val request = mockServer.takeRequest()
        Truth.assertThat(request.headers["x-api-key"]).isNotEmpty()
    }

    @Test
    fun `should return pickup not empty when fetchPickupLocations call succeed`() = runBlocking {
        enqueueFromString(
            body = CREATE_PICKUP_RESPONSE
        )
        val result = mainRemote.fetchPickupLocations()
        Truth.assertThat(result.rightOrNull()?.value).isNotEmpty()
    }

    @Test
    fun `should return network error when fetchPickupLocations timeouts`() = runBlocking {
        enqueueFromString(
            body = CREATE_PICKUP_RESPONSE,
            socketPolicy = SocketPolicy.DISCONNECT_AFTER_REQUEST
        )
        val result = mainRemote.fetchPickupLocations()
        Truth.assertThat(result.leftOrNull()?.value)
            .isInstanceOf(DataException.Network::class.java)
    }
}