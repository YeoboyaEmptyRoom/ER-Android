package com.yeoboya.data.datasource.notice

import com.yeoboya.data.model.request.notice.NoticeRequest
import com.yeoboya.data.model.response.notice.NoticeDetailResponse
import com.yeoboya.data.model.response.notice.NoticeMessageResponse
import com.yeoboya.data.model.response.notice.NoticeResponse

interface NoticeDataSource {

    suspend fun noticeCreate(noticeRequest: NoticeRequest): NoticeMessageResponse

    suspend fun getNoticeList(): List<NoticeResponse>

    suspend fun getDetailNotice(id: Int): NoticeDetailResponse

    suspend fun modifyNotice(id: Int, noticeRequest: NoticeRequest): NoticeMessageResponse

    suspend fun deleteNotice(id: Int, noticeRequest: NoticeRequest): NoticeMessageResponse
}