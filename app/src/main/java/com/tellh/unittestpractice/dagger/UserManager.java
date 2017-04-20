package com.tellh.unittestpractice.dagger;

/**
 * Created by tlh on 2017/4/18 :)
 */

public class UserManager {
    public boolean performLogin(String userName, String password) {
        return userName.equals("TellH") && password.equals("abc");
    }
}
