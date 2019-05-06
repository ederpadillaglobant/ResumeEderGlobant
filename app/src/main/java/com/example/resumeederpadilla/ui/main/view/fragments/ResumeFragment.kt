package com.example.resumeederpadilla.ui.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumeederpadilla.R
import com.example.resumeederpadilla.ResumeApp
import com.example.resumeederpadilla.model.GetResumeResponse
import com.example.resumeederpadilla.model.SkillsItem
import com.example.resumeederpadilla.ui.main.model.ResumeModel
import com.example.resumeederpadilla.ui.main.view.adapter.ResumeAdapter
import com.example.resumeederpadilla.ui.main.view.base.BaseFragment
import com.example.resumeederpadilla.ui.main.viewmodel.ResumeViewModel
import com.example.resumeederpadilla.util.UIUtils
import kotlinx.android.synthetic.main.fragment_resume.*
import javax.inject.Inject

class ResumeFragment  : BaseFragment() {

    private lateinit var resumeViewModel : ResumeViewModel
    @Inject
    lateinit var mExperiencesAdapter : ResumeAdapter

    private val resumeViewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ResumeViewModel(ResumeModel()) as T
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as ResumeApp).adapterComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_resume, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpRecycler(mExperienceRecycler)
        let {  }
        resumeViewModel = ViewModelProviders.of(this, resumeViewModelFactory)
            .get(ResumeViewModel::class.java)
        resumeViewModel.error.observe(this, Observer {
            activity?.let { it1 ->
                UIUtils.showErrorSnackBar(it1,resumeContainer,it)
            }
        })
        resumeViewModel.noInternet.observe(this, Observer {
            activity?.let { it1 ->
                UIUtils.showErrorSnackBar(it1, resumeContainer,getString(R.string.no_internet))
            }
        })
        resumeViewModel.showProgress.observe(this, Observer {
                progressBar.visibility = View.VISIBLE
        })
        resumeViewModel.hideProgress.observe(this, Observer {
                progressBar.visibility = View.GONE
        })
        resumeViewModel.experiences.observe(this, Observer {
            mExperiencesAdapter.submitList(it)
        })
        resumeViewModel.skills.observe(this, Observer {
            setUpSkills(it)
        })
        resumeViewModel.resume.observe(this, Observer {
            setUpData(it)
        })
        resumeViewModel.getResume()
    }

    private fun setUpSkills(skills: List<SkillsItem>) {
        for (skill in skills){
            mTvSkillsContainer.append("* ${skill.name} \n")
        }
    }

    private fun setUpData(it: GetResumeResponse?) {
        mTvName.text = it?.name
        mTvPos.text = it?.position
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpRecycler(recyclerView : RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = mExperiencesAdapter
    }

    companion object {

        val TAG = ResumeFragment::class.java.simpleName

        fun newInstance(): ResumeFragment {
            return ResumeFragment()
        }
    }

}