package com.yeoboya.domain.repository

import com.yeoboya.domain.model.user.request.SignInRequestModel
import com.yeoboya.domain.model.user.request.SignUpRequestModel
import com.yeoboya.domain.model.user.response.SignUpResponseModel
import com.yeoboya.domain.model.user.response.UserResponseModel

interface UserRepository {
    suspend fun signUp(body: SignUpRequestModel): SignUpResponseModel

    suspend fun signIn(body: SignInRequestModel): UserResponseModel

    suspend fun logout()
}