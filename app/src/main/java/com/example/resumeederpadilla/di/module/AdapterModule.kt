package com.example.resumeederpadilla.di.module

import com.example.resumeederpadilla.ui.main.view.adapter.ResumeAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun providesResumeAdapter() : ResumeAdapter {
        return ResumeAdapter()
    }
}