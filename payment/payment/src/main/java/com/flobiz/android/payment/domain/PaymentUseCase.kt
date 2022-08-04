package com.flobiz.android.payment.domain

import com.flobiz.android.core.domain.Analytics
import com.flobiz.android.core.domain.Result
import com.flobiz.android.core.domain.Success
import javax.inject.Inject

class PaymentUseCase @Inject constructor(
    private val paymentService: PaymentService,
    private val analytics: Analytics
) {

    suspend operator fun invoke(acNumber: String, amount: Amount): Result<Boolean> {
        val result = paymentService.pay(acNumber, amount)
        when (result) {
            is Success -> analytics.log("payment_successful")
            else -> analytics.log("payment_failed")
        }
        return result
    }
}
