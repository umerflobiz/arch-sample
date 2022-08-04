package com.flobiz.android.paymentshared.domain

import com.flobiz.android.core.domain.Result

interface PaymentSharedService {

    suspend fun getRecentTransactions(): Result<List<Transaction>>
}
