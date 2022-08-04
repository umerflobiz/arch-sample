package com.flobiz.android.core.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.flobiz.android.core.domain.Storage
import com.flobiz.android.core.domain.Token
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StorageImpl @Inject constructor(
    // For simplicity, using datastore as storage.
    private val dataStore: DataStore<Preferences>
) : Storage {

    override suspend fun saveToken(token: Token) {
        dataStore.edit {
            it[PrefKeys.TOKEN] = token.value
        }
    }

    private object PrefKeys {
        val TOKEN = stringPreferencesKey("token")
    }
}
