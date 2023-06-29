package com.yeoboya.domain.repository

import com.yeoboya.domain.model.notice.request.NoticeRequestModel
import com.yeoboya.domain.model.notice.response.NoticeDetailResponseModel
import com.yeoboya.domain.model.notice.response.NoticeMessageResponseModel
import com.yeoboya.domain.model.notice.response.NoticeResponseModel

interface NoticeRepository {
    suspend fun noticeCreate(noticeRequest: NoticeRequestModel): NoticeMessageResponseModel

    suspend fun getNoticeList(): List<NoticeResponseModel>

    suspend fun getDetailNotice(id: Int): NoticeDetailResponseModel

    suspend fun modifyNotice(id: Int, noticeRequest: NoticeRequestModel): NoticeMessageResponseModel

    suspend fun deleteNotice(id: Int, noticeRequest: NoticeRequestModel): NoticeMessageResponseModel
}