package com.yeoboya.data.repository

import com.yeoboya.data.datasource.user.UserDataSource
import com.yeoboya.data.model.request.user.asSignInRequest
import com.yeoboya.data.model.request.user.asSignUpRequest
import com.yeoboya.data.model.response.user.asSignUpResponseModel
import com.yeoboya.data.model.response.user.asUserResponseModel
import com.yeoboya.domain.model.user.request.SignInRequestModel
import com.yeoboya.domain.model.user.request.SignUpRequestModel
import com.yeoboya.domain.model.user.response.SignUpResponseModel
import com.yeoboya.domain.model.user.response.UserResponseModel
import com.yeoboya.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
): UserRepository {
    override suspend fun signUp(body: SignUpRequestModel): SignUpResponseModel = userDataSource.signUp(body.asSignUpRequest()).asSignUpResponseModel()

    override suspend fun signIn(body: SignInRequestModel): UserResponseModel = userDataSource.signIn(body.asSignInRequest()).asUserResponseModel()

    override suspend fun logout() = userDataSource.logout()
}