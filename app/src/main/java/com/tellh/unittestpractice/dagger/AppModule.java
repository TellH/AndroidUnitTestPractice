package com.tellh.unittestpractice.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tlh on 2017/4/18 :)
 */

@Module
public class AppModule {
    private final Context mContext;

    public AppModule(Context context) {
        this.mContext = context;
    }

    @Provides
    public LoginPresenter provideLoginPresenter(UserManager userManager) {
        return new LoginPresenter(userManager);
    }

    @Provides
    public UserManager provideUserManager() {
        return new UserManager();
    }

    @Provides
    public Context provideContext() {
        return mContext;
    }

}
