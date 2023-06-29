package com.yeoboya.domain.usecase.notice

import com.yeoboya.domain.repository.NoticeRepository
import javax.inject.Inject

class GetDetailNoticeUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke(id: Int) = kotlin.runCatching { noticeRepository.getDetailNotice(id) }
}