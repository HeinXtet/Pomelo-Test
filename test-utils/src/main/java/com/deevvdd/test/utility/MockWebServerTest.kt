package com.deevvdd.test.utility

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
import org.junit.After
import org.junit.Before
import java.io.File
import java.net.HttpURLConnection

/**
 * Created by heinhtet deevvdd@gmail.com on 09,June,2021
 */
open class MockWebServerTest {

    lateinit var mockServer: MockWebServer

    @Before
    open fun setUp() {
        mockServer = MockWebServer()
        mockServer.start()
    }

    @After
    open fun tearDown() {
        mockServer.shutdown()
    }

    open fun enqueueFromFile(
        fileName: String,
        responseCode: Int = HttpURLConnection.HTTP_OK
    ) = mockServer.enqueue(
        MockResponse()
            .setResponseCode(responseCode)
            .setBody(getJsonStringFromResource(fileName))
    )

    open fun enqueueFromString(
        body: String,
        responseCode: Int = HttpURLConnection.HTTP_OK,
        socketPolicy: SocketPolicy = SocketPolicy.KEEP_OPEN
    ) = mockServer.enqueue(
        MockResponse()
            .setResponseCode(responseCode)
            .setBody(body)
            .apply {
                this.socketPolicy = socketPolicy
            }
    )

    fun getJsonStringFromResource(path: String): String =
        this.javaClass.classLoader?.getResource(path)?.run {
            String(File(this.path).readBytes())
        } ?: ""
}