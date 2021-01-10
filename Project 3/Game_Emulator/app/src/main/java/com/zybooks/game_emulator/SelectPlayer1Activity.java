package com.zybooks.game_emulator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static android.R.layout.simple_list_item_1;

public class SelectPlayer1Activity extends AppCompatActivity {
    private ArrayList<String> mPlayerNames =  new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView playerList;
    private Button savePlayerBtn;
    private EditText playerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player1);

        playerList = (ListView) findViewById(R.id.nameList);
        savePlayerBtn = (Button) findViewById(R.id.savePlayer);
        playerName = (EditText) findViewById(R.id.player1Name);

        adapter = new ArrayAdapter<String>(this, simple_list_item_1, mPlayerNames);
        playerList.setAdapter(adapter);


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
            for(String playerName: playerNames) {
                mPlayerNames.add(playerName);
            }

            adapter.notifyDataSetChanged();

            savePlayerBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String text = playerName.getText().toString();
                    Intent intent = new Intent(SelectPlayer1Activity.this, SelectPlayer2Activity.class);
                    intent.putExtra("Player1Name", text);
                    startActivity(intent);
                }
            });
        }
    }
}
