package com.flobiz.android.payment.data.di

import com.flobiz.android.payment.data.PaymentServiceImpl
import com.flobiz.android.payment.domain.PaymentService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PaymentModule {

    @Binds
    fun bindPaymentService(impl: PaymentServiceImpl): PaymentService
}
