package com.yeoboya.data.model.response.main

data class MainResponse(
    val id: Int,
    val rent_type: String,
    val area: Float,
    val location: String,
    val room_type: String
)
