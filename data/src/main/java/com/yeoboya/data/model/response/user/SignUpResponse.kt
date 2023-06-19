package com.yeoboya.data.model.response.user

import com.yeoboya.domain.model.user.response.SignUpResponseModel

data class SignUpResponse(
    val message: String
)

fun SignUpResponse.asSignUpResponseModel() = SignUpResponseModel(
    message = message
)