package com.example.task31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class FifthQuestionActivity extends AppCompatActivity {

    //create variables
    TextView nameTitleTextView;

    Button answer1Button, answer2Button, answer3Button, answer4Button, submitButton;

    ProgressBar progressBar;

    Integer submitClicked = 0;

    Integer scoreTally;

    Integer selectedAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_question);

        //connect variables to layout items
        nameTitleTextView = findViewById(R.id.nameTitleTextView);
        progressBar = findViewById(R.id.progressBar);
        answer1Button = findViewById(R.id.answer1Button);
        answer2Button = findViewById(R.id.answer2Button);
        answer3Button = findViewById(R.id.answer3Button);
        answer4Button = findViewById(R.id.answer4Button);
        submitButton = findViewById(R.id.submitButton);

        //update progress bar to 100% filled
        progressBar.setProgress(100);

        Intent valueIntent = getIntent();
        //get name from previous activity and show name with message on screen
        String nameValue = valueIntent.getStringExtra("name_value");
        nameTitleTextView.setText("Last Question " + nameValue + "! Make it count!");

        scoreTally = valueIntent.getIntExtra("score_value", 0);

        //set on click functions for all question buttons
        //if button is selected, change the colour to show selection
        //check functions.java file for more information
        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = functions.answerSelected(1,answer1Button, answer2Button,answer3Button,answer4Button);
            }
        });

        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = functions.answerSelected(2,answer1Button, answer2Button,answer3Button,answer4Button);
            }
        });

        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = functions.answerSelected(3,answer1Button, answer2Button,answer3Button,answer4Button);
            }
        });

        answer4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = functions.answerSelected(4,answer1Button, answer2Button,answer3Button,answer4Button);
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            //when submit button is clicked, check if answer is selected
            //if answer is selected, total score is updated (scoretally) and change text to 'next' for button
            //refer to functions.java for more information
            //if 'next' is pressed, move to next activity and pass total score and name in variables to use
            @Override
            public void onClick(View view) {
                if (selectedAnswer == null) {
                    Toast.makeText(FifthQuestionActivity.this, "Please select an answer.", Toast.LENGTH_SHORT).show();
                } else {
                    submitClicked++;
                }
                if (submitClicked == 1) {
                    scoreTally = functions.submitClicked(selectedAnswer, 5, scoreTally, answer1Button, answer2Button,answer3Button,answer4Button);
                    submitButton.setText("Next");
                } else if (submitClicked == 2) {
                    Log.v("check twice", scoreTally.toString());
                    Intent newIntent = new Intent(FifthQuestionActivity.this, ScoreActivity.class);
                    newIntent.putExtra("score_value", scoreTally);
                    newIntent.putExtra("name_value", nameValue);
                    startActivityForResult(newIntent, 1);
                    finish();
                }

            }
        });

    }
}