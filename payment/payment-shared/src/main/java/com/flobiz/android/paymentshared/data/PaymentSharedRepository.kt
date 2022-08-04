package com.flobiz.android.paymentshared.data

import com.flobiz.android.core.domain.Result
import com.flobiz.android.paymentshared.domain.PaymentSharedService
import com.flobiz.android.paymentshared.domain.Transaction
import javax.inject.Inject

class PaymentSharedRepository @Inject constructor(
    private val service: PaymentSharedService
) {

    suspend fun getRecentTransactions(): Result<List<Transaction>> {
        return service.getRecentTransactions()
    }
}
