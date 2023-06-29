package com.yeoboya.data.model.request.notice

import com.yeoboya.domain.model.notice.request.NoticeRequestModel

data class NoticeRequest(
    val title: String,
    val content: String
)

fun NoticeRequestModel.asNoticeRequest() = NoticeRequest(
    title = title,
    content = content
)