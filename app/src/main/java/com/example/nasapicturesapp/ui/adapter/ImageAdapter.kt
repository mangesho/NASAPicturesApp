package com.example.nasapicturesapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nasapicturesapp.R
import com.example.nasapicturesapp.databinding.ListItemBinding
import com.example.nasapicturesapp.model.ImageData

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    lateinit var binding: ListItemBinding
    var images: List<ImageData> = emptyList()
        set(value) {
            field = value

            // Notify any registered observers that the data set has changed. This will cause every
            // element in our RecyclerView to be invalidated.
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false
        )
        binding.executePendingBindings()
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(binding, images, position)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindItems(
            binding: ListItemBinding,
            images: List<ImageData>,
            position: Int
        ) {

            itemView.apply {
                binding.imageData = images[position]
            }
        }
    }
}