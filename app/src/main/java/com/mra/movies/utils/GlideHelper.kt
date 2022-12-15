package com.mra.movies.view

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mra.movies.R

fun ImageView.loadImage(url: String?, placeHolder: Int = R.drawable.ic_baseline_local_movies_24) {
    Glide.with(this.context).load(url)
        .placeholder(placeHolder)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}