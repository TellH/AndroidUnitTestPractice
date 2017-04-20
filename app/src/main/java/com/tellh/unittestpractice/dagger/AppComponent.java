package com.tellh.unittestpractice.dagger;

import dagger.Component;

/**
 * Created by tlh on 2017/4/18 :)
 */
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(LoginActivity activity);

    LoginPresenter LOGIN_PRESENTER();
}
