package com.yeoboya.domain.model.main

data class MainResponseModel(
    val id: Int,
    val rent_type: String,
    val price: String,
    val area: Float,
    val location: String,
    val room_type: String
)
