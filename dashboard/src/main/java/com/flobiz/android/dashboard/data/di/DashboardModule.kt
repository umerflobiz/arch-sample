package com.flobiz.android.dashboard.data.di

import com.flobiz.android.dashboard.data.DashboardServiceImpl
import com.flobiz.android.dashboard.domain.DashboardService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DashboardModule {

    @Binds
    fun bindDashboardService(impl: DashboardServiceImpl): DashboardService
}
