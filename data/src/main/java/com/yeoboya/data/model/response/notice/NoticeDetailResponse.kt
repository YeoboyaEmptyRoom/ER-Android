package com.yeoboya.data.model.response.notice

import com.yeoboya.domain.model.notice.response.NoticeDetailResponseModel

data class NoticeDetailResponse(
    val title: String,
    val content: String
)

fun NoticeDetailResponse.asNoticeDetailResponseModel() = NoticeDetailResponseModel(
    title = title,
    content = content
)
