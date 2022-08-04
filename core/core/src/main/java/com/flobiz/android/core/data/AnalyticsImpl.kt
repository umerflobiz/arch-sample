package com.flobiz.android.core.data

import android.util.Log
import com.flobiz.android.core.domain.Analytics
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnalyticsImpl @Inject constructor() : Analytics {

    override fun log(event: String) {
        Log.d(TAG, event)
    }

    override fun log(event: String, attributes: Map<String, String>) {
        Log.d(TAG, "$event\targs=$attributes")
    }

    override fun setUserId(userId: String) {
    }

    companion object {
        private const val TAG = "AppAnalytics"
    }
}
