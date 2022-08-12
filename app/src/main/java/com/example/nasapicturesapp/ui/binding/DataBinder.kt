package com.example.nasapicturesapp.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.nasapicturesapp.R

object DataBinder {

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(view: ImageView, image: String) {
        Glide.with(view.context)
            .load(image)
            .centerCrop()
            .placeholder(R.drawable.image_background)
            .into(view)
    }
}