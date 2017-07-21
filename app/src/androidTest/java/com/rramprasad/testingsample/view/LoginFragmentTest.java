package com.rramprasad.testingsample.view;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.rramprasad.testingsample.R;
import com.rramprasad.testingsample.utils.SimpleIdlingResource;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;


/**
 * Created by Lakeba
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginFragmentTest {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule(MainActivity.class);
    private IdlingResource mIdlingResource;

    @Before
    public void setUp() throws Exception {
        activityTestRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Before
    public void registerIdlingResource() throws Exception{
        //mIdlingResource = activityTestRule.getActivity().getIdlingResource();
        mIdlingResource = SimpleIdlingResource.getInstance();
        Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void checkLoginButton() throws Exception{

        onView(withId(R.id.username_edit_text)).perform(typeText("abc@gmail.com"));
        onView(withId(R.id.password_edit_text)).perform(typeText("Password@123"),closeSoftKeyboard());

        onView(withId(R.id.login_button)).perform(scrollTo(),click());

        onView(withId(R.id.result_textview))
                .check(matches(withText("Login success")));
    }

    @Before
    public void unRegisterIdlingResource() throws Exception{
        if(mIdlingResource != null){
            Espresso.unregisterIdlingResources(mIdlingResource);
        }
    }
}



