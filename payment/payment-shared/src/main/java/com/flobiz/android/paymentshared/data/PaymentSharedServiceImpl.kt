package com.flobiz.android.paymentshared.data

import com.flobiz.android.core.domain.Result
import com.flobiz.android.core.domain.Success
import com.flobiz.android.paymentshared.domain.PaymentSharedService
import com.flobiz.android.paymentshared.domain.Transaction
import kotlinx.coroutines.delay
import javax.inject.Inject

class PaymentSharedServiceImpl @Inject constructor() : PaymentSharedService {

    override suspend fun getRecentTransactions(): Result<List<Transaction>> {
        delay(300)
        return Success(
            listOf(
                Transaction("1", "2000", "John", "12 March"),
                Transaction("2", "600", "Ben", "1 April"),
                Transaction("3", "8500", "Peg", "22 June"),
                Transaction("4", "1000", "John", "12 Dec"),
                Transaction("5", "1000", "Rose", "8 Jan"),
            )
        )
    }
}
