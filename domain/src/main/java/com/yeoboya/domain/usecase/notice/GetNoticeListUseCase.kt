package com.yeoboya.domain.usecase.notice

import com.yeoboya.domain.repository.NoticeRepository
import javax.inject.Inject

class GetNoticeListUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { noticeRepository.getNoticeList() }
}