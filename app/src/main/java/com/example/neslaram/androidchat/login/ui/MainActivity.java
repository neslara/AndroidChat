package com.example.neslaram.androidchat.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.neslaram.androidchat.ContactActivity;
import com.example.neslaram.androidchat.R;
import com.example.neslaram.androidchat.login.LoginPresenter;
import com.example.neslaram.androidchat.login.LoginPresenterImpl;
import com.example.neslaram.androidchat.login.ui.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.inputEmail)
    TextInputEditText inputEmail;
    @Bind(R.id.inputPassword)
    TextInputEditText inputPassword;
    @Bind(R.id.bttnSignIn)
    Button bttnSignIn;
    @Bind(R.id.bttnSignUp)
    Button bttnSignUp;
    @Bind(R.id.progressBar)
    ContentLoadingProgressBar progressBar;
    @Bind(R.id.mainContainer)
    LinearLayout mainContainer;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.onCreate();
        loginPresenter.checkForAuthenticatedUser();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void enableInputs() {
        setInputs(true);

    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @OnClick(R.id.bttnSignUp)
    @Override
    public void handleSignUp() {
        loginPresenter.registerNewUser(
                inputEmail.getText().toString().trim(),
                inputPassword.getText().toString().trim()
        );
    }

    @OnClick(R.id.bttnSignIn)
    @Override
    public void handleSignIn() {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        if (!email.isEmpty() || !password.isEmpty()) {
            loginPresenter.validateLogin(email, password);
        }

    }

    @Override
    public void navigateToMainScreen() {
        Intent i = new Intent(this, ContactActivity.class);
        startActivity(i);

    }

    @Override
    public void loginError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin, error));
        inputPassword.setError(msgError);
    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(mainContainer, R.string.login_notice_message_signup, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void newUserError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signup, error));
        inputPassword.setError(msgError);
    }

    private void setInputs(boolean enabled) {
        inputEmail.setEnabled(enabled);
        inputPassword.setEnabled(enabled);
        bttnSignIn.setEnabled(enabled);
        bttnSignUp.setEnabled(enabled);
    }
}
