package com.example.mobileapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {
    private DatabaseReference databaseReference;

    public FirebaseHelper() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("questions");
    }

    public void addQuestion(QuestionsList question) {
        String key = databaseReference.push().getKey();
        if (key != null) {
            databaseReference.child(key).setValue(question);
        }
    }
}
