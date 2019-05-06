package com.example.resumeederpadilla.api.requests.petitions

import android.annotation.SuppressLint
import com.example.resumeederpadilla.api.client.ServiceGenerator
import com.example.resumeederpadilla.api.requests.callbacks.GetResumeCallbacks
import com.example.resumeederpadilla.model.GetResumeResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import java.io.IOException

class GetResumePetitions
    (private val mGetResume: GetResumeCallbacks.GetExperience) {

    @SuppressLint("CheckResult")
    fun getExperiences(){
        mGetResume.showProgress()
        ServiceGenerator.getService().getExperience()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response -> successGetExperiences(response) },
                {error -> onErrorGetExperiences(error)})
    }

    private fun successGetExperiences(response: Response<GetResumeResponse>) {
        if (response.code() == 200){
            if (response.body()!=null){
                response.body().apply {
                    this?.let { mGetResume.successGetResume(it) }
                }
            }
        }else{
            mGetResume.failedGetResume(response.message())
        }
        mGetResume.hideProgress()
    }

    private fun onErrorGetExperiences(error: Throwable) {
        error.printStackTrace()
        if (error is IOException) {
            mGetResume.noInternetAccess()
        } else {
            error.message?.let { mGetResume.failedGetResume(it) }
        }
        mGetResume.hideProgress()
    }

}