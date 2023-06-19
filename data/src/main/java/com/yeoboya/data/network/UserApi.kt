package com.yeoboya.data.network

import com.yeoboya.data.model.request.SignInRequest
import com.yeoboya.data.model.request.SignUpRequest
import com.yeoboya.data.model.response.SignUpResponse
import com.yeoboya.data.model.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("user/signup/")
    suspend fun signUp(
        @Body body: SignUpRequest
    ): SignUpResponse

    @POST("user/login/")
    suspend fun signIn(
        @Body body: SignInRequest
    ): UserResponse

    @POST("user/logout/")
    suspend fun logout()
}