package com.flobiz.android.partyshared.domain

interface PartyService {

    suspend fun getAllParties(): List<Party>
}
