package com.example.han.truefalsequiz;



public class Question {
    private String questionText;
    private boolean answer;

    public Question(String questionText, boolean answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean isAnswer() {
        return answer;
    }

    public boolean checkAnswer(boolean userAnswer){
     return userAnswer == answer;
    }
}
