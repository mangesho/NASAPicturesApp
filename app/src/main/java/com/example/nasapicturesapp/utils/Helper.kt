package com.example.nasapicturesapp.utils

import android.content.Context
import android.widget.Toast

object Helper {

    fun showShortMessage(context: Context, strRes: Int){
        Toast.makeText(context, strRes, Toast.LENGTH_SHORT).show()
    }

    fun showShortMessage(context: Context, strRes: String){
        Toast.makeText(context, strRes, Toast.LENGTH_SHORT).show()
    }

    fun showLongMessage(context: Context, strRes: Int){
        Toast.makeText(context, strRes, Toast.LENGTH_LONG).show()
    }
}
