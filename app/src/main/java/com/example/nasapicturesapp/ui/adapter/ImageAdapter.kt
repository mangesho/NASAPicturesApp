package com.example.nasapicturesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nasapicturesapp.R
import com.example.nasapicturesapp.databinding.ListItemBinding
import com.example.nasapicturesapp.model.ImageData

class ImageAdapter(var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ImageViewHolder>() {

    interface OnItemClickListener{
        fun onClick(position: Int, imageData: ImageData)
    }

    var images: List<ImageData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val withDataBinding: ListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false)
        return ImageViewHolder(withDataBinding)
    }

    override fun getItemCount() = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.viewDataBinding.apply {
            images[position].apply {
                imageData = this
            }

            root.setOnClickListener {
                onItemClickListener.onClick(position, images[position])
            }
        }
    }
}


class ImageViewHolder(val viewDataBinding: ListItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root)