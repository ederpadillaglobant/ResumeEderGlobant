package com.example.resumeederpadilla.di.component

import com.example.resumeederpadilla.di.module.AdapterModule
import com.example.resumeederpadilla.ui.main.view.fragments.ResumeFragment
import dagger.Component

@Component(modules = [ AdapterModule::class])
interface AdapterComponent {

    fun inject(fragment : ResumeFragment)

}