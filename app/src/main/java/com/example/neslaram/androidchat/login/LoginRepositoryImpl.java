package com.example.neslaram.androidchat.login;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.neslaram.androidchat.domain.FirebaseHelper;
import com.example.neslaram.androidchat.entities.User;
import com.example.neslaram.androidchat.lib.EventBus;
import com.example.neslaram.androidchat.lib.GreenRobotEventBus;
import com.example.neslaram.androidchat.login.events.LoginEvent;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by neslaram on 03/07/16.
 */
public class LoginRepositoryImpl implements LoginRepository {
    private FirebaseHelper helper;
    private DatabaseReference dataReference;
    private DatabaseReference myUserReference;


    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
        dataReference = this.helper.getDataReference();
    }

    @Override
    public void signUp(String email, String password) {
        postEvent(LoginEvent.onSignUpSuccess);
    }

    @Override
    public void signIn(String email, String password) {

        FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        myUserReference = helper.getMyUserReference();
                        myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                User currentUser= dataSnapshot.getValue(User.class);
                                if (currentUser==null){
                                    String email= helper.getAuthUserEmail();
                                    if (email!=null){
                                        currentUser= new User();
                                        myUserReference.setValue(currentUser);
                                    }
                                }

                                helper.changeUserConnectionStatus(User.ONLINE);
                                postEvent(LoginEvent.onSignInSucces);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        postEvent(LoginEvent.onSignInError, e.getMessage());

                    }
                });

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
