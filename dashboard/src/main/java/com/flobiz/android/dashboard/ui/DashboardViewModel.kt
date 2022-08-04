package com.flobiz.android.dashboard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flobiz.android.core.domain.Loading
import com.flobiz.android.core.domain.Result
import com.flobiz.android.dashboard.data.DashboardRepository
import com.flobiz.android.paymentshared.data.PaymentSharedRepository
import com.flobiz.android.paymentshared.domain.Transaction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: DashboardRepository,
    private val paymentRepository: PaymentSharedRepository
) : ViewModel() {

    private val _dashboardData = MutableLiveData<Result<String>>()
    val dashboardData: LiveData<Result<String>> = _dashboardData

    private val _recentTransactions = MutableLiveData<Result<List<Transaction>>>()
    val recentTransactions: LiveData<Result<List<Transaction>>> = _recentTransactions

    init {
        getDashboardData()
        getRecentTransactions()
    }

    fun getDashboardData() {
        viewModelScope.launch {
            _dashboardData.value = Loading
            _dashboardData.value = repository.getDashboardData()
        }
    }

    fun getRecentTransactions() {
        viewModelScope.launch {
            _recentTransactions.value = Loading
            _recentTransactions.value = paymentRepository.getRecentTransactions()
        }
    }
}
