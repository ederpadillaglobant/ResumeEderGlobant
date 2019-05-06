package com.example.resumeederpadilla.ui.main.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.resumeederpadilla.R
import com.example.resumeederpadilla.ui.main.view.base.BaseActivity
import com.example.resumeederpadilla.ui.main.view.fragments.MainInfoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpSpaceBackgroundImage(mImgBg)
        switchToFragment(MainInfoFragment.newInstance(),MainInfoFragment.TAG,R.id.frameLayout)
    }

}
