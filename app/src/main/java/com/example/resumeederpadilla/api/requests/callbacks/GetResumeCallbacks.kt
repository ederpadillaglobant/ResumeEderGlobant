package com.example.resumeederpadilla.api.requests.callbacks

import com.example.resumeederpadilla.model.GetResumeResponse

interface GetResumeCallbacks {

    interface GetExperience{

        fun successGetResume(resume : GetResumeResponse)

        fun failedGetResume(message : String)

        fun noInternetAccess()

        fun showProgress()

        fun hideProgress()
    }
}