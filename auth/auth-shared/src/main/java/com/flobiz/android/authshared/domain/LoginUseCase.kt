package com.flobiz.android.authshared.domain

import com.flobiz.android.core.domain.Analytics
import com.flobiz.android.core.domain.AppError
import com.flobiz.android.core.domain.Result
import com.flobiz.android.core.domain.Storage
import com.flobiz.android.core.domain.Success
import com.flobiz.android.core.domain.TextResource
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val service: SharedAuthService,
    private val analytics: Analytics,
    private val storage: Storage
) {
    suspend operator fun invoke(username: String, password: String): Result<Boolean> {
        return when (val result = service.login(username, password)) {
            is Success -> {
                storage.saveToken(result.value)
                analytics.setUserId(username)
                Success(true)
            }
            else -> {
                // TODO: Return appropriate error
                AppError(TextResource.ofId(android.R.string.ok))
            }
        }
    }
}
