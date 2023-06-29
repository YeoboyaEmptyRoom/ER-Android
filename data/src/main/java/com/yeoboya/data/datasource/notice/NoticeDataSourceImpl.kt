package com.yeoboya.data.datasource.notice

import com.yeoboya.data.model.request.notice.NoticeRequest
import com.yeoboya.data.model.response.notice.NoticeDetailResponse
import com.yeoboya.data.model.response.notice.NoticeMessageResponse
import com.yeoboya.data.model.response.notice.NoticeResponse
import com.yeoboya.data.network.NoticeApi
import com.yeoboya.data.util.safeApiCall
import javax.inject.Inject

class NoticeDataSourceImpl @Inject constructor(
    private val noticeApi: NoticeApi
): NoticeDataSource {
    override suspend fun noticeCreate(noticeRequest: NoticeRequest): NoticeMessageResponse = safeApiCall { noticeApi.noticeCreate(noticeRequest) }

    override suspend fun getNoticeList(): List<NoticeResponse> = safeApiCall { noticeApi.getNoticeList() }

    override suspend fun getDetailNotice(id: Int): NoticeDetailResponse = safeApiCall { noticeApi.getDetailNotice(id) }

    override suspend fun modifyNotice(id: Int, noticeRequest: NoticeRequest): NoticeMessageResponse = safeApiCall { noticeApi.modifyNotice(id, noticeRequest) }

    override suspend fun deleteNotice(id: Int, noticeRequest: NoticeRequest): NoticeMessageResponse = safeApiCall { noticeApi.deleteNotice(id, noticeRequest) }
}