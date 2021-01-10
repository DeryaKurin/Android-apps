package com.zybooks.lotterygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPick4Click(View view) {
        Intent intent = new Intent(this, Pick4Activity.class);
        startActivity(intent);
    }

    public void onPBClick(View view) {
        Intent intent = new Intent(this, PowerBallActivity.class);
        startActivity(intent);
    }

    public void onClickPlay(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
}