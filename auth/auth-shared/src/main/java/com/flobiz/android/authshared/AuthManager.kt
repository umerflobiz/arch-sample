package com.flobiz.android.authshared

import com.flobiz.android.authshared.domain.LoginUseCase
import com.flobiz.android.core.domain.Result
import com.flobiz.android.core.domain.ifSuccess
import javax.inject.Inject
import javax.inject.Singleton

// TODO: Move to right package.
@Singleton
class AuthManager @Inject constructor(
    private val loginUseCase: LoginUseCase
) {

    suspend fun login(username: String, password: String): Result<Boolean> {
        return loginUseCase(username, password).also {
            it.ifSuccess { loggedIn ->
                isLoggedIn = loggedIn
            }
        }
    }

    // TODO: Important

    fun logout() {
        isLoggedIn = false
    }

    var isLoggedIn: Boolean = false
        private set
}
