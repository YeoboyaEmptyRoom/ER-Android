package com.yeoboya.data.network

import com.yeoboya.data.model.response.main.MainResponse
import retrofit2.http.GET

interface MainApi {
    @GET("main/rooms")
    suspend fun getRooms(): List<MainResponse>

    @GET("main/rooms/monthly")
    suspend fun getMonthlyRooms(): List<MainResponse>

    @GET("main/rooms/lease")
    suspend fun getLeaseRooms(): List<MainResponse>
}