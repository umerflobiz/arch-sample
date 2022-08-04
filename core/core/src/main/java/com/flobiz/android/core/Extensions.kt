package com.flobiz.android.core

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.shortSnackBar(text: CharSequence) =
    Snackbar.make(this, text, Snackbar.LENGTH_SHORT).show()
