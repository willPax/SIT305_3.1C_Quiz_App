package com.example.a31c_quizapp_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Final_Score_Activity extends AppCompatActivity {

    TextView totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        totalScore = findViewById(R.id.finalScore);



        //Intent intent = getIntent();

        //totalScore.setText(intent.getStringExtra("SCORE"));


    }
}