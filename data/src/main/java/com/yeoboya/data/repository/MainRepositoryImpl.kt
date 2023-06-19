package com.yeoboya.data.repository

import com.yeoboya.data.datasource.main.MainDataSource
import com.yeoboya.data.model.response.main.asMainResponseModel
import com.yeoboya.domain.model.main.MainResponseModel
import com.yeoboya.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource
): MainRepository {
    override suspend fun getRooms(): List<MainResponseModel> = mainDataSource.getRooms().map { it.asMainResponseModel() }

    override suspend fun getMonthlyRooms(): List<MainResponseModel> = mainDataSource.getMonthlyRooms().map { it.asMainResponseModel() }

    override suspend fun getLeaseRooms(): List<MainResponseModel> = mainDataSource.getLeaseRooms().map { it.asMainResponseModel() }
}