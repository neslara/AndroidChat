package com.example.neslaram.androidchat.domain;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by neslaram on 25/06/16.
 */
public class FirebaseHelper {
    private DatabaseReference dataReference;
    private final static String CHATS_PATH = "chats";
    private final static String USERS_PATH = "users";
    private final static String CONTACTS_PATH = "contacts";
    private final static String FIREBASE_URL = "https://androidchat-bc572.firebaseio.com";

    private static class SingletonHolder {
        private static final FirebaseHelper INSTANCE = new FirebaseHelper();
    }

    public static FirebaseHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private FirebaseHelper() {
        this.dataReference = FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference getDataReference() {
        return dataReference;
    }

    public String getAuthUserEmail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        return user != null ? user.getEmail() : null;
    }

    public DatabaseReference getUserReference(String email) {
        DatabaseReference userReference = null;
        if (email != null) {
            String emailKey = email.replace(".", "_");
            userReference = dataReference.getRoot().child(USERS_PATH).child(emailKey);
        }
        return userReference;
    }
}
