package com.yeoboya.data.model.response.notice

import com.yeoboya.domain.model.notice.response.NoticeMessageResponseModel

data class NoticeMessageResponse(
    val message: String
)

fun NoticeMessageResponse.asNoticeMessageResponseModel() = NoticeMessageResponseModel(
    message = message
)