package com.omelchenkoaleks.rememberenglishwords.utils

import android.widget.Toast
import com.omelchenkoaleks.rememberenglishwords.APP_ACTIVITY

fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
}