package com.example.neslaram.androidchat;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
