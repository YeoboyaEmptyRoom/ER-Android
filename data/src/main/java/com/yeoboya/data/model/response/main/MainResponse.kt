package com.yeoboya.data.model.response.main

import com.yeoboya.domain.model.main.MainResponseModel

data class MainResponse(
    val id: Int,
    val rent_type: String,
    val price: String,
    val area: Float,
    val location: String,
    val room_type: String
)

fun MainResponse.asMainResponseModel() = MainResponseModel(
    id = id,
    rent_type = rent_type,
    price = price,
    area = area,
    location = location,
    room_type = room_type
)