package com.mert.hpapp.util

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader {
    fun loadGlideImage(imgView: ImageView, imgUrl: String) {
        Glide.with(imgView)
            .load(imgUrl)
            .circleCrop()
            .into(imgView)
    }
}