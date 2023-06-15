package com.yeoboya.domain.model.user.request

data class SignUpRequestModel(
    val email: String,
    val username: String,
    val password1: String,
    val password2: String
)
