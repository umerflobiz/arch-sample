package com.flobiz.android.partyshared.data

import com.flobiz.android.partyshared.domain.Party
import com.flobiz.android.partyshared.domain.PartyService
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PartyServiceImpl @Inject constructor() : PartyService {

    override suspend fun getAllParties(): List<Party> {
        delay(400)
        return listOf(
            Party("1", "Allie Grater", "786432187"),
            Party("2", "Audie Yose", "786432322"),
            Party("2", "Ben Dover", "7864321098"),
            Party("2", "Hugo First", "7864355622"),
            Party("2", "John Quil", "786432188"),
            Party("2", "Liz Erd", "7864325333"),
            Party("2", "Neil Down", "786430102"),
            Party("2", "Peg Legge", "786436544"),
            Party("2", "Rose Bush", "786439002"),
            Party("2", "Stan Dupp", "786432111"),
        )
    }
}
