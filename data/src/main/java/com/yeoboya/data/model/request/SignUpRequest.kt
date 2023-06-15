package com.yeoboya.data.model.request

data class SignUpRequest(
    val email: String,
    val username: String,
    val password1: String,
    val password2: String
)
