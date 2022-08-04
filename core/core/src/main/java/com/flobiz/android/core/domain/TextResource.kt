package com.flobiz.android.core.domain

import android.content.Context
import androidx.annotation.StringRes

sealed interface TextResource {

    companion object {
        fun ofString(
            value: String
        ): TextResource = StringResource(value)

        fun ofId(
            @StringRes value: Int,
            vararg args: CharSequence
        ): TextResource = IdTextResource(value, args)
    }
}

@JvmInline
private value class StringResource(val value: String) : TextResource

private class IdTextResource(
    @StringRes val resId: Int,
    val args: Array<out CharSequence>?
) : TextResource

fun TextResource.getString(context: Context): CharSequence =
    when (this) {
        is IdTextResource -> {
            if (args.isNullOrEmpty())
                context.getText(resId)
            else
                context.getString(resId, *args)
        }
        is StringResource -> value
    }
