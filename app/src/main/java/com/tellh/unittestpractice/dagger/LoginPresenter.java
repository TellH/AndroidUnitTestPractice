package com.tellh.unittestpractice.dagger;

/**
 * Created by tlh on 2017/4/18 :)
 */

public class LoginPresenter {
    private UserManager userManager;

    public LoginPresenter(UserManager userManager) {
        this.userManager = userManager;
    }

    public void login(String username, String password, LoginCallback callback) {
        if (username == null || username.length() == 0) return;
        if (userManager.performLogin(username, password))
            callback.onSuccess();
        else callback.onFailed();
    }

    interface LoginCallback {
        void onSuccess();

        void onFailed();
    }
}
