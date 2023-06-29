package com.yeoboya.domain.usecase.notice

import com.yeoboya.domain.model.notice.request.NoticeRequestModel
import com.yeoboya.domain.repository.NoticeRepository
import javax.inject.Inject

class ModifyNoticeUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke(id: Int, noticeRequestModel: NoticeRequestModel) = kotlin.runCatching { noticeRepository.modifyNotice(id, noticeRequestModel) }
}