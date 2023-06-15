package com.yeoboya.domain.usecase.user

import com.yeoboya.domain.model.user.request.SignInRequestModel
import com.yeoboya.domain.repository.UserRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(body: SignInRequestModel) = kotlin.runCatching { userRepository.signIn(body) }
}