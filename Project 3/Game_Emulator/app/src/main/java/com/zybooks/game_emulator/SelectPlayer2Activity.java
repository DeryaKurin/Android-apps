package com.zybooks.game_emulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import static android.R.layout.simple_list_item_1;

public class SelectPlayer2Activity extends AppCompatActivity {
    private ArrayList<String> mPlayerNames =  new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView playerList;
    private Button savePlayerBtn;
    private EditText player2Name;
    private String player1Name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player2);

        playerList = (ListView) findViewById(R.id.nameList);
        savePlayerBtn = (Button) findViewById(R.id.savePlayer);
        player2Name = (EditText) findViewById(R.id.player2Name);

        adapter = new ArrayAdapter<String>(this, simple_list_item_1, mPlayerNames);
        playerList.setAdapter(adapter);

        //Getting Player 1 name and storing it in Player1Name
        Intent intent = getIntent();
        player1Name = intent.getStringExtra("Player1Name");


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
                    //Not showing the name chosen by Player 1
                    if(reader.getString("name").equals(player1Name)) {
                        continue;
                    } else {
                        playerNames.add(reader.getString("name"));
                    }
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
                    String text = player2Name.getText().toString();
                    Intent intent = new Intent(SelectPlayer2Activity.this, GameEmulatorActivity.class);
                    intent.putExtra("Player1Name", player1Name);
                    intent.putExtra("Player2Name", text);
                    startActivity(intent);
                }
            });
        }
    }
}
