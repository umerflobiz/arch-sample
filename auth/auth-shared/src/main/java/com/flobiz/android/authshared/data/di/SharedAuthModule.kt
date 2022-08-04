package com.flobiz.android.authshared.data.di

import com.flobiz.android.authshared.data.SharedAuthServiceImpl
import com.flobiz.android.authshared.domain.SharedAuthService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SharedAuthModule {

    @Binds
    fun bindSharedAuthService(impl: SharedAuthServiceImpl): SharedAuthService
}
