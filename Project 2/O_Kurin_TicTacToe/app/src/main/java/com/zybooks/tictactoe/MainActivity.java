package com.zybooks.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public boolean playerTurn = true;
    // All the possible win combinations represented with positions in 9*9 table
    public String[] winCombinations = {"012","345","678", "036", "147", "258","048", "246"};
    public int[] arrayBoard;
    public int winner = -1;
    //Checking if the game is over
    public boolean checkIfEnd(){
        boolean flag = false;
        int i = 0;
        while(i< arrayBoard.length){
            if(arrayBoard[i] == -1) {
                flag = true;
                break;
            }
            i++;
        }
        return flag;
    }
    public void computerMove(){
        int randomNumber = 0;
        //checking if all occupied
        boolean flag = checkIfEnd();
        if (!flag) {
            this.winner = 2;
            Toast.makeText(this, "GAME TIE", Toast.LENGTH_SHORT).show();
        }
        else {
            do {
                // Random number between 0-8 for Computer move
                double randomNumberD = (Math.random() * 8);
                randomNumber = (int) randomNumberD;
            } while (this.arrayBoard[randomNumber] != -1);

            ImageView circle;
            if (this.arrayBoard[randomNumber] == -1) {
                switch (randomNumber) {
                    case 0:
                        circle = (ImageView) findViewById(R.id.imageView11_circle);
                        circle.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
                        break;
                    case 1:
                        circle = (ImageView) findViewById(R.id.imageView12_circle);
                        circle.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
                        break;
                    case 2:
                        circle = (ImageView) findViewById(R.id.imageView13_circle);
                        circle.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
                        break;
                    case 3:
                        circle = (ImageView) findViewById(R.id.imageView21_circle);
                        circle.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
                        break;
                    case 4:
                        circle = (ImageView) findViewById(R.id.imageView22_circle);
                        circle.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
                        break;
                    case 5:
                        circle = (ImageView) findViewById(R.id.imageView23_circle);
                        circle.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
                        break;
                    case 6:
                        circle = (ImageView) findViewById(R.id.imageView31_circle);
                        circle.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
                        break;
                    case 7:
                        circle = (ImageView) findViewById(R.id.imageView32_circle);
                        circle.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
                        break;
                    case 8:
                        circle = (ImageView) findViewById(R.id.imageView33_circle);
                        circle.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
                        break;
                    default:
                        break;
                }
            }
            arrayBoard[randomNumber] = 0;
            playerTurn = !playerTurn;
            check();

        }
        if (this.winner != -1) {
            Button playAgain = (Button) findViewById(R.id.button);
            playAgain.animate().alpha(1.0f).setDuration(1000L);
            playAgain.setOnClickListener(onClickListener);
            return;
        }

    }
    public void check(){
        int sumOfCircles = 0;
        int sumOfCrosses = 0;
        for (String combination : winCombinations){
            for (int place = 0; place < combination.length(); place++){
                int sign = arrayBoard[Integer.parseInt(String.valueOf(combination.charAt(place)))];
                if (sign == -1) {
                    sumOfCircles = 0;
                    sumOfCrosses = 0;
                    break;
                } else if (sign == 0){
                    sumOfCircles++;
                } else sumOfCrosses++;
            }
            if(sumOfCircles>=3){
                this.winner = 0;
                Toast.makeText(this, "Computer Won", Toast.LENGTH_SHORT).show();
                return;
            } else if (sumOfCrosses>=3){
                this.winner = 1;
                Toast.makeText(this, "Player Won", Toast.LENGTH_SHORT).show();
                return;
            }

            sumOfCrosses = 0;
            sumOfCircles = 0;
        }


    }
    public void playAgain(int id){
        ImageView sign = (ImageView) findViewById(id);
        sign.animate().alpha(0.0f).setDuration(1000L);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        // For ImageViews
        @Override
        public void onClick(View v) {
            // disappear all
            playAgain(R.id.imageView11_cross);
            playAgain(R.id.imageView11_circle);
            playAgain(R.id.imageView12_cross);
            playAgain(R.id.imageView12_circle);
            playAgain(R.id.imageView13_cross);
            playAgain(R.id.imageView13_circle);
            playAgain(R.id.imageView21_cross);
            playAgain(R.id.imageView21_circle);
            playAgain(R.id.imageView22_cross);
            playAgain(R.id.imageView22_circle);
            playAgain(R.id.imageView23_cross);
            playAgain(R.id.imageView23_circle);
            playAgain(R.id.imageView31_cross);
            playAgain(R.id.imageView31_circle);
            playAgain(R.id.imageView32_cross);
            playAgain(R.id.imageView32_circle);
            playAgain(R.id.imageView33_cross);
            playAgain(R.id.imageView33_circle);
            winner = -1;
            playerTurn = true;
            for (int i = 0; i < arrayBoard.length; i++){
                arrayBoard[i] = -1;
            }
            Button playAgain = (Button) findViewById(R.id.button);
            playAgain.animate().alpha(0.0f).setDuration(1000L);
        }
    };
    public void step(int place, int mean){
        arrayBoard[place] = mean;
        playerTurn = !playerTurn;

        //checking + check if not step! for user
        check();
        if (this.winner != -1) {
            Button playAgain = (Button) findViewById(R.id.button);
            playAgain.animate().alpha(1.0f).setDuration(1000L);
            playAgain.setOnClickListener(onClickListener);
            return;
        }
        computerMove();
    }
    public void firstRow1(View view) {
        if (playerTurn) {
            if (this.winner != -1) return;
            if (arrayBoard[0] != -1) return;
            ImageView cross = (ImageView) findViewById(R.id.imageView11_cross);
            cross.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
            step(0, 1);
        }
    }
    public void firstRow2(View view){
        if (playerTurn) {
            if (this.winner != -1) return;
            if (arrayBoard[1] != -1) return;
            ImageView cross = (ImageView) findViewById(R.id.imageView12_cross);
            cross.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
            step(1, 1);
        }
    }
    public void firstRow3(View view){
        if(playerTurn){
            if (this.winner != -1) return;
            if (arrayBoard[2] != -1) return;
            ImageView cross = (ImageView) findViewById(R.id.imageView13_cross);
            cross.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
            step(2, 1);
        }
    }
    public void secondRow1(View view){
        if(playerTurn){
            if (this.winner != -1) return;
            if (arrayBoard[3] != -1) return;
            ImageView cross = (ImageView) findViewById(R.id.imageView21_cross);
            cross.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
            step(3, 1);
        }
    }
    public void secondRow2(View view){
        if(playerTurn){
            if (this.winner != -1) return;
            if (arrayBoard[4] != -1) return;
            ImageView cross = (ImageView) findViewById(R.id.imageView22_cross);
            cross.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
            step( 4, 1);
        }
    }
    public void secondRow3(View view){
        if(playerTurn){
            if (this.winner != -1) return;
            if (arrayBoard[5] != -1) return;
            ImageView cross = (ImageView) findViewById(R.id.imageView23_cross);
            cross.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
            step(5, 1);
        }
    }
    public void thirdRow1(View view){
        if(playerTurn){
            if (this.winner != -1) return;
            if (arrayBoard[6] != -1) return;
            ImageView cross = (ImageView) findViewById(R.id.imageView31_cross);
            cross.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
            step(6, 1);
        }
    }
    public void thirdRow2(View view){
        if(playerTurn){
            if (this.winner != -1) return;
            if (arrayBoard[7] != -1) return;
            ImageView cross = (ImageView) findViewById(R.id.imageView32_cross);
            cross.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
            step(7, 1);
        }
    }
    public void thirdRow3(View view){
        if(playerTurn){
            if (this.winner != -1) return;
            if (arrayBoard[8] != -1) return;
            ImageView cross = (ImageView) findViewById(R.id.imageView33_cross);
            cross.animate().alpha(1.0f).rotation(360f).setDuration(2000L);
            step(8, 1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.arrayBoard = new int[9];
        for (int i = 0; i < this.arrayBoard.length; i++){
            this.arrayBoard[i] = -1;
        }
    }
}