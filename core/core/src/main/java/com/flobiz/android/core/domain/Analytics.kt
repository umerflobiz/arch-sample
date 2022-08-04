package com.flobiz.android.core.domain

interface Analytics {

    fun log(event: String)

    fun log(event: String, attributes: Map<String, String>)

    fun setUserId(userId: String)
}
