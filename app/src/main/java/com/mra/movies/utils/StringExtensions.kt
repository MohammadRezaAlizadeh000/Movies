package com.mra.movies.view

import android.widget.TextView

fun TextView.createRateString(rate: String?, rateCount: String?) {
    this.text = "($rateCount) $rate"
}

