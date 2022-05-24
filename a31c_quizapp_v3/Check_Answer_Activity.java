package com.example.a31c_quizapp_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Check_Answer_Activity extends AppCompatActivity {

    TextView finalScore;
    TextView userName;

    String receivedUserName;
    String receivedScore;
    Button playAgain;
    Button exitGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_answer);

        finalScore = findViewById(R.id.finalScoreTextView);
        userName = findViewById(R.id.userNaneFinalTextView);
        playAgain = findViewById(R.id.playAgainButton);
        exitGame = findViewById(R.id.exitGameButton);

        Intent intent = getIntent();

        receivedUserName = intent.getStringExtra("USER_NAME");
        receivedScore = intent.getStringExtra("SCORE");
        userName.setText("Congratulations " + receivedUserName + "!!");
        finalScore.setText("You scored " + receivedScore +"/5 ");

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Check_Answer_Activity.this, Ask_Question_Activity.class);
                intent.putExtra("USER_NAME", receivedUserName);
                startActivity(intent);
            }
        });

        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}