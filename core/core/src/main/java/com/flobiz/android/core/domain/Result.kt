package com.flobiz.android.core.domain

import android.content.Context
import com.flobiz.android.core.R

sealed interface Result<out R>

class Success<out R>(val value: R) : Result<R>

interface Error : Result<Nothing>

object Loading : Result<Nothing>


// Error Implementations

@JvmInline
value class ThrowableError(val throwable: Throwable) : Error

@JvmInline
value class AppError(val message: TextResource) : Error


// Result Utils

inline fun <T> Result<T>.handle(
    onLoading: (Boolean) -> Unit = {},
    onError: ((Error) -> Unit) = {},
    onSuccess: ((T) -> Unit) = {}
) {
    when (this) {
        is Loading -> onLoading.invoke(true)
        is Success -> {
            onLoading.invoke(false)
            onSuccess.invoke(this.value)
        }
        is Error -> {
            onLoading.invoke(false)
            onError.invoke(this)
        }
    }
}

fun <T> Result<T>.getOrNull(): T? =
    when (this) {
        is Success -> value
        else -> null
    }

inline fun <T, R> Result<T>.ifSuccess(block: (value: T) -> R): R? =
    when (this) {
        is Success -> block.invoke(value)
        else -> null
    }

fun Error.throwableOrNull(): Throwable? =
    when (this) {
        is ThrowableError -> throwable
        else -> null
    }

fun Error.getAppMessage(context: Context) =
    when (this) {
        is AppError -> message.getString(context)
        else -> context.getString(R.string.something_went_wrong)
    }
