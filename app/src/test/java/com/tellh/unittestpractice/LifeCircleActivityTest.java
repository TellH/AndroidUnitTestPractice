package com.tellh.unittestpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tlh on 2017/4/15 :)
 * http://robolectric.org/javadoc/latest/org/robolectric/util/ActivityController.html
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LifeCircleActivityTest {
    @Test
    public void testLifeCircle() {
        ActivityController<LifeCircleActivity> acLcController = Robolectric.buildActivity(LifeCircleActivity.class);
        LifeCircleActivity activity = acLcController.get();
        assertTrue(!activity.isCreated);
        acLcController.create();
        assertTrue(activity.isCreated);
        acLcController.start();
        assertTrue(activity.isStarted);
        acLcController.resume();
        assertTrue(activity.isResumed);

        acLcController.visible(); // 在模拟View的点击事件等交互前必须让Activity处于可见状态

        acLcController.pause();
        assertTrue(activity.isPaused);
        acLcController.stop();
        assertTrue(activity.isStopped);
        acLcController.destroy();
        assertTrue(activity.isDestroyed);
    }

    @Test
    public void simulateStartActivityWithIntent() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Activity activity = Robolectric.buildActivity(LifeCircleActivity.class, intent).create().get();
        assertEquals(activity.getIntent().getAction(), Intent.ACTION_VIEW);
    }

    @Test
    public void saveRestoreInstanceState() {
        Bundle b = new Bundle();
        ActivityController<LifeCircleActivity> ctl = Robolectric.buildActivity(LifeCircleActivity.class);
        LifeCircleActivity activity = ctl.create().get();
        assertTrue(activity.tvDisplay.getText().equals("displaying"));
        activity.tvDisplay.setText("Haha");
        ctl.saveInstanceState(b).destroy(); // 销毁Activity
        LifeCircleActivity reCreateAc =
                Robolectric.buildActivity(LifeCircleActivity.class)
                        .create().restoreInstanceState(b).get();
        assertTrue(reCreateAc.tvDisplay.getText().equals("Haha"));
    }


}