package com.yeoboya.data.network

import com.yeoboya.data.model.request.notice.NoticeRequest
import com.yeoboya.data.model.response.notice.NoticeDetailResponse
import com.yeoboya.data.model.response.notice.NoticeMessageResponse
import com.yeoboya.data.model.response.notice.NoticeResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface NoticeApi {
    @POST("notice/create/")
    suspend fun noticeCreate(
        @Body noticeRequest: NoticeRequest
    ): NoticeMessageResponse

    @GET("notice/list/")
    suspend fun getNoticeList(): List<NoticeResponse>

    @GET("notice/list/{pk}/")
    suspend fun getDetailNotice(
        @Path("pk") id: Int
    ): NoticeDetailResponse

    @PATCH("notice/list/{pk}/")
    suspend fun modifyNotice(
        @Path("pk") id: Int,
        @Body noticeRequest: NoticeRequest
    ): NoticeMessageResponse

    @DELETE("notice/list/{id}/")
    suspend fun deleteNotice(
        @Path("pk") id: Int,
        @Body noticeRequest: NoticeRequest
    ): NoticeMessageResponse
}