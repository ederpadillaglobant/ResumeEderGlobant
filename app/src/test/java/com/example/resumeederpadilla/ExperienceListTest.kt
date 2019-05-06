package com.example.resumeederpadilla

import androidx.annotation.NonNull
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.resumeederpadilla.model.ExperienceItem
import com.example.resumeederpadilla.model.GetResumeResponse
import com.example.resumeederpadilla.model.SkillsItem
import com.example.resumeederpadilla.ui.main.model.ResumeModel
import com.example.resumeederpadilla.ui.main.viewmodel.ResumeViewModel
import com.example.resumeederpadilla.util.ShowLog
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.Scheduler.Worker
import io.reactivex.disposables.Disposable
import io.reactivex.Scheduler
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.BeforeClass
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import org.junit.ClassRule
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ExperienceListTest {

    @Mock
    lateinit var resumeViewModel: ResumeViewModel

    @Test
    fun invalidName(){
        val mutableLiveData : MutableLiveData<Boolean>
                = mock(MutableLiveData<Boolean>()::class.java)
        mutableLiveData.value = false
        Mockito.`when`(resumeViewModel.noInternet).thenReturn(mutableLiveData)
        //Todo finish test
        resumeViewModel.getResume()
        assertEquals(false,resumeViewModel.noInternet)
    }

}