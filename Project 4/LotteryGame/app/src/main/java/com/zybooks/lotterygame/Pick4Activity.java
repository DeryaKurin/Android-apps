package com.zybooks.lotterygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pick4Activity extends AppCompatActivity {
    private String [] pick4 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private EditText firstNo1, secondNo1, thirdNo1, fourthNo1,
            firstNo2, secondNo2, thirdNo2, fourthNo2,
            firstNo3, secondNo3, thirdNo3, fourthNo3;

    private Button buttonRandom1, buttonRandom2, buttonRandom3, buttonPurchase, buttonPurchaseAndPlay;

    private String pick4Line1 = "";
    private String pick4Line2 = "";
    private String pick4Line3 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick4);
        bindViews();

        buttonRandom1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                generateRandomL1();
            }
        });

        buttonRandom2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                generateRandomL2();
            }
        });

        buttonRandom3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                generateRandomL3();
            }
        });

        buttonPurchaseAndPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                saveAndPlayPB();
            }
        });
    }


    public void generateRandomL1() {
        //Shuffle the list to get random numbers
        Collections.shuffle(Arrays.asList(pick4));
        firstNo1.setText(pick4[0]);
        secondNo1.setText(pick4[1]);
        thirdNo1.setText(pick4[2]);
        fourthNo1.setText(pick4[3]);
    }

    public void generateRandomL2() {
        Collections.shuffle(Arrays.asList(pick4));
        firstNo2.setText(pick4[0]);
        secondNo2.setText(pick4[1]);
        thirdNo2.setText(pick4[2]);
        fourthNo2.setText(pick4[3]);
    }

    public void generateRandomL3() {
        Collections.shuffle(Arrays.asList(pick4));
        firstNo3.setText(pick4[0]);
        secondNo3.setText(pick4[1]);
        thirdNo3.setText(pick4[2]);
        fourthNo3.setText(pick4[3]);
    }

    public void saveAndPlayPB() {
        Intent intent  = new Intent(Pick4Activity.this, PowerBallActivity.class);
        // Storing numbers in arrayLists per line

        pick4Line1 += firstNo1.getText().toString();
        pick4Line1 += secondNo1.getText().toString();
        pick4Line1 += thirdNo1.getText().toString();
        pick4Line1 += fourthNo1.getText().toString();

        pick4Line2 += firstNo2.getText().toString();
        pick4Line2 += secondNo2.getText().toString();
        pick4Line2 += thirdNo2.getText().toString();
        pick4Line2 += fourthNo2.getText().toString();

        pick4Line3 += firstNo3.getText().toString();
        pick4Line3 += secondNo3.getText().toString();
        pick4Line3 += thirdNo3.getText().toString();
        pick4Line3 += fourthNo3.getText().toString();

        intent.putExtra("pick4Line1", pick4Line1);
        intent.putExtra("pick4Line2", pick4Line2);
        intent.putExtra("pick4Line3", pick4Line3);

        startActivity(intent);
    }


    public void bindViews() {
        firstNo1 = (EditText)findViewById(R.id.firstNo1);
        secondNo1 = (EditText)findViewById(R.id.secondNo1);
        thirdNo1 = (EditText)findViewById(R.id.thirdNo1);
        fourthNo1 = (EditText)findViewById(R.id.fourthNo1);
        firstNo2 = (EditText)findViewById(R.id.firstNo2);
        secondNo2 = (EditText)findViewById(R.id.secondNo2);
        thirdNo2 = (EditText)findViewById(R.id.thirdNo2);
        fourthNo2 = (EditText)findViewById(R.id.fourthNo2);
        firstNo3 = (EditText)findViewById(R.id.firstNo3);
        secondNo3 = (EditText)findViewById(R.id.secondNo3);
        thirdNo3 = (EditText)findViewById(R.id.thirdNo3);
        fourthNo3 = (EditText)findViewById(R.id.fourthNo3);
        buttonRandom1 = (Button)findViewById(R.id.buttonRandom1);
        buttonRandom2 = (Button)findViewById(R.id.buttonRandom2);
        buttonRandom3 = (Button)findViewById(R.id.buttonRandom3);
        buttonPurchase = (Button)findViewById(R.id.buttonPurchase);
        buttonPurchaseAndPlay = (Button)findViewById(R.id.saveAndPlayPB);
    }

}