package com.flobiz.android.paymentshared.data.di

import com.flobiz.android.paymentshared.data.PaymentSharedServiceImpl
import com.flobiz.android.paymentshared.domain.PaymentSharedService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PaymentSharedModule {

    @Binds
    fun bindPaymentService(impl: PaymentSharedServiceImpl): PaymentSharedService
}
