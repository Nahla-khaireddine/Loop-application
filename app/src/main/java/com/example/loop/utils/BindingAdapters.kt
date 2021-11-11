package com.example.loop

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("getImage")
fun ImageView.getImageWithGlide(imageUrl: String?) {
    imageUrl?.let {
        Glide.with(context)
            .load(it)
            .dontAnimate()
            .into(this)
    }
}