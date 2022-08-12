package com.example.nasapicturesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nasapicturesapp.R
import com.example.nasapicturesapp.databinding.DetailItemBinding
import com.example.nasapicturesapp.model.ImageData

class ImageDetailAdapter : RecyclerView.Adapter<ImageDetailViewHolder>() {

    var images: List<ImageData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageDetailViewHolder {
        val withDataBinding: DetailItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.detail_item,
            parent,
            false)
        return ImageDetailViewHolder(withDataBinding)
    }

    override fun getItemCount() = images.size

    override fun onBindViewHolder(holder: ImageDetailViewHolder, position: Int) {
        holder.viewDataBinding.apply {
            images[position].apply {
                imageData = this
            }
        }
    }
}

class ImageDetailViewHolder(val viewDataBinding: DetailItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root)