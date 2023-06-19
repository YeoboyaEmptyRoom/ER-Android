package com.yeoboya.data.model.response.user

import com.yeoboya.domain.model.user.response.UserItemResponseModel

data class UserItemResponse(
    val email: String,
    val username: String
)

fun UserItemResponse.asUserItemResponseModel() = UserItemResponseModel(
    email = email,
    username = username
)