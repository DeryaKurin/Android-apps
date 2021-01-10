package com.zybooks.game_emulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartGameClick(View view) {
        Intent intent1 = new Intent(this, GameEmulatorActivity.class);
        startActivity(intent1);
    }


    public void onAddPlayerClick(View view) {
        Intent intent2 = new Intent(this, AddPlayerActivity.class);
        startActivity(intent2);
    }

    public void onSelectPlayer1Click(View view) {
        Intent intent3 = new Intent(this, SelectPlayer1Activity.class);
        startActivity(intent3);
    }

    public void onSelectPlayer2Click(View view) {
        Intent intent4 = new Intent(this, SelectPlayer2Activity.class);
        startActivity(intent4);
    }

    public void onScoreBoardClick(View view) {
        Intent intent4 = new Intent(this, ScoreBoardActivity.class);
        startActivity(intent4);
    }


}