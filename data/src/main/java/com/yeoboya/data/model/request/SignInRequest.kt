package com.yeoboya.data.model.request

import com.yeoboya.domain.model.user.request.SignInRequestModel

data class SignInRequest(
    val email: String,
    val password: String
)

fun SignInRequestModel.asSignInRequest() = SignInRequest(
    email = email,
    password = password
)