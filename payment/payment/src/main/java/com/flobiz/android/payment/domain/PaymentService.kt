package com.flobiz.android.payment.domain

import com.flobiz.android.core.domain.Result

interface PaymentService {

    suspend fun pay(acNumber: String, amount: Amount): Result<Boolean>
}
