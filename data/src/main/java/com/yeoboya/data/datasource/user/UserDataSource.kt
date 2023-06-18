package com.yeoboya.data.datasource.user

import com.yeoboya.data.model.request.SignInRequest
import com.yeoboya.data.model.request.SignUpRequest
import com.yeoboya.data.model.response.UserResponse

interface UserDataSource {
    suspend fun signUp(body: SignUpRequest)

    suspend fun signIn(body: SignInRequest): UserResponse

    suspend fun logout()
}