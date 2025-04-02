package com.example.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String selectedTopic = "";
    private final List<QuestionsList> questionsList = new ArrayList<>();
    private LinearLayout firstBlock, secondBlock, thirdBlock, fourthBlock;
    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        firstBlock.setOnClickListener(view -> selectTopic("Автомобили", firstBlock));
        secondBlock.setOnClickListener(view -> selectTopic("Фильмы", secondBlock));
        thirdBlock.setOnClickListener(view -> selectTopic("Города", thirdBlock));
        fourthBlock.setOnClickListener(view -> selectTopic("IT сфера", fourthBlock));
        startBtn.setOnClickListener(view -> startQuiz());
    }

    private void initializeViews() {
        firstBlock = findViewById(R.id.firstLayout);
        secondBlock = findViewById(R.id.secondLayout);
        thirdBlock = findViewById(R.id.thirdsLayout);
        fourthBlock = findViewById(R.id.fourthLayout);
        startBtn = findViewById(R.id.startBtn);
    }

    private void selectTopic(String topic, LinearLayout selectedBlock) {
        selectedTopic = topic;
        resetBlockStyles();
        selectedBlock.setBackgroundResource(R.drawable.back_stroke_block_layout);
        loadQuestionsFromFirebase();
    }

    private void resetBlockStyles() {
        firstBlock.setBackgroundResource(R.drawable.roung_back);
        secondBlock.setBackgroundResource(R.drawable.roung_back);
        thirdBlock.setBackgroundResource(R.drawable.roung_back);
        fourthBlock.setBackgroundResource(R.drawable.roung_back);
    }

    private void loadQuestionsFromFirebase() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("questions");
        databaseReference.orderByChild("topic").equalTo(selectedTopic).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                questionsList.clear();
                for (DataSnapshot questionSnapshot : snapshot.getChildren()) {
                    QuestionsList questionItem = questionSnapshot.getValue(QuestionsList.class);
                    if (questionItem != null) {
                        questionsList.add(questionItem);
                    }
                }
                Log.d("Firebase", "Загружено " + questionsList.size() + " вопросов");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, "Ошибка загрузки данных", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startQuiz() {
        if (selectedTopic.isEmpty()) {
            Toast.makeText(MainActivity.this, "Выберите викторину", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            intent.putExtra("selectedTopic", selectedTopic);
            startActivity(intent);
            finish();
        }
    }
}
