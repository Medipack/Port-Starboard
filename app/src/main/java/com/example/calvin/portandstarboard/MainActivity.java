package com.example.calvin.portandstarboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myApp";
    private Game PortStarboardGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PortStarboardGame = new Game();
        setContentView(R.layout.activity_main);
        final TextView quizQuest = (TextView) findViewById(R.id.questionCont);
        quizQuest.setText(PortStarboardGame.getChosenSideName());
        //wire up left button to log and make toast
        //...get the button
        Button leftbtn = (Button) findViewById(R.id.leftNameBtn);
        //...set up the button to toast when user clicks
        leftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Port(left) is Red", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Port(left) is Red");
            }
        });

        Button rightbtn = (Button) findViewById(R.id.rightNameBtn);
        //...set up the button to toast when user clicks
        rightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Starboard(right) is Green", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Starboard(right) is Green");
            }
        });

        Button leftAnswer = (Button) findViewById(R.id.leftAnsBtn);
        //user clicks one to indicate the game's currently chosen side
        leftAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if user is correct
                if (PortStarboardGame.checkIfCorrect(Game.Side.PORT)){
                    //make a Toast message
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                    //Log message
                    Log.i(TAG, "User guess of Port was correct!");
                }else{
                    //display Toast message
                    Toast.makeText(getApplicationContext(), "Incorrect! :(", Toast.LENGTH_SHORT).show();
                    //Log message
                    Log.i(TAG, "User guess of Port was incorrect!");
                    //Log message
                }
                //set up a new game
                PortStarboardGame = new Game();
                quizQuest.setText(PortStarboardGame.getChosenSideName());
            }
        });

        Button rightAnswer = (Button) findViewById(R.id.rightAnsBtn);
        rightAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if user is correct
                if (PortStarboardGame.checkIfCorrect(Game.Side.STARBOARD)){
                    //make a Toast message
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    //Log message
                    Log.i(TAG, "User guess of Starboard was correct!");
                }else{
                    //display Toast message
                    Toast.makeText(getApplicationContext(), "Incorrect! :(", Toast.LENGTH_SHORT).show();
                    //Log message
                    Log.i(TAG, "User guess of Starboard was incorrect!");
                    //Log message
                }
                //set up a new game
                PortStarboardGame = new Game();
                quizQuest.setText(PortStarboardGame.getChosenSideName());
            }
        });
    }}