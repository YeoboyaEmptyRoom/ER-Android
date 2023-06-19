package com.yeoboya.data.model.request

import com.yeoboya.domain.model.user.request.SignUpRequestModel

data class SignUpRequest(
    val email: String,
    val username: String,
    val password: String,
    val password_confirm: String
)

fun SignUpRequestModel.asSignUpRequest() = SignUpRequest(
    email = email,
    username = username,
    password = password,
    password_confirm = password_confirm
)
