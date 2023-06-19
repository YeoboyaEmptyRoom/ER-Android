package com.yeoboya.data.datasource.main

import com.yeoboya.data.model.response.main.DetailResponse
import com.yeoboya.data.model.response.main.MainResponse
import com.yeoboya.data.network.MainApi
import com.yeoboya.data.util.safeApiCall
import javax.inject.Inject

class MainDataSourceImpl @Inject constructor(
    private val mainApi: MainApi
): MainDataSource {
    override suspend fun getRooms(): List<MainResponse> = safeApiCall { mainApi.getRooms() }

    override suspend fun getMonthlyRooms(): List<MainResponse> = safeApiCall { mainApi.getMonthlyRooms() }

    override suspend fun getLeaseRooms(): List<MainResponse> = safeApiCall { mainApi.getLeaseRooms() }

    override suspend fun getDetail(id: Int): DetailResponse = safeApiCall { mainApi.getDetail(id) }
}