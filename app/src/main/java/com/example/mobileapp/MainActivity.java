package com.example.mobileapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}


//import com.google.firebase.analytics.FirebaseAnalytics;
//
//public class MainActivity extends AppCompatActivity {
//
//    private FirebaseAnalytics mFirebaseAnalytics;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Инициализация Firebase Analytics
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
//
//        // Логирование события
//        Bundle bundle = new Bundle();
//        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "id_example");
//        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "name_example");
//        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle);
//    }
//}

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String selectedTopic = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout firstBlock = findViewById(R.id.firstLayout);
        final LinearLayout secondBlock = findViewById(R.id.secondLayout);
        final LinearLayout thirdsBlock = findViewById(R.id.thirdsLayout);
        final LinearLayout fourthBlock = findViewById(R.id.fourthLayout);

        final Button startBtn = findViewById(R.id.startBtn);

        firstBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic = "Автомобили";
                firstBlock.setBackgroundResource(R.drawable.back_stroke_block_layout);
                secondBlock.setBackgroundResource(R.drawable.roung_back);
                thirdsBlock.setBackgroundResource(R.drawable.roung_back);
                fourthBlock.setBackgroundResource(R.drawable.roung_back);
            }
        });

        secondBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic = "Фильмы";
                secondBlock.setBackgroundResource(R.drawable.back_stroke_block_layout);
                firstBlock.setBackgroundResource(R.drawable.roung_back);
                thirdsBlock.setBackgroundResource(R.drawable.roung_back);
                fourthBlock.setBackgroundResource(R.drawable.roung_back);
            }
        });

        thirdsBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic = "Города";
                thirdsBlock.setBackgroundResource(R.drawable.back_stroke_block_layout);
                firstBlock.setBackgroundResource(R.drawable.roung_back);
                secondBlock.setBackgroundResource(R.drawable.roung_back);
                fourthBlock.setBackgroundResource(R.drawable.roung_back);
            }
        });

        fourthBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic = "IT сфера";
                fourthBlock.setBackgroundResource(R.drawable.back_stroke_block_layout);
                firstBlock.setBackgroundResource(R.drawable.roung_back);
                secondBlock.setBackgroundResource(R.drawable.roung_back);
                thirdsBlock.setBackgroundResource(R.drawable.roung_back);

            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedTopic.isEmpty()){
                    Toast.makeText(MainActivity.this, "Выберите викторину", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopic);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}