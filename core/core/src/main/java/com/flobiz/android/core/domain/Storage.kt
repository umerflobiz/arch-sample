package com.flobiz.android.core.domain

interface Storage {

    suspend fun saveToken(token: Token)
}
