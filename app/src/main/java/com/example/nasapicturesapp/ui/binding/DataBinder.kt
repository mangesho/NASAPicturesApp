package com.example.nasapicturesapp.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.nasapicturesapp.R

object DataBinder {

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(view: ImageView, avatarImage: String) {
        Glide.with(view.context)
            .load(avatarImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(view)
    }
}