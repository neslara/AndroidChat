package com.example.neslaram.androidchat.login;

/**
 * Created by neslaram on 03/07/16.
 */
public interface LoginPresenter {
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
