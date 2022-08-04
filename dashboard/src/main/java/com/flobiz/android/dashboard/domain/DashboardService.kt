package com.flobiz.android.dashboard.domain

import com.flobiz.android.core.domain.Result

interface DashboardService {

    suspend fun getDashboardData(): Result<String>
}
