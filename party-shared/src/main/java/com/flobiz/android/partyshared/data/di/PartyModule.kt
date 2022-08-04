package com.flobiz.android.partyshared.data.di

import com.flobiz.android.partyshared.data.PartyServiceImpl
import com.flobiz.android.partyshared.domain.PartyService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PartyModule {

    @Binds
    fun bindPartyService(impl: PartyServiceImpl): PartyService
}
