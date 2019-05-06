package com.example.resumeederpadilla.ui.main.view.base

import androidx.fragment.app.Fragment
import android.content.Intent
import android.net.Uri


abstract class BaseFragment : Fragment() {


    fun openLink(url : String){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        activity?.startActivity(intent)
    }

}