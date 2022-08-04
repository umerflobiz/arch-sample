package com.flobiz.android.partyshared.data

import com.flobiz.android.core.domain.Result
import com.flobiz.android.core.domain.Storage
import com.flobiz.android.core.domain.Success
import com.flobiz.android.core.domain.ThrowableError
import com.flobiz.android.partyshared.domain.Party
import com.flobiz.android.partyshared.domain.PartyService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PartyRepository @Inject constructor(
    private val partyService: PartyService,
    private val storage: Storage
) {

    suspend fun getParties(): Result<List<Party>> {
        return try {
            Success(partyService.getAllParties())
        } catch (e: Exception) {
            ThrowableError(e)
        }
    }
}
