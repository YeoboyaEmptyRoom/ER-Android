package com.yeoboya.data.repository

import com.yeoboya.data.datasource.notice.NoticeDataSource
import com.yeoboya.data.model.request.notice.asNoticeRequest
import com.yeoboya.data.model.response.notice.asNoticeDetailResponseModel
import com.yeoboya.data.model.response.notice.asNoticeMessageResponseModel
import com.yeoboya.data.model.response.notice.asNoticeResponseModel
import com.yeoboya.domain.model.notice.request.NoticeRequestModel
import com.yeoboya.domain.model.notice.response.NoticeDetailResponseModel
import com.yeoboya.domain.model.notice.response.NoticeMessageResponseModel
import com.yeoboya.domain.model.notice.response.NoticeResponseModel
import com.yeoboya.domain.repository.NoticeRepository
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val noticeDataSource: NoticeDataSource
): NoticeRepository {
    override suspend fun noticeCreate(noticeRequest: NoticeRequestModel): NoticeMessageResponseModel =
        noticeDataSource.noticeCreate(noticeRequest.asNoticeRequest()).asNoticeMessageResponseModel()

    override suspend fun getNoticeList(): List<NoticeResponseModel> = noticeDataSource.getNoticeList().map { it.asNoticeResponseModel() }

    override suspend fun getDetailNotice(id: Int): NoticeDetailResponseModel = noticeDataSource.getDetailNotice(id).asNoticeDetailResponseModel()

    override suspend fun modifyNotice(id: Int, noticeRequest: NoticeRequestModel): NoticeMessageResponseModel =
        noticeDataSource.modifyNotice(id, noticeRequest.asNoticeRequest()).asNoticeMessageResponseModel()

    override suspend fun deleteNotice(id: Int, noticeRequest: NoticeRequestModel): NoticeMessageResponseModel =
        noticeDataSource.deleteNotice(id, noticeRequest.asNoticeRequest()).asNoticeMessageResponseModel()
}