package com.example.neslaram.androidchat.login;

/**
 * Created by neslaram on 03/07/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private LoginRepository loginRepository;


    public LoginInteractorImpl() {
        this.loginRepository= new LoginRepositoryImpl();
    }

    @Override
    public void checkSession() {
        loginRepository.checkSession();
    }

    @Override
    public void doSignUp(String email, String password) {
        loginRepository.signUp(email, password);
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(email, password);
    }
}
