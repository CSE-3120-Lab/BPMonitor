package com.example.bpmonitor;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.AllOf.allOf;

import androidx.annotation.UiThread;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * class for intent testing of the application
 * tests add, update and delete functionality
 */
@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest


public class IntentTest {
    private IntentTest intentTest;
    @Rule
    public ActivityTestRule<MainActivity> activityRule=
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAll()
    {
        onView(withId(R.id.main)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonCreate)).perform(click());
        onView(withId(R.id.inputActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.systolicInput)).perform(ViewActions.typeText("81"));
        onView(withId(R.id.diastolicInput)).perform(ViewActions.typeText("71"));
        onView(withId(R.id.bpmInput)).perform(ViewActions.typeText("91"));
        onView(withId(R.id.dateInput)).perform(ViewActions.typeText("02-02-2019"));
        onView(withId(R.id.timeInput)).perform(ViewActions.typeText("5:40"));
        onView(withId(R.id.notesInput)).perform(ViewActions.typeText(""));
        Espresso.pressBack();
        onView(withId(R.id.buttonAdd)).perform(click());
        Espresso.pressBack();
        onView(withId(R.id.main)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerview)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.detailsShow)).check(matches(isDisplayed()));
        onView(withId(R.id.spShow2)).check(matches(withText("81")));
        onView(withId(R.id.dpShow2)).check(matches(withText("71")));
        onView(withId(R.id.bpmShow2)).check(matches(withText("91")));
        onView(withId(R.id.dateShow2)).check(matches(withText("02-02-2019")));
        onView(withId(R.id.timeShow2)).check(matches(withText("5:40")));
        onView(withId(R.id.notesShow2)).check(matches(withText("")));
        onView(withId(R.id.buttonEdit)).perform(click());
        onView(withId(R.id.notesUpdate)).perform(ViewActions.typeText("resting"));
        Espresso.pressBack();
        onView(withId(R.id.buttonUpdate)).perform(click());
        onView(withId(R.id.main)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerview)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.detailsShow)).check(matches(isDisplayed()));
        onView(withId(R.id.spShow2)).check(matches(withText("81")));
        onView(withId(R.id.dpShow2)).check(matches(withText("71")));
        onView(withId(R.id.bpmShow2)).check(matches(withText("91")));
        onView(withId(R.id.dateShow2)).check(matches(withText("02-02-2019")));
        onView(withId(R.id.timeShow2)).check(matches(withText("5:40")));
        onView(withId(R.id.notesShow2)).check(matches(withText("resting")));
        onView(withId(R.id.buttonDelete)).perform(click());
        onView(withId(R.id.main)).check(matches(isDisplayed()));
        
    }
}
