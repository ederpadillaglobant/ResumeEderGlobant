package com.example.resumeederpadilla.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.resumeederpadilla.R
import com.example.resumeederpadilla.ui.main.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main_info.*
import com.example.resumeederpadilla.ui.main.view.activity.MainActivity


class MainInfoFragment : BaseFragment() {
    companion object {

        val TAG = MainInfoFragment::class.java.simpleName

        fun newInstance(): MainInfoFragment {
            return MainInfoFragment()
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
            .load(R.drawable.eder)
            .apply(RequestOptions().centerCrop())
            .into(mProfileImage)
        mGithubImage.setOnClickListener {
            gitHubClickListener()
        }
        mLinkedInImage.setOnClickListener {
            linkedInClickListener()
        }
        mShowResumeContainer.setOnClickListener {
            showResumeClickListener()
        }
    }

    private fun showResumeClickListener() {
        val activity = activity as MainActivity
        activity.switchToFragment(ResumeFragment.newInstance(),ResumeFragment.TAG,R.id.frameLayout)
    }

    private fun gitHubClickListener(){
        openLink(getString(R.string.github_profile))
    }

    private fun linkedInClickListener(){
        openLink(getString(R.string.linked_in_profile))
    }

}