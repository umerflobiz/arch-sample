package com.flobiz.android.payment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flobiz.android.core.domain.AppError
import com.flobiz.android.core.domain.Error
import com.flobiz.android.core.domain.Loading
import com.flobiz.android.core.domain.Result
import com.flobiz.android.core.domain.TextResource
import com.flobiz.android.core.domain.throwableOrNull
import com.flobiz.android.partyshared.data.PartyRepository
import com.flobiz.android.partyshared.domain.Party
import com.flobiz.android.payment.R
import com.flobiz.android.payment.domain.Amount
import com.flobiz.android.payment.domain.PaymentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val repository: PartyRepository,
    private val paymentUseCase: PaymentUseCase
) : ViewModel() {

    private val _parties = MutableLiveData<Result<List<Party>>>()
    val parties: LiveData<Result<List<Party>>> = _parties

    private val _paymentResult = MutableLiveData<Result<Boolean>>()
    val paymentResult: LiveData<Result<Boolean>> = _paymentResult

    init {
        getParties()
    }

    // TODO: Better design?
    var selectedParty: Party? = null

    fun getParties() {
        viewModelScope.launch {
            _parties.value = Loading
            _parties.value = repository.getParties()
        }
    }

    fun pay(amount: String) {
        val party = selectedParty
        if (party != null) {
            val validAmount = amount.toDoubleOrNull()
            if (validAmount != null) {
                viewModelScope.launch {
                    _paymentResult.value = Loading
                    _paymentResult.value = paymentUseCase(party.id, Amount(amount.toBigDecimal()))
                }
            } else {
                _paymentResult.value = AppError(TextResource.ofId(R.string.please_enter_amount))
            }
        }
    }
}
