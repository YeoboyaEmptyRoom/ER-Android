package com.yeoboya.domain.usecase.user

import com.yeoboya.domain.repository.UserRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { userRepository.logout() }
}