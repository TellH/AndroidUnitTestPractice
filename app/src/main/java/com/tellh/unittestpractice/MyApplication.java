package com.tellh.unittestpractice;

import android.app.Application;

import com.tellh.unittestpractice.dagger.AppComponent;
import com.tellh.unittestpractice.dagger.AppModule;
import com.tellh.unittestpractice.dagger.ComponentHolder;
import com.tellh.unittestpractice.dagger.DaggerAppComponent;

/**
 * Created by tlh on 2017/4/18 :)
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        ComponentHolder.setAppComponent(appComponent);
    }
}
