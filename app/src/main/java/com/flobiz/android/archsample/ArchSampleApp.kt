package com.flobiz.android.archsample

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ArchSampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        
        Log.d("TESTING", "Application onCreate");
    }
}
