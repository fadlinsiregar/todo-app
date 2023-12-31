package com.dicoding.todoapp.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dicoding.todoapp.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
@RunWith(AndroidJUnit4ClassRunner::class)
class TaskActivityTest {
    @Before
    fun setup() {
        ActivityScenario.launch(TaskActivity::class.java)
    }

    @Test
    fun assertAddTaskActivity() {
        onView(withId(R.id.fab))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.fab)).perform(click())
        onView(withId(R.id.add_ed_title))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.add_ed_description))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.add_tv_due_date))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.action_save))
            .check(ViewAssertions.matches(isDisplayed()))
    }
}