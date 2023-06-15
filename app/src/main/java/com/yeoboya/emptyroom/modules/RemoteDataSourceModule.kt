package com.yeoboya.emptyroom.modules

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
}