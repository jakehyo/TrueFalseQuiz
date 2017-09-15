package com.example.han.truefalsequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button trueButton, falseButton,nextButton;
    private TextView questionText;
    private int i = 0;

    private ArrayList<Question> questionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidget();
        setListeners();
        initQuestionBank();

    }

    private void initQuestionBank() {
        questionBank = new ArrayList<>();
        questionBank.add(new Question(getString(R.string.question_1), true));
        questionBank.add(new Question(getString(R.string.question_2), false));
        questionBank.add(new Question(getString(R.string.question_3), true));
    }

    private void setListeners() {
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    private void wireWidget() {
        trueButton = (Button) findViewById(R.id.button_true);
        falseButton = (Button) findViewById(R.id.button_false);
        nextButton = (Button) findViewById(R.id.button_next);
        questionText = (TextView) findViewById(R.id.text_question);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case (R.id.button_next):
                    questionText.setText(questionBank.get(i).getQuestionText());
                    i++;
                break;
        }


    }
}
