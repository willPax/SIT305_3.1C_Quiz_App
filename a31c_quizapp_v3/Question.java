package com.example.a31c_quizapp_v3;

public class Question {
    private String questionTitle;
    private String questionOption1;
    private String questionOption2;
    private String questionOption3;
    private int correctAnswer;


    public Question(String questionTitle,  String questionOption1, String questionOption2, String questionOption3, int correctAnswer) {
        this.questionTitle = questionTitle;
        this.questionOption1 = questionOption1;
        this.questionOption2 = questionOption2;
        this.questionOption3 = questionOption3;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionOption1() {
        return questionOption1;
    }

    public void setQuestionOption1(String questionOption1) {
        this.questionOption1 = questionOption1;
    }

    public String getQuestionOption2() {
        return questionOption2;
    }

    public void setQuestionOption2(String questionOption2) {
        this.questionOption2 = questionOption2;
    }

    public String getQuestionOption3() {
        return questionOption3;
    }

    public void setQuestionOption3(String questionOption3) {
        this.questionOption3 = questionOption3;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
