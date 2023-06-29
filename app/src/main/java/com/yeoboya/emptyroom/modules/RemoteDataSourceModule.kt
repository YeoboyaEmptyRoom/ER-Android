package com.yeoboya.emptyroom.modules

import com.yeoboya.data.datasource.main.MainDataSource
import com.yeoboya.data.datasource.main.MainDataSourceImpl
import com.yeoboya.data.datasource.notice.NoticeDataSource
import com.yeoboya.data.datasource.notice.NoticeDataSourceImpl
import com.yeoboya.data.datasource.user.UserDataSource
import com.yeoboya.data.datasource.user.UserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDataSourceModule {
    @Binds
    fun bindsUserDataSource(userDataSourceImpl: UserDataSourceImpl): UserDataSource
    @Binds
    fun bindsMainDataSource(mainDataSourceImpl: MainDataSourceImpl): MainDataSource
    @Binds
    fun bindsNoticeDataSource(noticeDataSourceImpl: NoticeDataSourceImpl): NoticeDataSource
}