package com.tellh.unittestpractice.rxjava;

import rx.Observable;

/**
 * Created by tlh on 2017/4/22 :)
 */

public class RxJavaTestRepository {
    public Observable<String> getTest() {
        return Observable.just("Hello World");
    }
}
