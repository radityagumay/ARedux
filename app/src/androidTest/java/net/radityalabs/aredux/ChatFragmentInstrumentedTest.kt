package net.radityalabs.aredux

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import org.junit.Before
import android.support.test.espresso.intent.rule.IntentsTestRule
import net.radityalabs.aredux.ui.activity.ChatActivity
import org.junit.Rule
import org.junit.Test

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers.toPackage
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

/**
 * Created by radityagumay on 7/23/17.
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChatFragmentInstrumentedTest {

    @Rule
    var chatDetailActivityRule = IntentsTestRule<ChatActivity>(ChatActivity::class.java, true, false)

    @Before
    fun setup() {
        startActivity()
    }

    @Test
    fun is_message_view_displayed() {
        onView(withId(R.id.etMessage)).check(matches(isDisplayed()))
    }

    private fun startActivity() {
        chatDetailActivityRule.launchActivity(ChatActivity.navigateTest(chatDetailActivityRule.getActivity()))
    }
}