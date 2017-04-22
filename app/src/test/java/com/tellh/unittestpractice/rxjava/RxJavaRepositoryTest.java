package com.tellh.unittestpractice.rxjava;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import rx.observers.TestSubscriber;

/**
 * Created by tlh on 2017/4/22 :)
 * 使用TestSubscriber来测试RxJava
 */
public class RxJavaRepositoryTest {
    @Mock
    TestSubscriber<String> mSubscriber;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void getTest() throws Exception {
        new RxJavaTestRepository().getTest().subscribe(mSubscriber);
        mSubscriber.assertValue("Hello World");
        mSubscriber.assertNoErrors();
    }

}