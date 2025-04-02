package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class QuizResults extends AppCompatActivity {

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        db = FirebaseFirestore.getInstance(); // Инициализируем Firestore

        final AppCompatButton startNewQuizBnt = findViewById(R.id.starnNewQuizBtn);
        final TextView correctAnswer = findViewById(R.id.correctAnswers);
        final TextView inCorrectAnswers = findViewById(R.id.inCorrectAnswers);
        final TextView topicTextView = findViewById(R.id.selectedTopicText);  // Новый TextView для отображения темы


        // Получаем переданные данные
        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        final int getIncorrectAnswers = getIntent().getIntExtra("incorrect", 0);
        String selectedTopic = getIntent().getStringExtra("selectedTopic");

        // Проверка на null для selectedTopic
        if (selectedTopic == null || selectedTopic.isEmpty()) {
            selectedTopic = "Не выбран"; // Присваиваем дефолтное значение, если не передано
        }

        // Отображаем результаты
        correctAnswer.setText("Количество верных ответов: " + getCorrectAnswers);
        inCorrectAnswers.setText("Количество неверных ответов: " + getIncorrectAnswers);
        topicTextView.setText("Тема викторины: " + selectedTopic);  // Устанавливаем тему викторины


        // Сохраняем результаты в Firestore
        saveResultsToFirestore(selectedTopic, getCorrectAnswers, getIncorrectAnswers);

        // Кнопка для начала нового опроса
        startNewQuizBnt.setOnClickListener(view -> {
            startActivity(new Intent(QuizResults.this, MainActivity.class));
            finish();
        });
    }

    private void saveResultsToFirestore(String selectedTopic, int correctAnswers, int incorrectAnswers) {
        // Создаем объект с результатами викторины
        QuizResult quizResult = new QuizResult(selectedTopic, correctAnswers, incorrectAnswers);

        // Сохраняем объект в Firestore
        db.collection("quizResults")
                .add(quizResult)
                .addOnSuccessListener(documentReference -> {
                    // Действие при успешном сохранении
                    System.out.println("Результат успешно сохранен! Document ID: " + documentReference.getId());
                })
                .addOnFailureListener(e -> {
                    // Обработка ошибки при сохранении
                    System.out.println("Ошибка при сохранении результата: " + e.getMessage());
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(QuizResults.this, MainActivity.class));
        finish();
    }
}
