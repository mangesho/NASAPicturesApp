package com.example.nasapicturesapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.MutableLiveData
import java.lang.ref.WeakReference

/**
 * LiveNetworkMonitor class handles network connection state and emits the livedata
 */
class LiveNetworkMonitor(context: Context?) : MutableLiveData<Boolean>() {

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            val networkCapability = connectivityManager?.getNetworkCapabilities(network)
            val hasNetworkConnection =
                networkCapability?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    ?: false
            if (hasNetworkConnection) {
                postValue(true)
            }
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            postValue(false)
        }
    }

    val connectivityManager =
        context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?


    //If network is available , register network callback
    override fun onActive() {
        super.onActive()
        val activeNetwork = connectivityManager!!.activeNetworkInfo
        postValue(activeNetwork != null && activeNetwork.isConnected)
        val networkRequest = NetworkRequest
            .Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }


    //Un-register network callback if network is not available
    override fun onInactive() {
        super.onInactive()
        connectivityManager?.unregisterNetworkCallback(networkCallback)
    }

    companion object {
        private var instance: WeakReference<LiveNetworkMonitor?>? = null
        fun getInstance(context: Context?): LiveNetworkMonitor {
            return instance?.get() ?: LiveNetworkMonitor(context)
        }
    }
}
