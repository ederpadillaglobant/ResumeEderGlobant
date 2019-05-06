package com.example.resumeederpadilla.ui.main.model

import com.example.resumeederpadilla.api.requests.callbacks.GetResumeCallbacks
import com.example.resumeederpadilla.api.requests.petitions.GetResumePetitions
import com.example.resumeederpadilla.model.GetResumeResponse

class ResumeModel() {

    private var experience :  GetResumeResponse?= null
    private var error: String? = null
    private var showProgress : Boolean? = null
    private var hideProgress : Boolean? = null
    private var noInternet : Boolean? = null

    fun getExperiences(callback: (GetResumeResponse?, String?,
                                  Boolean?, Boolean?, Boolean?) -> Unit) {
        val petitions = GetResumePetitions(object : GetResumeCallbacks.GetExperience {
            override fun successGetResume(resume: GetResumeResponse) {
                experience = resume
                noInternet = false
                callback.invoke(experience,error,showProgress,hideProgress,noInternet)
            }

            override fun failedGetResume(message: String) {
                error = message
                callback.invoke(experience,error,showProgress,hideProgress,noInternet)
            }

            override fun noInternetAccess() {
                noInternet = true
                callback.invoke(experience,error,showProgress,hideProgress,noInternet)
            }

            override fun showProgress() {
                showProgress = true
                hideProgress = false
                callback.invoke(experience,error,showProgress,hideProgress,noInternet)
            }

            override fun hideProgress() {
                hideProgress = true
                showProgress = false
                callback.invoke(experience,error,showProgress,hideProgress,noInternet)
            }

        })
        petitions.getExperiences()
    }
}