package com.yeoboya.data.model.request

import com.yeoboya.domain.model.user.request.SignUpRequestModel

data class SignUpRequest(
    val email: String,
    val username: String,
    val password1: String,
    val password2: String
)

fun SignUpRequestModel.asSignUpRequest() = SignUpRequest(
    email = email,
    username = username,
    password1 = password1,
    password2 = password2
)
