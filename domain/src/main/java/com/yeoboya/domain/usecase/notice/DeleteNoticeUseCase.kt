package com.yeoboya.domain.usecase.notice

import com.yeoboya.domain.model.notice.request.NoticeRequestModel
import com.yeoboya.domain.repository.NoticeRepository
import javax.inject.Inject

class DeleteNoticeUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke(id: Int, noticeRequestModel: NoticeRequestModel) = kotlin.runCatching { noticeRepository.deleteNotice(id, noticeRequestModel) }
}