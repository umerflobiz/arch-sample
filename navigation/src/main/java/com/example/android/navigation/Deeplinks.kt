package com.example.android.navigation

import android.net.Uri
import androidx.core.net.toUri

interface Deeplink {
    val uri: Uri
}

object Dashboard : Deeplink {
    override val uri: Uri =
        "myApp://archsample.com/dashboard".toUri()
}
