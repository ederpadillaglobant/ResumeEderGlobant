package com.example.resumeederpadilla.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resumeederpadilla.model.ExperienceItem
import com.example.resumeederpadilla.model.GetResumeResponse
import com.example.resumeederpadilla.model.SkillsItem
import com.example.resumeederpadilla.ui.main.model.ResumeModel
import com.example.resumeederpadilla.util.ShowLog

class ResumeViewModel (private val model : ResumeModel) : ViewModel() {

    val resume = MutableLiveData<GetResumeResponse>()

    val skills = MutableLiveData<List<SkillsItem>>()

    val experiences =  MutableLiveData<List<ExperienceItem>>()

    val error = MutableLiveData<String>()

    val showProgress = MutableLiveData<Boolean>()

    val hideProgress = MutableLiveData<Boolean>()

    val noInternet = MutableLiveData<Boolean>()

    fun getResume(){
        model.getExperiences{ resume: GetResumeResponse?,
                              error: String?, showProgress : Boolean?,
                              hideProgress : Boolean?, noInternet : Boolean?->
            if (showProgress!=null){
                if (showProgress)
                this.showProgress.postValue(showProgress)
            }
            if (hideProgress!=null){
                if (hideProgress)
                this.hideProgress.postValue(hideProgress)
            }
            if (noInternet!=null){
                if (noInternet)
                this.noInternet.postValue(noInternet)
            }
            if (resume!=null){
                this.resume.postValue(resume)
                this.skills.postValue(resume.skills)
                this.experiences.postValue(resume.experience)
            }
            if (error!=null){
                this.error.postValue(error)
            }
        }
    }

}