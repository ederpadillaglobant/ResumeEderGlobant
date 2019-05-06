package com.example.resumeederpadilla

import android.content.Intent
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import com.example.resumeederpadilla.ui.main.view.activity.MainActivity
import com.example.resumeederpadilla.ui.main.view.fragments.MainInfoFragment
import org.junit.Rule
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class IntentTest {

    @get:Rule
    public val myActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, false, false)

    @Before
    fun setup() {
        val intent = Intent(InstrumentationRegistry.getTargetContext(), MainActivity::class.java)
        myActivityTestRule.launchActivity(intent);
    }

    @Test
    fun checkDisplayName() {
        val fragment = MainInfoFragment()
        myActivityTestRule.activity.supportFragmentManager.beginTransaction().add(R.id.frameLayout, fragment).commit()
        //Todo Finalize test to check if
        //
        //onView(withId(R.id.textViewName)).check(matches(withText("Eder Padilla")))
    }


}