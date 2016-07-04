package com.example.neslaram.androidchat.login;

import android.util.Log;

import com.example.neslaram.androidchat.domain.FirebaseHelper;
import com.example.neslaram.androidchat.lib.EventBus;
import com.example.neslaram.androidchat.lib.GreenRobotEventBus;
import com.example.neslaram.androidchat.login.events.LoginEvent;

/**
 * Created by neslaram on 03/07/16.
 */
public class LoginRepositoryImpl implements LoginRepository {
    private FirebaseHelper helper;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signUp(String email, String password) {
        postEvent(LoginEvent.onSignUpSuccess);
    }

    @Override
    public void signIn(String email, String password) {
        postEvent(LoginEvent.onSignInSucces);
    }

    @Override
    public void checkSession() {
        postEvent(LoginEvent.onFailedToRecoverSession);

    }

    private void postEvent(int type, String errorMessage) {
        LoginEvent loginEvent = new LoginEvent(type, errorMessage);
        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }

    private void postEvent(int type) {
        postEvent(type, null);
    }
}
