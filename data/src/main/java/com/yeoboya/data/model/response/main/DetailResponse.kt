package com.yeoboya.data.model.response.main

import com.yeoboya.domain.model.main.DetailResponseModel

data class DetailResponse(
    val id: Int,
    val rent_type: String,
    val area: Float,
    val location: String,
    val floor: Int,
    val size: Float,
    val room_type: String,
    val maintenance_fee: Int,
    val parking_fee: Int,
    val description: String
)

fun DetailResponse.asDetailResponseModel() = DetailResponseModel(
    id = id,
    rent_type = rent_type,
    area = area,
    location = location,
    floor = floor,
    size = size,
    room_type = room_type,
    maintenance_fee = maintenance_fee,
    parking_fee = parking_fee,
    description = description
)