package com.example.neslaram.androidchat.login.events;

/**
 * Created by neslaram on 03/07/16.
 */
public class LoginEvent {
    public final static int onSignInError = 0;
    public final static int onSignUpError = 1;
    public final static int onSignInSuccess = 2;
    public final static int onSignUpSuccess = 3;
    public final static int onFailedToRecoverSession = 4;

    private int evenType;
    private String errorMessage;

    public LoginEvent(int evenType, String errorMessage) {
        this.evenType = evenType;
        this.errorMessage = errorMessage;
    }

    public int getEvenType() {
        return evenType;
    }

    public void setEvenType(int evenType) {
        this.evenType = evenType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
