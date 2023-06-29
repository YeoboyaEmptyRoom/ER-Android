package com.yeoboya.data.model.response.notice

import com.yeoboya.domain.model.notice.response.NoticeResponseModel

data class NoticeResponse(
    val title: String,
    val content: String,
    val created_at: String
)

fun NoticeResponse.asNoticeResponseModel() = NoticeResponseModel(
    title = title,
    content = content,
    created_at = created_at
)