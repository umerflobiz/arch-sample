package com.flobiz.android.authshared.domain

import com.flobiz.android.core.domain.Result
import com.flobiz.android.core.domain.Token

interface SharedAuthService {

    suspend fun login(username: String, password: String): Result<Token>
}
