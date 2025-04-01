package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        final AppCompatButton startNewQuizBnt = findViewById(R.id.starnNewQuizBtn);
        final TextView correctAnswer = findViewById(R.id.correctAnswers);
        final TextView inCorrectAnswers = findViewById(R.id.inCorrectAnswers);

        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        final int getIncorrectAnswers = getIntent().getIntExtra("incorrect", 0);

        correctAnswer.setText(String.valueOf("Количество верных ответов: " + getCorrectAnswers));
        inCorrectAnswers.setText(String.valueOf("Количество неверных ответов: " + getIncorrectAnswers));

        startNewQuizBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResults.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(QuizResults.this, MainActivity.class));
        finish();
    }
}