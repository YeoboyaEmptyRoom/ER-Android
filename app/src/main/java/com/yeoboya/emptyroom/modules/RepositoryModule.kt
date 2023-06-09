package com.yeoboya.emptyroom.modules

import com.yeoboya.data.repository.MainRepositoryImpl
import com.yeoboya.data.repository.NoticeRepositoryImpl
import com.yeoboya.data.repository.UserRepositoryImpl
import com.yeoboya.domain.repository.MainRepository
import com.yeoboya.domain.repository.NoticeRepository
import com.yeoboya.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    fun bindsMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository

    @Binds
    fun bindsNoticeRepository(noticeRepositoryImpl: NoticeRepositoryImpl): NoticeRepository
}