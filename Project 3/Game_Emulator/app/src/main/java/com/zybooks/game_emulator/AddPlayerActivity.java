package com.zybooks.game_emulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class AddPlayerActivity extends AppCompatActivity {
    private ArrayList<Player> players;
    private String name;
    private EditText text;
    private Button addPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        text = (EditText) findViewById(R.id.playerName);
        addPlayer = (Button) findViewById(R.id.addPlayer);

        addPlayer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = getSharedPreferences("shared_pref", MODE_PRIVATE).edit();
                SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE);
                Map<String, String> names = (Map<String, String>) sharedPreferences.getAll();

                ArrayList<String> playerNames = new ArrayList<>();
                if (names != null) {
                    for (String value : names.values()) {
                        JSONObject reader = null;
                        try {
                            reader = new JSONObject(value);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            playerNames.add(reader.getString("name"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    Gson gson = new Gson();
                    Player player = new Player(text.getText().toString());
                    String json = gson.toJson(player);

                    editor.putString(text.getText().toString(), json);
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(),
                            SelectPlayer1Activity.class);
                    startActivity(intent);
                }

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getSharedPreferences("shared_pref", MODE_PRIVATE).edit().clear().commit();
    }

}
