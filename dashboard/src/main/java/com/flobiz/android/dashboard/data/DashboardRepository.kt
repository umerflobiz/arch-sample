package com.flobiz.android.dashboard.data

import com.flobiz.android.core.domain.Result
import com.flobiz.android.dashboard.domain.DashboardService
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    private val service: DashboardService
) {

    suspend fun getDashboardData(): Result<String> {
        return service.getDashboardData()
    }
}
