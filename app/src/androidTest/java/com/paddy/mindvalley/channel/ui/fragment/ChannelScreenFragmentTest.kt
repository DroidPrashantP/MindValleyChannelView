package com.paddy.mindvalley.channel.ui.fragment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.paddy.mindvalley.channel.R
import com.paddy.mindvalley.channel.ui.activity.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChannelScreenFragmentTest {

    @get : Rule
    val activityRule =  ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){


    }

    @Test
    fun testRecycleView(){
        onView(withId(R.id.rv_channelScreen_mainList)).check(matches(isDisplayed()))
//        onView((withId(R.id.rv_channelScreen_mainList))).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
    }
}