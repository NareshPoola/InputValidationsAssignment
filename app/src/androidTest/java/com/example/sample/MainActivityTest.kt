package com.example.sample

import android.content.Context
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    private lateinit var username: String
    private lateinit var password: String
    private lateinit var decorView: View;
    private lateinit var context: Context


    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun init() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        activityRule.scenario.onActivity { decorView = it.window.decorView }
    }


    // 1) Validate error message shown to the user for username field when user taps on submit button with invalid user name
    @Test
    fun testInvalidUserName() {
        username = "testusername&&"
        password = "testPassword1"
        onView(withId(R.id.editTextTextUserName))
            .perform(typeText(username), closeSoftKeyboard())
        onView(withId(R.id.editTextTextPassword))
            .perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.submitButton)).perform(click())
        onView(withId(R.id.editTextTextUserName)).check(
            matches(
                hasErrorText(context.getString(R.string.username_error))
            )
        )
    }

    // 2) Validate error message shown to the user for password field when user taps on submit button with invalid password
    @Test
    fun testInvalidPassword() {
        username = "testusername"
        password = "testpassword1"
        onView(withId(R.id.editTextTextUserName))
            .perform(typeText(username), closeSoftKeyboard())
        onView(withId(R.id.editTextTextPassword))
            .perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.submitButton)).perform(click())
        onView(withId(R.id.editTextTextPassword)).check(
            matches(
                hasErrorText(context.getString(R.string.password_error))
            )
        )
    }

    // 3) Validate submit button is enabled only when user enters more than 8 characters for both user name and password fields
    @Test
    fun checkIfButtonIsEnabledWhenUsernameAndPasswordCreteriaNotMatched() {
        username = "testuser"
        password = "testpassw"
        onView(withId(R.id.editTextTextUserName))
            .perform(typeText(username), closeSoftKeyboard())
        onView(withId(R.id.editTextTextPassword))
            .perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.submitButton)).perform(click())
        onView(withId(R.id.submitButton)).check(ViewAssertions.matches(not(isEnabled())))
    }

    // 3) Validate submit button is enabled only when user enters more than 8 characters for both user name and password fields
    @Test
    fun checkIfButtonIsEnabledWhenUsernameAndPasswordCreteriaMatched() {
        username = "testusername"
        password = "testpassword1"
        onView(withId(R.id.editTextTextUserName))
            .perform(typeText(username), closeSoftKeyboard())
        onView(withId(R.id.editTextTextPassword))
            .perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.submitButton)).perform(click())
        onView(withId(R.id.submitButton)).check(ViewAssertions.matches(isEnabled()))
    }

    // 4) Validate success message is shown to the user if user enters correct username and password with valid chars allowed for user name
    @Test
    fun testLoginSuccess() {
        username = "testusername"
        password = "testPassword1"
        onView(withId(R.id.editTextTextUserName))
            .perform(typeText(username), closeSoftKeyboard())
        onView(withId(R.id.editTextTextPassword))
            .perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.submitButton)).perform(click())
        onView(withText(context.getString(R.string.login_success)))
            .inRoot(withDecorView(not(decorView)))
            .check(matches(isDisplayed()));
    }

    // 5) Validate error message is shown to the user if user enters invalid username and password with valid chars allowed for password
    @Test
    fun testLoginFail() {
        username = "testusername"
        password = "testPassword123"
        onView(withId(R.id.editTextTextUserName))
            .perform(typeText(username), closeSoftKeyboard())
        onView(withId(R.id.editTextTextPassword))
            .perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.submitButton)).perform(click())
        onView(withText(context.getString(R.string.login_failed)))
            .inRoot(withDecorView(not(decorView)))
            .check(matches(isDisplayed()));
    }

}