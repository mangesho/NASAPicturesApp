package com.example.nasapicturesapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.nasapicturesapp.R
import com.example.nasapicturesapp.databinding.FragmentImageListBinding
import com.example.nasapicturesapp.ui.adapter.ImageAdapter
import com.example.nasapicturesapp.ui.base.BaseFragment
import com.example.nasapicturesapp.ui.viewmodel.PictureDataViewModel
import com.example.nasapicturesapp.utils.Constants
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ImageListFragment: BaseFragment<PictureDataViewModel, FragmentImageListBinding>() {

    private val pictureDataViewModel: PictureDataViewModel by viewModels()
    override fun getViewModel() = pictureDataViewModel
    override fun getLayoutId() = R.layout.fragment_image_list

    private lateinit var imageAdapter: ImageAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding?.let {
            with(it){
                viewModel = pictureDataViewModel
                lifecycleOwner = this@ImageListFragment
            }
        }

        imageAdapter = ImageAdapter()

        setObserver()
        loadUi()
        pictureDataViewModel.getImageList()
    }

    private fun setObserver() {
        pictureDataViewModel.eventNetworkAvailable.observe(viewLifecycleOwner){

        }

        pictureDataViewModel.imageDataList.observe(viewLifecycleOwner){
            imageAdapter.images = it
        }
    }

    private fun loadUi(){
        viewBinding?.recyclerView?.apply {

            val staggeredGridLayoutManager = StaggeredGridLayoutManager(Constants.SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
            layoutManager = staggeredGridLayoutManager

            adapter = imageAdapter
        }
    }


}