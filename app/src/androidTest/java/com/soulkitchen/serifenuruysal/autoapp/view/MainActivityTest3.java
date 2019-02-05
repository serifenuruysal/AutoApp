package com.soulkitchen.serifenuruysal.autoapp.view;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.soulkitchen.serifenuruysal.autoapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest3 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest3() {
        ViewInteraction textView = onView(
                allOf(withId(android.R.id.text1), withText("Select a Manufacturer"),
                        childAtPosition(
                                allOf(withId(R.id.my_spinner_m),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Select a Manufacturer")));

        ViewInteraction materialSpinner = onView(
                allOf(withId(R.id.my_spinner_m),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialSpinner.perform(click());

        DataInteraction textView2 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(72);
        textView2.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(android.R.id.text1), withText("Volkswagen"),
                        childAtPosition(
                                allOf(withId(R.id.my_spinner_m),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("Volkswagen")));

        ViewInteraction textView4 = onView(
                allOf(withId(android.R.id.text1), withText("Select a Main Type"),
                        childAtPosition(
                                allOf(withId(R.id.my_spinner_mt),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                1)),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("Select a Main Type")));

        ViewInteraction textView5 = onView(
                allOf(withId(android.R.id.text1), withText("Select a Main Type"),
                        childAtPosition(
                                allOf(withId(R.id.my_spinner_mt),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                1)),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("Select a Main Type")));

        ViewInteraction materialSpinner2 = onView(
                allOf(withId(R.id.my_spinner_mt),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialSpinner2.perform(click());

        DataInteraction textView6 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(43);
        textView6.perform(click());

        ViewInteraction textView7 = onView(
                allOf(withId(android.R.id.text1), withText("Select a Build Date"),
                        childAtPosition(
                                allOf(withId(R.id.my_spinner_bd),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                2)),
                                0),
                        isDisplayed()));
        textView7.check(matches(withText("Select a Build Date")));

        ViewInteraction materialSpinner3 = onView(
                allOf(withId(R.id.my_spinner_bd),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialSpinner3.perform(click());

        ViewInteraction materialSpinner4 = onView(
                allOf(withId(R.id.my_spinner_bd),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
      //  materialSpinner4.perform(click());

        DataInteraction textView8 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(13);
        textView8.perform(click());

        ViewInteraction textView9 = onView(
                allOf(withId(android.R.id.text1), withText("2013"),
                        childAtPosition(
                                allOf(withId(R.id.my_spinner_bd),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                2)),
                                0),
                        isDisplayed()));
        textView9.check(matches(withText("2013")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
