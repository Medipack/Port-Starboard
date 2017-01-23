package com.example.calvin.portandstarboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "PortSBReport";
    private Game PortStarboardGame;

    //FUNCTIONS
    //Picks a side to be displayed in textView
    //Accepts a Textview and Game objects as argument
    private void pickASide(TextView question, Game game){
        //takes chosen side and inserts the string into argument for port_or_starboard
        String chosenSide = String.format(getResources().getString(R.string.port_or_starboard), game.getChosenSideName());
        //sets the text
        question.setText(chosenSide);
    }

    //Purpose:Creates a toast and logs in to logCat
    //Accepts two string.xml id's, and a string for the side
    public void toastLog(int msg1, int msg2, String side){
        Toast.makeText(getApplicationContext(), msg1, Toast.LENGTH_SHORT).show();
        String logText = String.format(getResources().getString(msg2), side);
        Log.i(TAG, logText);
    }

    //Purpose: overloaded function of toastLog, accepts only 1 string resource and creates both a Toast and log of it
    public void toastLog(int msg1){
        toastLog(msg1, msg1, "");
    }
//---------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PortStarboardGame = new Game();
        setContentView(R.layout.activity_main);
        final TextView quizQuest = (TextView) findViewById(R.id.questionCont);
        //pick a side to start
        pickASide(quizQuest, PortStarboardGame);

        //Create left button to show Left
        Button leftbtn = (Button) findViewById(R.id.leftNameBtn);
        //...set up the button to toast when user clicks
        leftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //log and toast
                toastLog(R.string.showPort);
            }
        });

        //Create right button to show Right
        Button rightbtn = (Button) findViewById(R.id.rightNameBtn);
        //...set up the button to toast when user clicks
        rightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastLog(R.string.showStarboard);
            }
        });

        //Left answer button (Port)
        Button leftAnswer = (Button) findViewById(R.id.leftAnsBtn);
        //user clicks one to indicate the game's currently chosen side
        leftAnswer.setOnClickListener(new View.OnClickListener() {
            String gameSide = PortStarboardGame.getChosenSideName();
            @Override
            public void onClick(View v) {
                String gameSide = PortStarboardGame.getChosenSideName();
                //checks if the side is PORT
                if (PortStarboardGame.checkIfCorrect(Game.Side.PORT)){
                    //if yes..
                    //print Toast and log correct answer
                    toastLog(R.string.correct, R.string.logCorrect, gameSide);
                }else{
                    //if not...
                    //print Toast and log that the user guessed wrong
                    toastLog(R.string.incorrect, R.string.logIncorrect, gameSide);
                }
                //set up a new game
                PortStarboardGame = new Game();
                pickASide(quizQuest, PortStarboardGame);
            }
        });

        //Right answer button (Starboard)
        Button rightAnswer = (Button) findViewById(R.id.rightAnsBtn);
        rightAnswer.setOnClickListener(new View.OnClickListener() {
            String gameSide = PortStarboardGame.getChosenSideName();
            @Override
            public void onClick(View v) {
                String gameSide = PortStarboardGame.getChosenSideName();
                //if Side is Starboard,
                if (PortStarboardGame.checkIfCorrect(Game.Side.STARBOARD)){
                    //Toast and log correct
                    toastLog(R.string.correct, R.string.logCorrect, gameSide);
                //else if side isn't Starboard
                }else{
                    //Toast and log that it's incorrect
                    toastLog(R.string.incorrect, R.string.logIncorrect, gameSide);
                }
                //set up a new game
                PortStarboardGame = new Game();
                pickASide(quizQuest, PortStarboardGame);
            }
        });
    }}