package com.mra.movies.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(message: String?) {
    context?.let { mContext ->
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
    }
}