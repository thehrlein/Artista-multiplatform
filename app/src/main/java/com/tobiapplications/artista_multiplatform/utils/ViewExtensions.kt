package com.tobiapplications.artista_multiplatform.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Created by tobias.hehrlein on 2019-07-23.
 */

fun View.closeKeyboard() {
    post {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }
}

fun View?.setVisible(visible: Boolean) {
    if (this != null) {
        visibility = if (visible) View.VISIBLE else View.GONE
    }
}