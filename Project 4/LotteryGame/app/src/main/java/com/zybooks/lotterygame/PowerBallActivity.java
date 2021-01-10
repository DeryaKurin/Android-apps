package com.zybooks.lotterygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Arrays;
import java.util.Collections;

//Lottery Rules
//Select five numbers from 1 to 69
//One number from 1 to 26 for the red Powerball

public class PowerBallActivity<Adapter, adapter> extends AppCompatActivity {
    private String[] powerBall = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20","21", "22", "23", "24", "25", "26" };
    private String[] rand5Number = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20","21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40","41", "42", "43", "44", "45", "46",
            "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
            "61", "62", "63", "64", "65", "66", "67", "68", "69"};


    private EditText firstNo1, secondNo1, thirdNo1, fourthNo1, fifthNo1, sixthNo1,
            firstNo2, secondNo2, thirdNo2, fourthNo2, fifthNo2, sixthNo2,
            firstNo3, secondNo3, thirdNo3, fourthNo3, fifthNo3, sixthNo3;

    private Button buttonRandom1, buttonRandom2, buttonRandom3, buttonPurchase;

    //Strings to store 3 powerball guesses
    private String pBLine1 = "";
    private String pBLine2 = "";
    private String pBLine3 = "";


    //Strings to store pick 4 guesses:
    private String pickLine1 = "";
    private String pickLine2 = "";
    private String pickLine3 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_ball);
        bindViews();


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                //Guesses from Pick4
                pickLine1= null;
                pickLine2= null;
                pickLine3= null;


            } else {
                pickLine1= extras.getString("pick4Line1");
                pickLine2= extras.getString("pick4Line2");
                pickLine3= extras.getString("pick4Line3");
            }
        } else {
            pickLine1 = (String) savedInstanceState.getSerializable("pick4Line1");
            pickLine2 = (String) savedInstanceState.getSerializable("pick4Line2");
            pickLine3 = (String) savedInstanceState.getSerializable("pick4Line3");
        }

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

        buttonPurchase.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                purchase();
            }
        });
    }




    public void generateRandomL1() {
        //Shuffle the list to get random numbers
        Collections.shuffle(Arrays.asList(rand5Number));
        Collections.shuffle(Arrays.asList(powerBall));

        firstNo1.setText(rand5Number[0]);
        secondNo1.setText(rand5Number[1]);
        thirdNo1.setText(rand5Number[2]);
        fourthNo1.setText(rand5Number[3]);
        fifthNo1.setText(rand5Number[4]);
        sixthNo1.setText(powerBall[0]);
    }

    public void generateRandomL2() {
        //Shuffle the list to get random numbers
        Collections.shuffle(Arrays.asList(rand5Number));
        Collections.shuffle(Arrays.asList(powerBall));

        firstNo2.setText(rand5Number[0]);
        secondNo2.setText(rand5Number[1]);
        thirdNo2.setText(rand5Number[2]);
        fourthNo2.setText(rand5Number[3]);
        fifthNo2.setText(rand5Number[4]);
        sixthNo2.setText(powerBall[0]);
    }

    public void generateRandomL3() {
        //Shuffle the list to get random numbers
        Collections.shuffle(Arrays.asList(powerBall));
        Collections.shuffle(Arrays.asList(powerBall));

        firstNo3.setText(rand5Number[0]);
        secondNo3.setText(rand5Number[1]);
        thirdNo3.setText(rand5Number[2]);
        fourthNo3.setText(rand5Number[3]);
        fifthNo3.setText(rand5Number[4]);
        sixthNo3.setText(powerBall[0]);
    }

    public void purchase() {
        Intent intent  = new Intent(PowerBallActivity.this, PlayActivity.class);
        // Storing numbers in arrayLists per line
        pBLine1 += firstNo1.getText().toString() + " ";
        pBLine1 += secondNo1.getText().toString() + " ";
        pBLine1 += thirdNo1.getText().toString() + " ";
        pBLine1 += fourthNo1.getText().toString() + " ";
        pBLine1 += fifthNo1.getText().toString() + " ";
        pBLine1 += sixthNo1.getText().toString();

        pBLine2 += firstNo2.getText().toString() + " ";
        pBLine2 += secondNo2.getText().toString()+ " ";
        pBLine2 += thirdNo2.getText().toString()+ " ";
        pBLine2 += fourthNo2.getText().toString()+ " ";
        pBLine3 += fifthNo3.getText().toString()+ " ";
        pBLine3 += sixthNo3.getText().toString();

        pBLine3 += firstNo3.getText().toString()+ " ";
        pBLine3 += secondNo3.getText().toString()+ " ";
        pBLine3 += thirdNo3.getText().toString()+ " ";
        pBLine3 += fourthNo3.getText().toString()+ " ";
        pBLine3 += fifthNo3.getText().toString()+ " ";
        pBLine3 += sixthNo3.getText().toString();

        intent.putExtra("pBLine1", pBLine1);
        intent.putExtra("pBLine2", pBLine2);
        intent.putExtra("pBLine3", pBLine3);

        //Sending extras coming from Pick4 activity
        intent.putExtra("pick4Line1", pickLine1);
        intent.putExtra("pick4Line2", pickLine2);
        intent.putExtra("pick4Line3", pickLine3);

        startActivity(intent);
    }

    public void bindViews() {
        firstNo1 = (EditText)findViewById(R.id.firstNo1);
        secondNo1 = (EditText)findViewById(R.id.secondNo1);
        thirdNo1 = (EditText)findViewById(R.id.thirdNo1);
        fourthNo1 = (EditText)findViewById(R.id.fourthNo1);
        fifthNo1 = (EditText)findViewById(R.id.fifthNo1);
        sixthNo1 = (EditText)findViewById(R.id.sixthNo1);

        firstNo2 = (EditText)findViewById(R.id.firstNo2);
        secondNo2 = (EditText)findViewById(R.id.secondNo2);
        thirdNo2 = (EditText)findViewById(R.id.thirdNo2);
        fourthNo2 = (EditText)findViewById(R.id.fourthNo2);
        fifthNo2 = (EditText)findViewById(R.id.fifthNo2);
        sixthNo2 = (EditText)findViewById(R.id.sixthNo2);

        firstNo3 = (EditText)findViewById(R.id.firstNo3);
        secondNo3 = (EditText)findViewById(R.id.secondNo3);
        thirdNo3 = (EditText)findViewById(R.id.thirdNo3);
        fourthNo3 = (EditText)findViewById(R.id.fourthNo3);
        fifthNo3 = (EditText)findViewById(R.id.fifthNo3);
        sixthNo3 = (EditText)findViewById(R.id.sixthNo3);

        buttonRandom1 = (Button)findViewById(R.id.buttonRandom1);
        buttonRandom2 = (Button)findViewById(R.id.buttonRandom2);
        buttonRandom3 = (Button)findViewById(R.id.buttonRandom3);

        buttonPurchase = (Button)findViewById(R.id.buttonPurchase);
    }

}