package com.example.han.truefalsequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.han.truefalsequiz.R.id.button_next;

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
        questionBank.add(new Question(getString(R.string.question_4),true));
    }

    private void setListeners() {
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    private void wireWidget() {
        trueButton = (Button) findViewById(R.id.button_true);
        falseButton = (Button) findViewById(R.id.button_false);
        nextButton = (Button) findViewById(button_next);
        questionText = (TextView) findViewById(R.id.text_question);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case (button_next):
                    next(); //method for switching to the next question.

                break;
            case (R.id.button_true):
                if (questionBank.get(i).checkAnswer(true))
                {
                    Toast.makeText(this, R.string.text_congrat, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, R.string.text_fail, Toast.LENGTH_SHORT).show();
                }
                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
                nextButton.setEnabled(true);
                i++;

                break;
            case (R.id.button_false):
                if (questionBank.get(i).checkAnswer(false))
                {
                    Toast.makeText(this, R.string.text_congrat, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, R.string.text_fail, Toast.LENGTH_SHORT).show();
                }
                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
                nextButton.setEnabled(true);
                i++;
                break;
        }


    }

    private void next() {
        if (i > questionBank.size()-1)
        {
            questionText.setText(R.string.text_finish);
            i = 0;
        }
        else
        {
            questionText.setText(questionBank.get(i).getQuestionText());
            trueButton.setEnabled(true);
            falseButton.setEnabled(true);
            nextButton.setEnabled(false);
        }
    }
}
