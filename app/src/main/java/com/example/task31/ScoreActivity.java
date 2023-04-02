package com.example.task31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    //create variables
    Integer scoreTally;

    Button newQuizButton;
    Button finishButton;

    TextView nameTitleTextView;
    TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //connect variables to layout items
        nameTitleTextView = findViewById(R.id.nameTitleTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        newQuizButton = findViewById(R.id.newQuizButton);
        finishButton = findViewById(R.id.finishButton);

        Intent valueIntent = getIntent();
        //get name from previous activity and show on screen
        String nameValue = valueIntent.getStringExtra("name_value");
        nameTitleTextView.setText("Congratulations " + nameValue + "!");

        //get the score tally and show on screen
        scoreTally = valueIntent.getIntExtra("score_value", 0);
        scoreTextView.setText(scoreTally.toString());

        newQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //if new quiz button pressed, move to firstquestionactivity and send name for use
            public void onClick(View view) {
                Intent newIntent = new Intent(ScoreActivity.this, FirstQuestionActivity.class);
                newIntent.putExtra("name_value", nameValue);
                startActivityForResult(newIntent, 1);
                finish();
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //if finish button pressed, close the app
            public void onClick(View view) {
                finish();
            }
        });


    }
}