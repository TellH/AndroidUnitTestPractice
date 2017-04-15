package com.tellh.unittestpractice;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.robolectric.Shadows.shadowOf;

/**
 * Created by tlh on 2017/4/15 :)
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {
    @Test
    public void testStartActivityByIntent() {
        // 当Robolectric.setupActivity返回的时候，
        // 这个Activity已经完成了onCreate、onStart、onResume这几个生命周期的回调了。
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        mainActivity.findViewById(R.id.tv).performClick();

        Intent expectedIntent = new Intent(mainActivity, SecondActivity.class);
        ShadowActivity shadowActivity = shadowOf(mainActivity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        actualIntent.filterEquals(expectedIntent);
    }
    
}
