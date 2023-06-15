package com.yeoboya.domain.repository

import com.yeoboya.domain.model.user.request.SignInRequestModel
import com.yeoboya.domain.model.user.request.SignUpRequestModel
import com.yeoboya.domain.model.user.response.UserResponseModel

interface UserRepository {
    suspend fun signUp(body: SignUpRequestModel): UserResponseModel

    suspend fun signIn(body: SignInRequestModel): UserResponseModel

    suspend fun logout()
}