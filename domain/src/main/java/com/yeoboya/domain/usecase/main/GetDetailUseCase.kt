package com.yeoboya.domain.usecase.main

import com.yeoboya.domain.repository.MainRepository
import javax.inject.Inject

class GetDetailUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(id: Int) = kotlin.runCatching { mainRepository.getDetail(id) }
}