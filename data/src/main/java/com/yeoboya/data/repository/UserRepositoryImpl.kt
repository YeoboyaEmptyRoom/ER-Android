package com.yeoboya.data.repository

import com.yeoboya.data.datasource.user.UserDataSource
import com.yeoboya.data.model.request.asSignInRequest
import com.yeoboya.data.model.request.asSignUpRequest
import com.yeoboya.data.model.response.asUserResponseModel
import com.yeoboya.domain.model.user.request.SignInRequestModel
import com.yeoboya.domain.model.user.request.SignUpRequestModel
import com.yeoboya.domain.model.user.response.UserResponseModel
import com.yeoboya.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
): UserRepository {
    override suspend fun signUp(body: SignUpRequestModel) = userDataSource.signUp(body.asSignUpRequest())

    override suspend fun signIn(body: SignInRequestModel): UserResponseModel = userDataSource.signIn(body.asSignInRequest()).asUserResponseModel()

    override suspend fun logout() = userDataSource.logout()
}