package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView question, questions, timer;
    private AppCompatButton option1, option2, option3, option4, nextBtn;
    private Timer quizTimer;
    private int seconds = 0;
    private int totalTimeInMins = 1;
    private List<QuestionsList> questionsList;
    private int currentQuestionPosition = 0;
    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ImageView backBtn = findViewById(R.id.backBtn);
        timer = findViewById(R.id.timer);
        TextView selectedTopicName = findViewById(R.id.selectedTopicName);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn);

        String getSelectedTopic = getIntent().getStringExtra("selectedTopic");
        selectedTopicName.setText(getSelectedTopic);

        loadQuestions(getSelectedTopic);
        startTimer();

        backBtn.setOnClickListener(view -> {
            quizTimer.cancel();
            startActivity(new Intent(QuizActivity.this, MainActivity.class));
            finish();
        });
    }

    private void loadQuestions(String topic) {
        QestionBank questionBank = new QestionBank();
        questionBank.fetchQuestionsFromFirebase(topic, new QestionBank.QuestionsCallback() {
            @Override
            public void onQuestionsLoaded(List<QuestionsList> questions) {
                if (questions.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Вопросы не найдены!", Toast.LENGTH_SHORT).show();
                    finish();
                    return;
                }
                questionsList = questions;
                displayQuestion();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(QuizActivity.this, "Ошибка загрузки: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayQuestion() {
        QuestionsList q = questionsList.get(currentQuestionPosition);
        questions.setText((currentQuestionPosition + 1) + "/" + questionsList.size());
        question.setText(q.getQuestion());
        option1.setText(q.getOption1());
        option2.setText(q.getOption2());
        option3.setText(q.getOption3());
        option4.setText(q.getOption4());

        option1.setOnClickListener(view -> selectOption(option1));
        option2.setOnClickListener(view -> selectOption(option2));
        option3.setOnClickListener(view -> selectOption(option3));
        option4.setOnClickListener(view -> selectOption(option4));

        nextBtn.setOnClickListener(view -> {
            if (selectedOptionByUser.isEmpty()) {
                Toast.makeText(this, "Выберите вариант!", Toast.LENGTH_SHORT).show();
            } else {
                goToNextQuestion();
            }
        });
    }

    private void selectOption(AppCompatButton selectedButton) {
        if (!selectedOptionByUser.isEmpty()) return;

        selectedOptionByUser = selectedButton.getText().toString();
        selectedButton.setBackgroundResource(R.drawable.round_back_red_10);
        selectedButton.setTextColor(Color.WHITE);

        QuestionsList currentQuestion = questionsList.get(currentQuestionPosition);
        currentQuestion.setUserSelectedAnswer(selectedOptionByUser);

        revealAnswer();
    }

    private void revealAnswer() {
        String correctAnswer = questionsList.get(currentQuestionPosition).getAnswer();
        for (AppCompatButton btn : new AppCompatButton[]{option1, option2, option3, option4}) {
            if (btn.getText().toString().equals(correctAnswer)) {
                btn.setBackgroundResource(R.drawable.round_back_green_10);
                btn.setTextColor(Color.WHITE);
            }
        }
    }

    private void goToNextQuestion() {
        stopTimer();
        startTimer();

        if (++currentQuestionPosition < questionsList.size()) {
            selectedOptionByUser = "";
            resetButtonStyles();
            displayQuestion();
        } else {
            endQuiz();
        }
    }

    private void resetButtonStyles() {
        for (AppCompatButton btn : new AppCompatButton[]{option1, option2, option3, option4}) {
            btn.setBackgroundResource(R.drawable.round_back_stroke_10);
            btn.setTextColor(Color.parseColor("#1F6BB8"));
        }
    }

    private void startTimer() {
        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds == 0 && totalTimeInMins == 0) {
                    quizTimer.cancel();
                    runOnUiThread(() -> {
                        Toast.makeText(QuizActivity.this, "Время вышло!", Toast.LENGTH_SHORT).show();
                        endQuiz();
                    });
                } else {
                    if (seconds == 0) {
                        totalTimeInMins--;
                        seconds = 59;
                    } else {
                        seconds--;
                    }
                }
                runOnUiThread(() -> timer.setText(String.format("%02d:%02d", totalTimeInMins, seconds)));
            }
        }, 1000, 1000);
    }

    private void stopTimer() {
        if (quizTimer != null) {
            quizTimer.cancel();
            quizTimer.purge();
        }
        totalTimeInMins = 1;
        seconds = 0;
    }

    private void endQuiz() {
        int correctAnswers = getCorrectAnswers();
        int incorrectAnswers = questionsList.size() - correctAnswers;
        String selectedTopic = getIntent().getStringExtra("selectedTopic");

        Intent intent = new Intent(this, QuizResults.class);
        intent.putExtra("correct", correctAnswers);
        intent.putExtra("incorrect", incorrectAnswers);
        intent.putExtra("selectedTopic", selectedTopic);
        startActivity(intent);
        finish();
    }


    private int getCorrectAnswers() {
        int count = 0;
        for (QuestionsList q : questionsList) {
            if (q.getUserSelectedAnswer() != null && q.getUserSelectedAnswer().equals(q.getAnswer())) {
                count++;
            }
        }
        return count;
    }


    @Override
    public void onBackPressed() {
        stopTimer();
        super.onBackPressed();
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();
    }
}
