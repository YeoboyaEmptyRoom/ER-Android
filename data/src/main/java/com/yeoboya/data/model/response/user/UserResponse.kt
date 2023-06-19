package com.yeoboya.data.model.response.user

import com.yeoboya.domain.model.user.response.UserResponseModel

data class UserResponse(
    val key: String
)

fun UserResponse.asUserResponseModel() = UserResponseModel(
    key = key
)