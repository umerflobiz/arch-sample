package com.flobiz.android.paymentshared.domain

data class Transaction(
    val id: String,
    val amount: String,
    val partyName: String,
    val date: String
)
