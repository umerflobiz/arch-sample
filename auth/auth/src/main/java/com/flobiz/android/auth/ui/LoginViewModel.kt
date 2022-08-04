package com.flobiz.android.auth.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flobiz.android.authshared.AuthManager
import com.flobiz.android.core.domain.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authManager: AuthManager
) : ViewModel() {

    private val _loginResult: MutableLiveData<Result<Boolean>> = MutableLiveData()
    val loginResult: LiveData<Result<Boolean>> = _loginResult

    fun login(phoneNumber: String, password: String) {
        // TODO: validate
        viewModelScope.launch {

            _loginResult.value = authManager.login(phoneNumber, password)
            delay(2000)
//            _loginResult.value = AppError(TextResource.ofString("Invalid Creds"))
        }
    }
}
