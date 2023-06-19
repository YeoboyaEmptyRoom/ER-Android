package com.yeoboya.domain.model.user.request

data class SignUpRequestModel(
    val email: String,
    val username: String,
    val password: String,
    val password_confirm: String
)
