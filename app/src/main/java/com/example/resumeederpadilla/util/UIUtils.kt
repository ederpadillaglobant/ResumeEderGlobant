package com.example.resumeederpadilla.util

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

object UIUtils {
    fun showErrorSnackBar(mContext : Context, view : View, errorMessage : String){
        ShowLog.errorLog("UIUtils","error $errorMessage")
        val snackBar = Snackbar.make(view, errorMessage, Snackbar.LENGTH_SHORT)
        val sbView = snackBar.view
        sbView.setBackgroundColor(ContextCompat.getColor(mContext, android.R.color.holo_red_light))
        snackBar.show()
    }
}