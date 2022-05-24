package com.example.a31c_quizapp_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ask_Question_Activity extends AppCompatActivity {
    LinearLayout buttonGroup;

    TextView headerMessage;
    ProgressBar progressBar;
    TextView questionNumber;
    TextView questionTitle;
    TextView questionOption1;
    TextView questionOption2;
    TextView questionOption3;

    Button option1;
    Button option2;
    Button option3;
    Button submitAnswer;

    int currentQuestion = 0;
    int selectedAnswer = 0;
    int currentScore = 0;
    boolean checked;

    String userenterednamme;

    ArrayList<Question> QuestionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);

        headerMessage = findViewById(R.id.welcomeHeader);
        buttonGroup = findViewById(R.id.buttonLinearLayout);
        progressBar = findViewById(R.id.progressBar);
        questionNumber = findViewById(R.id.progressCounterTextView);
        questionTitle = findViewById(R.id.questionTitleTextView);
        questionOption1 = findViewById(R.id.optionOne);
        questionOption2 = findViewById(R.id.optionTwo);
        questionOption3 = findViewById(R.id.optionThree);
        option1 = findViewById(R.id.answerButton1);
        option2 = findViewById(R.id.answerButton2);
        option3 = findViewById(R.id.answerButton3);
        submitAnswer = findViewById(R.id.submitButton);

        Intent intent = getIntent();
        userenterednamme = intent.getStringExtra("USER_NAME");
        headerMessage.setText("Welcome to the quiz " + userenterednamme);

        questionNumber.setText(String.valueOf(currentQuestion + 1));

        makeQuestionList();
        progressBar.setMax(QuestionList.size()*10);
        askQuestion(currentQuestion);

        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedAnswer == 0 ){
                    Toast.makeText(Ask_Question_Activity.this, "Enter an answer..", Toast.LENGTH_SHORT).show();
                }
                else{
                    checked = !checked;
                    processAnswer(view);
                }
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checked){
                view.setBackgroundColor(getColor(R.color.teal_200));
                option2.setBackgroundColor(getColor(R.color.teal_700));
                option3.setBackgroundColor(getColor(R.color.teal_700));
                selectedAnswer = 1;}
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checked){
                view.setBackgroundColor(getColor(R.color.teal_200));
                option1.setBackgroundColor(getColor(R.color.teal_700));
                option3.setBackgroundColor(getColor(R.color.teal_700));
                selectedAnswer = 2;}
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checked){
                view.setBackgroundColor(getColor(R.color.teal_200));
                option1.setBackgroundColor(getColor(R.color.teal_700));
                option2.setBackgroundColor(getColor(R.color.teal_700));
                selectedAnswer = 3;}
            }
        });
    }

    private void processAnswer(View view) {
        option1.setBackgroundColor(getColor(R.color.teal_700));
        option2.setBackgroundColor(getColor(R.color.teal_700));
        option3.setBackgroundColor(getColor(R.color.teal_700));
        submitAnswer.setText("Next Question");

        if (checked){
            if(QuestionList.get(currentQuestion).getCorrectAnswer() == selectedAnswer)
            {
                buttonGroup.getChildAt(selectedAnswer-1).setBackgroundColor(getColor(R.color.green));
                currentScore += 1;
            }
            else{
                buttonGroup.getChildAt(selectedAnswer-1).setBackgroundColor(getColor(R.color.red));
                buttonGroup.getChildAt(QuestionList.get(currentQuestion).getCorrectAnswer()-1).setBackgroundColor(getColor(R.color.green));
            }
        }
        if (!checked){
            currentQuestion ++;
            askQuestion(currentQuestion);
        }
    }

    private void askQuestion(int number) {
        if (number > 0){headerMessage.setText("");}
        if (number >= QuestionList.size()){finalScore();return;}

        for(int i=0; i < 3; i++) {
            buttonGroup.getChildAt(i).setBackgroundColor(getColor(R.color.teal_700));}

        progressBar.setProgress(10 + number*10-1);
        Question currentQ = QuestionList.get(number);
        questionNumber.setText(number+1 + "/5");
        questionTitle.setText(currentQ.getQuestionTitle());
        questionOption1.setText(currentQ.getQuestionOption1());
        questionOption2.setText(currentQ.getQuestionOption2());
        questionOption3.setText(currentQ.getQuestionOption3());
        submitAnswer.setText("Submit Answer");
        checked = false;
        selectedAnswer = 0;
    }

    private void makeQuestionList(){
        Question firstQuestion = new Question("How do you assign a String to a TextView in Android Studio?","String string = findViewById(R.id.stringTextView);", "Button string = findViewById(R.id.stringTextView);", "String string = don'tFindViewById(R.id.stringTextView);", 1);
        QuestionList.add(firstQuestion);
        Question secondQuestion = new Question("How do you initiate sending an Intent to a new Activity in Android Studio?","Intent.send(new Activity)", "Intent intent = new Intent(this, Destination_Activity.class);", "Intent intent, please go there", 2);
        QuestionList.add(secondQuestion);
        Question thirdQuestion = new Question("Is it possible to save data between activities on application close?","No the data is lost when the previous activity is closed.", "Yes, but only using an external database", "You can store data locally with Saved Instance Sate and SQLite", 3);
        QuestionList.add(thirdQuestion);
        Question fourthQuestion = new Question("Where are imported images for the application stored?","In the /documents/images folder", "In the /res/drawable folder", "You just use a URI link to them and let the app sort it out", 2);
        QuestionList.add(fourthQuestion);
        Question fithQuestion = new Question("Can you set a different app layout for a different orientation, or must it match","You can set a different layout depending on the orientation", "You must keep the same layout or the application will crash", "Only make one orientation and android will flip it perfectly every time", 1);
        QuestionList.add(fithQuestion);
    }

    private void finalScore(){
        String totalScore = String.valueOf(currentScore);
        Intent intent = new Intent(this, Check_Answer_Activity.class);
        intent.putExtra("USER_NAME", userenterednamme);
        intent.putExtra("SCORE", totalScore);
        startActivity(intent);
    }
}