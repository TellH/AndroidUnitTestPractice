package com.tellh.unittestpractice.rule;

import android.content.Context;

import com.tellh.unittestpractice.BuildConfig;
import com.tellh.unittestpractice.dagger.UserManager;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by tlh on 2017/4/20 :)
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class JUnitRuleTest {
    @Rule
    public Timeout timeout = new Timeout(1000 * 60);
    @Rule // 自定义Rule
    public LoggerRule loggerRule = new LoggerRule();
    // 使用注解快速生成Mock和Spy
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    UserManager mockUserManager;
    @Spy
    UserManager spyUserManager;

    @Rule
    public ContextRule contextRule = new ContextRule();
    public Context context;

    @Test
    public void testTimeOut() {
        try {
            Thread.sleep(100); // pass
//            Thread.sleep(2000); // fail
        } catch (InterruptedException e) {
        }
    }

    @Test
    public void testLoggerRule() {
    }

    @Test
    public void testMockAnnotation() {
        Assert.assertNotNull(mockUserManager);
    }

    @Test
    public void testContextInject() {
        Assert.assertNotNull(context);
    }

    @Test
    public void testSpyInject() {
        Assert.assertNotNull(spyUserManager);
    }
}
