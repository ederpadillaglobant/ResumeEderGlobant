package com.example.resumeederpadilla.api.client

import com.example.resumeederpadilla.api.client.Endpoints.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceGenerator {
    private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)

    private val gson = GsonBuilder().create()


    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))


    fun <S> createService(serviceClass: Class<S>): S {
        return createService(serviceClass, null)
    }


    fun <S> createService(serviceClass: Class<S>, token: String?): S {
        if (token != null) {

        }
        httpClient.connectTimeout(20, TimeUnit.SECONDS)
        httpClient.readTimeout(20, TimeUnit.SECONDS)
        httpClient.writeTimeout(20, TimeUnit.SECONDS)
        val client = httpClient.build()
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }

    fun getService(): ExperienceClient {
        return createService(ExperienceClient::class.java)
    }

}