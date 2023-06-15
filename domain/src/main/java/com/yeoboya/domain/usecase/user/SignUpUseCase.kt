package com.yeoboya.domain.usecase.user

import com.yeoboya.domain.model.user.request.SignUpRequestModel
import com.yeoboya.domain.repository.UserRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(body: SignUpRequestModel) = userRepository.signUp(body)
}