package com.example.resumeederpadilla.api.client

import com.example.resumeederpadilla.api.client.Endpoints.GET_RESUME
import com.example.resumeederpadilla.model.GetResumeResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ExperienceClient {

    @GET(GET_RESUME)
    fun getExperience(): Observable<Response<GetResumeResponse>>

}