package com.example.nasapicturesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nasapicturesapp.R
import com.example.nasapicturesapp.databinding.DetailItemBinding
import com.example.nasapicturesapp.model.ImageData

class ImageDetailAdapter : RecyclerView.Adapter<ImageDetailViewHolder>() {

    private val MAX_LINES_COLLAPSED = 2
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
                isCollapsed = true
            }

            tvDescription.maxLines = MAX_LINES_COLLAPSED
        }

        holder.viewDataBinding.tvDescription.setOnClickListener {
            if(images[position].isCollapsed){
                (it as TextView).maxLines = Integer.MAX_VALUE
                images[position].isCollapsed = false
            }else{
                (it as TextView).maxLines = MAX_LINES_COLLAPSED
                images[position].isCollapsed = true
            }
        }
    }
}

class ImageDetailViewHolder(val viewDataBinding: DetailItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root){

    }