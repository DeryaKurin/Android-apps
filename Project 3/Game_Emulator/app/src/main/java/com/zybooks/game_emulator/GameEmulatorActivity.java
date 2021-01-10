package com.zybooks.game_emulator;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class GameEmulatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;
    private int player1Points;
    private int player2Points;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    public static TextView player1;
    public static TextView player2;
    private Button Select1btn;
    private Button Select2btn;
    //Adding fields for Player records:
    private static Player playerOne;
    private static Player playerTwo;
    private String player1Name;
    private String player2Name;
    private Integer p1Wins;
    private Integer p2Wins;
    private Integer p1Losses;
    private Integer p2Losses;
    private Integer p1Ties;
    private Integer p2Ties;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_emulator);
        Select1btn = findViewById(R.id.Select1btn);
        Select2btn = findViewById(R.id.Select2btn);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });


        if (player1.getText().equals("Choose a Player") || player2.getText().equals("Choose a Player")) {
            Intent intent = getIntent();
            player1Name = intent.getStringExtra("Player1Name");
            player2Name = intent.getStringExtra("Player2Name");
            //Setting players names
            if (player1Name != null) {
                player1.setText(player1Name);
                Select1btn.setVisibility(View.GONE);
            }
            if (player2Name != null) {
                player2.setText(player2Name);
                Select2btn.setVisibility(View.GONE);
            }
        }

        if(player1Name != null && player2Name != null) {
            // Getting values fro shared preferences to set PlayerOne and PlayerTwo
            SharedPreferences prfs = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
            // Store the json objects
            String player1Json = prfs.getString(player1Name, "");
            String player2Json = prfs.getString(player2Name, "");
            //Convert json to Player object
            Gson gson = new Gson();
            playerOne = gson.fromJson(player1Json, Player.class);
            playerTwo = gson.fromJson(player2Json, Player.class);
        }

    }


    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (player1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }
        roundCount++;
        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }
    private boolean checkForWin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }
        return false;
    }
    private void player1Wins() {
        player1Points++;
        //Set wins for player 1
        playerOne.setWins(playerOne.getWins() + 1);
        playerOne.setTotalScore();
        playerTwo.setLosses(playerTwo.getLosses() +1);
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void player2Wins() {
        player2Points++;
        //Set wins for player 2
        //Add to previous scores
        playerTwo.setWins(playerTwo.getWins() + 1);
        playerOne.setLosses(playerOne.getLosses() +1);
        //Update total score
        playerTwo.setTotalScore();
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        //Add to previous ties
        playerOne.setTies(playerOne.getTies() + 1);
        playerTwo.setTies(playerTwo.getTies() + 1);
        playerOne.setTotalScore();
        playerTwo.setTotalScore();
        resetBoard();
    }
    private void updatePointsText() {
        textViewPlayer1.setText("Player 1: " + player1Points);
        textViewPlayer2.setText("Player 2: " + player2Points);
    }
    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        roundCount = 0;
        player1Turn = true;
    }
    private void resetGame() {
        //Before resetting the points update the info in Shared Preferences
        player1Points = 0;
        player2Points = 0;
        updatePointsText();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("player1Turn", player1Turn);
        outState.putString("player1Name", player1Name);
        outState.putString("player2Name", player2Name);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        roundCount = savedInstanceState.getInt("roundCount");
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        player1Turn = savedInstanceState.getBoolean("player1Turn");
        player1Name = savedInstanceState.getString("player1Name");
        player2Name = savedInstanceState.getString("player2Name");
    }

    public void onScoreBoardClick(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        //Java object to JSON string
        String jsonPlayer1 = gson.toJson(playerOne);
        String jsonPlayer2 = gson.toJson(playerTwo);
        // Edit Shared Preferences
        editor.putString(player1Name, jsonPlayer1);
        editor.putString(player2Name, jsonPlayer2);
        //Commit changes
        editor.commit();

        Intent intent = new Intent(this, ScoreBoardActivity.class);
        startActivity(intent);
    }

    public void onSelectPlayer1Click(View view) {
        Intent intent2 = new Intent(this, SelectPlayer1Activity.class);
        startActivity(intent2);
    }

    public void onSelectPlayer2Click(View view) {
        Intent intent3 = new Intent(this, SelectPlayer2Activity.class);
        startActivity(intent3);
    }
}