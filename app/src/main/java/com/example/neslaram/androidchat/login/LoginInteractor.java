package com.example.neslaram.androidchat.login;

/**
 * Created by neslaram on 03/07/16.
 */
public interface LoginInteractor {
    void checkSession();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
