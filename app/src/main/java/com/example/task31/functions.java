package com.example.task31;

import android.graphics.Color;
import android.widget.Button;

public class functions {
    public static int answerSelected(int answer, Button answer1Button, Button answer2Button, Button answer3Button, Button answer4Button) {
        //set colours based which answer is selected
        answer1Button.setBackgroundColor(Color.parseColor("#6200ee"));
        answer2Button.setBackgroundColor(Color.parseColor("#6200ee"));
        answer3Button.setBackgroundColor(Color.parseColor("#6200ee"));
        answer4Button.setBackgroundColor(Color.parseColor("#6200ee"));
        if(answer == 1) {
            answer1Button.setBackgroundColor(Color.parseColor("#00ceee"));
        } else if (answer == 2) {
            answer2Button.setBackgroundColor(Color.parseColor("#00ceee"));
        } else if (answer == 3) {
            answer3Button.setBackgroundColor(Color.parseColor("#00ceee"));
        } else if (answer == 4) {
            answer4Button.setBackgroundColor(Color.parseColor("#00ceee"));
        }
        return answer;
    }

    public static int submitClicked(int answer, int question, int scoreTally, Button answer1Button, Button answer2Button, Button answer3Button, Button answer4Button) {
        //submitclicked receives the input answer from the user, the question number, the score tally and all the answer buttons
        //set all answer buttons to not be clickable
        //for each question, se the correct button to green and the input incorrect button to red
        //score tally is also updated if the correct answer is selected
        answer1Button.setClickable(false);
        answer2Button.setClickable(false);
        answer3Button.setClickable(false);
        answer4Button.setClickable(false);
        if (question == 1) {
            answer1Button.setBackgroundColor(Color.GREEN);
            if (answer == 1) {
                scoreTally++;
            } else if (answer == 2) {
                answer2Button.setBackgroundColor(Color.RED);
            } else if (answer == 3) {
                answer3Button.setBackgroundColor(Color.RED);
            } else if (answer == 4) {
                answer4Button.setBackgroundColor(Color.RED);
            }
        }
        if (question == 2) {
            answer3Button.setBackgroundColor(Color.GREEN);
            if (answer == 3) {
                scoreTally++;
            } else if (answer == 1) {
                answer1Button.setBackgroundColor(Color.RED);
            } else if (answer == 2) {
                answer2Button.setBackgroundColor(Color.RED);
            } else if (answer == 4) {
                answer4Button.setBackgroundColor(Color.RED);
            }
        }
        if (question == 3 || question == 4) {
            answer2Button.setBackgroundColor(Color.GREEN);
            if (answer == 2) {
                scoreTally++;
            } else if (answer == 1) {
                answer1Button.setBackgroundColor(Color.RED);
            } else if (answer == 3) {
                answer3Button.setBackgroundColor(Color.RED);
            } else if (answer == 4) {
                answer4Button.setBackgroundColor(Color.RED);
            }
        }
        if (question == 5) {
            answer4Button.setBackgroundColor(Color.GREEN);
            if (answer == 4) {
                scoreTally++;
            } else if (answer == 1) {
                answer1Button.setBackgroundColor(Color.RED);
            } else if (answer == 2) {
                answer2Button.setBackgroundColor(Color.RED);
            } else if (answer == 3) {
                answer3Button.setBackgroundColor(Color.RED);
            }
        }
        return scoreTally;
    }
}
