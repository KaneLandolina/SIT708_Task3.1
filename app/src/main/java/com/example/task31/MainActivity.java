/* --------------- STUDENT DETAILS ----------------
Name: Kane Landolina
ID: 218692411
UNIT Code: SIT708
 */


package com.example.task31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //create variables
    EditText editTextPersonName;
    Button entryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect variables with items in layout
        editTextPersonName = findViewById(R.id.editTextPersonName);
        entryButton = findViewById(R.id.newQuizButton);

        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputNameValue = editTextPersonName.getText().toString().trim();
                //check if name is empty
                //if empty alert the user
                //if name entered continue and pass name to next activity
                if (!inputNameValue.matches("")) {
                    Log.v("checking", "button is clicked");
                    Intent newIntent = new Intent(MainActivity.this, FirstQuestionActivity.class);
                    newIntent.putExtra("name_value", inputNameValue);
                    startActivityForResult(newIntent, 1);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter your name.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}