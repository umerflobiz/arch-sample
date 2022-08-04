package com.flobiz.android.payment.domain

import java.math.BigDecimal

@JvmInline
value class Amount(
    val value: BigDecimal
) {

    fun isZero(): Boolean =
        value.toDouble() == 0.0
}
