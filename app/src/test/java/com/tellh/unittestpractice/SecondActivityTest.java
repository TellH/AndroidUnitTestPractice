package com.tellh.unittestpractice;

import android.app.AlertDialog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowAlertDialog;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by tlh on 2017/4/16 :)
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SecondActivityTest {


    private static SecondActivity activity;

    @Before
    public void initClass() {
        activity = Robolectric.buildActivity(SecondActivity.class).create().get();
    }

    @Test
    public void testDialog() {
        activity.btnDialog.performClick();
        AlertDialog dialog = ShadowAlertDialog.getLatestAlertDialog();
        assertNotNull(dialog);
        assertEquals(shadowOf(dialog).getMessage(), "Hello World!");
        assertEquals(shadowOf(dialog).getTitle(), "Test Dialog");
    }

    @Test
    public void testToast() {
        activity.btnToast.performClick();
        assertEquals(ShadowToast.getTextOfLatestToast(), "Hello World!");
    }
}