package com.zybooks.game_emulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.Person;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.xml.transform.Templates;

import static android.R.layout.simple_list_item_1;

public class ScoreBoardActivity extends AppCompatActivity {
    private ArrayList<String> mPlayers = new ArrayList<String>();

    private int maxIndex1 = 0;
    private int maxIndex2 = 0;
    private int maxIndex3 = 0;
    private int max = 0;


    private TextView player1;
    private TextView player2;
    private TextView player3;
    private TextView player1wins;
    private TextView player2wins;
    private TextView player3wins;
    private TextView player1losses;
    private TextView player2losses;
    private TextView player3losses;
    private TextView player1ties;
    private TextView player2ties;
    private TextView player3ties;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        player1 = (TextView) findViewById(R.id.player1);
        player2 = (TextView) findViewById(R.id.player2);
        player3 = (TextView) findViewById(R.id.player3);
        player1wins = (TextView) findViewById(R.id.winsP1);
        player2wins = (TextView) findViewById(R.id.winsP2);
        player3wins = (TextView) findViewById(R.id.winsP3);
        player1losses = (TextView) findViewById(R.id.lossesP1);
        player2losses = (TextView) findViewById(R.id.lossesP2);
        player3losses = (TextView) findViewById(R.id.lossesP3);
        player1ties = (TextView) findViewById(R.id.tiesP1);
        player2ties = (TextView) findViewById(R.id.tiesP2);
        player3ties = (TextView) findViewById(R.id.tiesP3);




        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        Map<String, String> names = (Map<String, String>) sharedPreferences.getAll();
        //  Store the json objects
        ArrayList<Player> playerList  = new ArrayList<>();
        ArrayList<String> players = new ArrayList<>();
        ArrayList<String> playerNames = new ArrayList<>();

        if (names != null) {
            for (String value : names.values()) {
                JSONObject reader = null;
                try {
                    reader = new JSONObject(value);
                    players.add(value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    playerNames.add(reader.getString("name"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            for(String name: playerNames) {
                    // Getting values fro shared preferences to set PlayerOne and PlayerTwo
                    SharedPreferences prfs = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                    // Store the json objects
                    String playerJson = prfs.getString(name, "");
                    //Convert json to Player object
                    Gson gson = new Gson();
                    Player player = new Player();
                    player = gson.fromJson(playerJson, Player.class);
                    playerList.add(player);
            }
        }


        //First place
        max = 0;
        for(int i = 0; i < playerList.size(); i ++) {
            if(playerList.get(i).getTotalScore() > max) {
                max = i;
            }
        }

        maxIndex1 = max;
        player1.setText(playerList.get(maxIndex1).getName());
        player1wins.setText(Integer.toString(playerList.get(maxIndex1).getWins()));
        player1losses.setText(Integer.toString(playerList.get(maxIndex1).getLosses()));
        player1ties.setText(Integer.toString(playerList.get(maxIndex1).getTies()));
        playerList.remove(maxIndex1);

        //Second Place
        max = 0;
        for(int i = 0; i < playerList.size(); i ++) {
            if(playerList.get(i).getTotalScore() > max) {
                max = i;
            }
        }

        maxIndex2 = max;
        player2.setText(playerList.get(maxIndex2).getName());
        player2wins.setText(Integer.toString(playerList.get(maxIndex2).getWins()));
        player2losses.setText(Integer.toString(playerList.get(maxIndex2).getLosses()));
        player2ties.setText(Integer.toString(playerList.get(maxIndex2).getTies()));
        playerList.remove(maxIndex2);


        //Third Place
        max = 0;
        for(int i = 0; i < playerList.size(); i ++) {
            if(playerList.get(i).getTotalScore() > max) {
                max = i;
            }
        }

        maxIndex3 = max;
        player3.setText(playerList.get(maxIndex3).getName());
        player3wins.setText(Integer.toString(playerList.get(maxIndex3).getWins()));
        player3losses.setText(Integer.toString(playerList.get(maxIndex3).getLosses()));
        player3ties.setText(Integer.toString(playerList.get(maxIndex3).getTies()));
        playerList.remove(maxIndex3);
        }
}


