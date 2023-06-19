package com.yeoboya.domain.repository

import com.yeoboya.domain.model.main.MainResponseModel

interface MainRepository {
    suspend fun getRooms(): List<MainResponseModel>

    suspend fun getMonthlyRooms(): List<MainResponseModel>

    suspend fun getLeaseRooms(): List<MainResponseModel>
}