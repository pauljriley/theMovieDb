package uk.me.paulriley.themoviedb.views.nowplaying;

import android.content.Intent;
import android.support.annotation.UiThread;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import uk.me.paulriley.themoviedb.R;
import uk.me.paulriley.themoviedb.views.nowplaying.NowPlayingActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class NowPlayingActivityTest {
    @Rule
    public ActivityTestRule<NowPlayingActivity> mActivityRule =
            new ActivityTestRule<>(NowPlayingActivity.class, false, false);

    @Before
    public void setupBeforeClass() {

    }

    @After
    public void setupAfterClass() {

    }

    @UiThread
    @Test
    public void whenTheActivityIsLoaded_thenAllUICompounentsAreDisplayed() {
        mActivityRule.launchActivity(new Intent());

        onView(ViewMatchers.withId(R.id.now_playing_list)).check(matches(isDisplayed()));
    }

}
