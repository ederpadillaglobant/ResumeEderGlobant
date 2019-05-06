package com.example.resumeederpadilla.ui.main.view.base

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.resumeederpadilla.R

abstract class BaseActivity : AppCompatActivity() {

    fun setUpSpaceBackgroundImage(imageView : ImageView){
        Glide.with(this)
            .load(ContextCompat.getDrawable(this,
                R.drawable.wp))
            .apply(RequestOptions().centerCrop())
            .into(imageView)
    }

    fun switchToFragment(fragment: Fragment, tag: String, containerViewId : Int) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
            .replace(containerViewId, fragment, tag)
            .commit()
    }

}