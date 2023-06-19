package com.yeoboya.data.model.response

import com.yeoboya.domain.model.user.response.SignUpResponseModel

data class SignUpResponse(
    val message: String
)

fun SignUpResponse.asSignUpResponseModel() = SignUpResponseModel(
    message = message
)