package com.yeoboya.data.model.response

import com.yeoboya.domain.model.user.response.UserResponseModel

data class UserResponse(
    val key: String,
    val user: UserItemResponse
)

fun UserResponse.asUserResponseModel() = UserResponseModel(
    key = key,
    user = user.asUserItemResponseModel()
)