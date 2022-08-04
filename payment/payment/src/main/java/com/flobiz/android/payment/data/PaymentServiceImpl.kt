package com.flobiz.android.payment.data

import com.flobiz.android.core.domain.Result
import com.flobiz.android.core.domain.Success
import com.flobiz.android.payment.domain.Amount
import com.flobiz.android.payment.domain.PaymentService
import kotlinx.coroutines.delay
import javax.inject.Inject

class PaymentServiceImpl @Inject constructor() : PaymentService {

    override suspend fun pay(acNumber: String, amount: Amount): Result<Boolean> {
        delay(1500)
        return Success(true)
    }
}
