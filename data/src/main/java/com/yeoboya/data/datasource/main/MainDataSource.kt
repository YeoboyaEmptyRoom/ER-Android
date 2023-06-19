package com.yeoboya.data.datasource.main

import com.yeoboya.data.model.response.main.MainResponse

interface MainDataSource {
    suspend fun getRooms(): List<MainResponse>

    suspend fun getMonthlyRooms(): List<MainResponse>

    suspend fun getLeaseRooms(): List<MainResponse>
}