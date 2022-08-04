package com.flobiz.android.authshared.data

import com.flobiz.android.authshared.domain.SharedAuthService
import com.flobiz.android.core.domain.Result
import com.flobiz.android.core.domain.Success
import com.flobiz.android.core.domain.Token
import kotlinx.coroutines.delay
import java.util.*
import javax.inject.Inject

class SharedAuthServiceImpl @Inject constructor() : SharedAuthService {

    override suspend fun login(username: String, password: String): Result<Token> {
        delay(300)
        return Success(Token(UUID.randomUUID().toString()))
    }
}
