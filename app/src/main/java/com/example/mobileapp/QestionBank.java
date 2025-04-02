package com.example.mobileapp;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.*;

public class QestionBank {
    private FirebaseHelper firebaseHelper;
    private DatabaseReference databaseReference;

    public QestionBank() {
        firebaseHelper = new FirebaseHelper();
        databaseReference = FirebaseDatabase.getInstance().getReference("questions"); // Путь к вопросам в Firebase
    }

    public interface QuestionsCallback {
        void onQuestionsLoaded(List<QuestionsList> questions);
        void onError(String error);
    }

    public void fetchQuestionsFromFirebase(String selectedTopicName, QuestionsCallback callback) {
        databaseReference.orderByChild("topic").equalTo(selectedTopicName.trim())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        List<QuestionsList> questionsList = new ArrayList<>();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            QuestionsList question = snapshot.getValue(QuestionsList.class);
                            if (question != null) { // Проверяем, что объект не null
                                questionsList.add(question);
                            }
                        }
                        callback.onQuestionsLoaded(questionsList);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        callback.onError(databaseError.getMessage());
                    }
                });
    }
}
