package com.example.neslaram.androidchat.login;

import com.example.neslaram.androidchat.login.events.LoginEvent;

/**
 * Created by neslaram on 03/07/16.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent event);
}
