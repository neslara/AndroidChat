package com.example.neslaram.androidchat.login;

/**
 * Created by neslaram on 03/07/16.
 */
public interface LoginRepository {
    void signUp(String email, String password);
    void signIn(String email, String password);
    void checkSession();
}
