package com.example.resumeederpadilla

import android.app.Application
import com.example.resumeederpadilla.di.component.AdapterComponent
import com.example.resumeederpadilla.di.component.DaggerAdapterComponent

class ResumeApp  : Application()  {

    lateinit var adapterComponent : AdapterComponent

    override fun onCreate() {
        super.onCreate()
        adapterComponent = DaggerAdapterComponent
            .builder()
            .build()
    }
}