package com.yeoboya.data.datasource.user

import com.yeoboya.data.model.request.user.SignInRequest
import com.yeoboya.data.model.request.user.SignUpRequest
import com.yeoboya.data.model.response.user.SignUpResponse
import com.yeoboya.data.model.response.user.UserResponse

interface UserDataSource {
    suspend fun signUp(body: SignUpRequest): SignUpResponse

    suspend fun signIn(body: SignInRequest): UserResponse

    suspend fun logout()
}