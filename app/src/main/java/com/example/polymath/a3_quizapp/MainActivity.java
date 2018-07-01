package com.example.polymath.a3_quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare the variables
    public static int scoreKeeper = 0; //Tracks the score
    final String QUIZ_ANSWER = "Nnamdi Azikiwe"; //Answer to the first question
    String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
    }

    public void firstNextButton(View v) {
        EditText quizEditText = (EditText) findViewById(R.id.quiz_text_view);
        String answer = quizEditText.getText().toString();
        checkAnswer(answer);
        //Call Second activity
        setContentView(R.layout.second_layout);
    }

    public void secondNextButton(View v) {
        //Call Third activity
        setContentView(R.layout.third_layout);
    }

    public void thirdNextButton(View v) {
        //Call third activity
        setContentView(R.layout.fourth_layout);

    }

    public void fourthNextButton(View v) {
        //Call fourth activity
        setContentView(R.layout.score_layout);
        TextView scoreView = findViewById(R.id.score_display);
        scoreView.setText("" + scoreKeeper + "/" + 5);
    }

    public void submitButton(View v) {
        Button submitButton = findViewById(R.id.submit_button);
        TextView scorePrompt = findViewById(R.id.total_score_prompt);
        TextView scoreDisplay = findViewById(R.id.score_display);
        //Change the view visibility
        submitButton.setVisibility(View.INVISIBLE);
        scorePrompt.setVisibility(View.VISIBLE);
        scoreDisplay.setVisibility(View.VISIBLE);
    }

    public void kunalIsChecked(View v) {
        CheckBox kunalCheckBox = findViewById(R.id.kunal_check_box);
        //Increase score if true
        if (kunalCheckBox.isChecked()) {
            increaseScoreKeeper();
        }
    }

    public void lylaIsChecked(View v) {
        CheckBox lylaCheckBox = findViewById(R.id.lyla_check_box);
        //Increase score if true
        if (lylaCheckBox.isChecked()) {
            increaseScoreKeeper();
        }
    }

    public void onRadioButtonClicked(View v) {
        RadioButton buhariRadioButton = findViewById(R.id.buhari_radio_button);
        //Increase score if true
        if (buhariRadioButton.isChecked()) {
            increaseScoreKeeper();
        }

    }

    public void onSecondRadioButtonClicked(View v) {
        RadioButton ronaldRadioButton = findViewById(R.id.ronaldo_radio_button);
        //Increase score if true
        if (ronaldRadioButton.isChecked()) {
            increaseScoreKeeper();
        }
    }

    //*******************************Helper methods****************************

    //This method allows child classes to increase the score
    private void increaseScoreKeeper() {
        scoreKeeper = scoreKeeper + 1;
    }

    //Check if answer is correct
    private void checkAnswer(String input) {
        //If answer is correct, increase the score, and display a toast
        if (input.equals(QUIZ_ANSWER)) {
            scoreKeeper = scoreKeeper + 1;
            Toast.makeText(MainActivity.this, "You now have " + scoreKeeper + " point.", Toast.LENGTH_SHORT).show();
        }
    }

}
