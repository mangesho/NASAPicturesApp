package com.example.nasapicturesapp.ui.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.nasapicturesapp.utils.LiveNetworkMonitor


abstract class BaseFragment<V : ViewModel, B : ViewDataBinding> : Fragment() {

    protected var viewBinding: B? = null
    private var isNetworkConnected : LiveNetworkMonitor? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            getLayoutId(),
            null,
            false
        ) as B
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNetworkStatus()
    }

    private fun handleNetworkStatus() {
        isNetworkConnected = LiveNetworkMonitor.getInstance(requireContext())
        isNetworkConnected?.observe(viewLifecycleOwner) {
            if (it) {
                getViewModel().isNetworkAvailable.postValue(true)
            } else {
                getViewModel().isNetworkAvailable.postValue(false)
            }
        }
    }


    abstract fun getViewModel(): BaseViewModel

    abstract fun getLayoutId(): Int

    fun openFragment(containerId: Int, fragment: Fragment){
        parentFragmentManager.beginTransaction()
            .add(containerId, fragment, fragment.javaClass.name)
            .addToBackStack(null)
            .commit()
    }

}