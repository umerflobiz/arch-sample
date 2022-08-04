package com.flobiz.android.dashboard.data

import com.flobiz.android.core.domain.Result
import com.flobiz.android.core.domain.Success
import com.flobiz.android.dashboard.domain.DashboardService
import kotlinx.coroutines.delay
import javax.inject.Inject

class DashboardServiceImpl @Inject constructor() : DashboardService {

    override suspend fun getDashboardData(): Result<String> {
        delay(300)
        return Success("2000")
    }
}
