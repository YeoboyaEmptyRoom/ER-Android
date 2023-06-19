package com.yeoboya.data.datasource.user

import com.yeoboya.data.model.request.user.SignInRequest
import com.yeoboya.data.model.request.user.SignUpRequest
import com.yeoboya.data.model.response.user.SignUpResponse
import com.yeoboya.data.model.response.user.UserResponse
import com.yeoboya.data.network.UserApi
import com.yeoboya.data.util.safeApiCall
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userApi: UserApi
): UserDataSource {
    override suspend fun signUp(body: SignUpRequest): SignUpResponse = safeApiCall { userApi.signUp(body) }

    override suspend fun signIn(body: SignInRequest): UserResponse = safeApiCall { userApi.signIn(body) }

    override suspend fun logout() = safeApiCall { userApi.logout() }
}