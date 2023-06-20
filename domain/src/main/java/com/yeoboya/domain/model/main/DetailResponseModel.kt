package com.yeoboya.domain.model.main

data class DetailResponseModel(
    val id: Int,
    val rent_type: String,
    val area: Float,
    val location: String,
    val floor: Int,
    val size: Float,
    val room_type: String,
    val maintenance_fee: Int,
    val parking_fee: Int,
    val description: String,
    val price: String
)
