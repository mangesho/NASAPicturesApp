package com.example.nasapicturesapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.nasapicturesapp.R
import com.example.nasapicturesapp.databinding.FragmentDetailsBinding
import com.example.nasapicturesapp.model.ImageData
import com.example.nasapicturesapp.ui.adapter.ImageDetailAdapter
import com.example.nasapicturesapp.ui.base.BaseFragment
import com.example.nasapicturesapp.ui.viewmodel.PictureDataViewModel
import com.example.nasapicturesapp.utils.Helper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<PictureDataViewModel, FragmentDetailsBinding>() {

    private val pictureDataViewModel: PictureDataViewModel by viewModels()
    override fun getViewModel() = pictureDataViewModel
    override fun getLayoutId() = R.layout.fragment_details

    var imageData: ImageData? = null
    var position: Int = 0

    lateinit var imageDetailAdapter: ImageDetailAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding?.let {
            with(it){
                viewModel = pictureDataViewModel
                lifecycleOwner = this@DetailsFragment
            }
        }

        val safeArgs: DetailsFragmentArgs by navArgs()
        imageData = safeArgs.imageData
        position = safeArgs.position

        setObserver()
        loadUi()
    }

    private fun setObserver() {
        pictureDataViewModel.eventNetworkAvailable.observe(viewLifecycleOwner){ isAvailable ->
            if(!isAvailable){
                Helper.showShortMessage(requireContext(), R.string.no_internet_available)
            }
        }

        pictureDataViewModel.imageDataList.observe(viewLifecycleOwner){
            imageDetailAdapter.images = it

            viewBinding?.vpImageDetail?.post {
                viewBinding?.vpImageDetail?.currentItem = position
            }
        }
    }

    private fun loadUi(){
        imageDetailAdapter = ImageDetailAdapter()
        pictureDataViewModel.getImageList()

        viewBinding?.vpImageDetail?.apply {
            adapter = imageDetailAdapter
        }
    }

}