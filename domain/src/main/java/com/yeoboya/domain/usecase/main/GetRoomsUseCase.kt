package com.yeoboya.domain.usecase.main

import com.yeoboya.domain.repository.MainRepository
import javax.inject.Inject

class GetRoomsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { mainRepository.getRooms() }
}