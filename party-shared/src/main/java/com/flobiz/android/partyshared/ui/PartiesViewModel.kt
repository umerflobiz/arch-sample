package com.flobiz.android.partyshared.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flobiz.android.core.domain.Result
import com.flobiz.android.partyshared.data.PartyRepository
import com.flobiz.android.partyshared.domain.Party
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PartiesViewModel @Inject constructor(
    private val repository: PartyRepository
) : ViewModel() {

    private val _parties = MutableLiveData<Result<List<Party>>>()
    val parties: LiveData<Result<List<Party>>> = _parties

    init {
        getParties()
    }

    fun getParties() {
        viewModelScope.launch {
            _parties.value = repository.getParties()
        }
    }
}
