package com.zybooks.lotterygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Collections;


public class PlayActivity extends AppCompatActivity {
    private String [] pick4Ball  = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private String[] powerBall = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
            "14", "15", "16", "17", "18", "19", "20","21", "22", "23", "24", "25", "26" };

    private String[] rand5Number = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20","21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40","41", "42", "43", "44", "45", "46",
            "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
            "61", "62", "63", "64", "65", "66", "67", "68", "69"};

    // Winning Numbers
    private EditText pick4Result;
    private EditText pbResult;
    private EditText pbResult2;

    //Number of tickets matching the winning numbers
    private EditText pick4TicketResult;
    private EditText pbticketResult;

    //Game result
    private EditText gameResult;

    //Fields to hold Pick 4 guesses and the winning number
    private String pickLine1 = "";
    private String pickLine2 = "";
    private String pickLine3 = "";
    private String randomPick4 ="";

    //Fields to hold PowerBall guesses and the winning number
    private String pBLine1 = "";
    private String pBLine2 = "";
    private String pBLine3 = "";
    String randomPBall = "";
    String pb = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        pick4Result = (EditText)findViewById(R.id.pick4Result);
        pbResult = (EditText)findViewById(R.id.pbResult);
        pbResult2 = (EditText)findViewById(R.id.pbResult2);
        pick4TicketResult = (EditText)findViewById(R.id.pick4TicketResult);
        pbticketResult = (EditText)findViewById(R.id.pbticketResult);
        gameResult = (EditText)findViewById(R.id.gameResult);



        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();

            if(extras == null) {
                //Guesses from Pick4
                pickLine1= null;
                pickLine2= null;
                pickLine3= null;

                //Guesses from PowerBall
                pBLine1 = null;
                pBLine2 = null;
                pBLine3 = null;

            } else {
                pickLine1= extras.getString("pick4Line1");
                pickLine2= extras.getString("pick4Line2");
                pickLine3= extras.getString("pick4Line3");

                pBLine1 = extras.getString("pBLine1");
                pBLine2 = extras.getString("pBLine2");
                pBLine3 = extras.getString("pBLine3");
        }
        } else {
            pickLine1 = (String) savedInstanceState.getSerializable("pick4Line1");
            pickLine2 = (String) savedInstanceState.getSerializable("pick4Line2");
            pickLine3 = (String) savedInstanceState.getSerializable("pick4Line3");

            pBLine1 = (String) savedInstanceState.getSerializable("pBLine1");
            pBLine2 = (String) savedInstanceState.getSerializable("pBLine2");
            pBLine3 = (String) savedInstanceState.getSerializable("pBLine3");
        }



        //Saving winning pick4 numbers and setting its view
        randomPick4 = random4();
        pick4Result.setText(randomPick4);

        //Saving winning powerball numbers and setting its view - 5 white balls

        randomPBall = random5Ball();
        pbResult.setText(randomPBall);

        //Setting winning PowerBall and its view
        pb = randomPBNo();
        pbResult2.setText(pb);

        int resultP4 = winningTicketsP4(randomPick4, pickLine1, pickLine2, pickLine3);
        pick4TicketResult.setText(String.valueOf(resultP4));

        int pbRes =  winningTicketsPB(randomPBall, pb, pBLine1, pBLine2, pBLine3);
        pbticketResult.setText(String.valueOf(pbRes));


        double winAmount = winningAmount(resultP4, pbRes);
        gameResult.setText("$" + String.valueOf(winAmount));

//        Toast.makeText(this, randomPBall.toString(),
//        Toast.LENGTH_LONG).show();
    }


    public String random4() {
        //Shuffle the list to get random numbers
        Collections.shuffle(Arrays.asList(pick4Ball));

        String rand4 = "";
        //First 4 numbers are 5 balls
        rand4 += pick4Ball[0];
        rand4 += pick4Ball[1];
        rand4 += pick4Ball[2];
        rand4 += pick4Ball[3];

        return rand4;
    }


    public String random5Ball() {
        //Shuffle the list to get random numbers
        Collections.shuffle(Arrays.asList(rand5Number));

        String rand5 = "";
        //First 5 numbers are 5 white balls
        rand5 += rand5Number[0] + " ";
        rand5 += rand5Number[1] + " ";
        rand5 += rand5Number[2] + " ";
        rand5 += rand5Number[3] + " ";
        rand5 += rand5Number[4] + "";

        return rand5;
    }

    public String randomPBNo() {
        //Shuffle the list to get random numbers
        Collections.shuffle(Arrays.asList(powerBall));
        // Last number is PowerBall
        return powerBall[0];
    }

    // Checking if the winning numbers are contained by any powerBall numbers in any order
    public int winningTicketsP4(String winningPick4, String p4Line1, String p4Line2, String p4Line3) {
        int noOfTickets = 0;

        //Converting String into a String Array
        String[] winningP4 = winningPick4.split("");

        String[] line1 = p4Line1.split("");
        String[] line2 = p4Line2.split("");
        String[] line3 = p4Line3.split("");

        //Sorting all the arrays
        Arrays.sort(winningP4);
        Arrays.sort(line1);
        Arrays.sort(line2);
        Arrays.sort(line3);

        //If they contain the same characters(numbers) they will return true
        if(Arrays.equals(winningP4, line1)) {
            noOfTickets++;
        }

        if(Arrays.equals(winningP4, line2)) {
            noOfTickets++;
        }

        if(Arrays.equals(winningP4, line3)) {
            noOfTickets++;
        }

        return noOfTickets;
    }


    // Checking if the winning numbers are contained by any powerBall numbers in any order
    public int winningTicketsPB(String winningPB, String pb, String pBLine1, String pBLine2, String pBLine3) {
        int noOfTickets = 0;

        //Converting String into a String Array
        String[] winning5ball = winningPB.split(" ");

        String[] pBline1 = pBLine1.split(" ");
        String[] pBline2 = pBLine2.split(" ");
        String[] pBline3 = pBLine3.split(" ");

        //Storing 3 powerball guesses
        String line1PB = pBline1[pBline1.length - 1];
        String line2PB = pBline2[pBline2.length - 1];
        String line3PB = pBline3[pBline3.length - 1];

        //Removing the last element: powerballs from lines
        pBline1 = Arrays.copyOf(pBline1, pBline1.length - 1);
        pBline2 = Arrays.copyOf(pBline2, pBline2.length - 1);
        pBline3 = Arrays.copyOf(pBline3, pBline3.length - 1);


        //Sorting all the arrays
        Arrays.sort(winning5ball);
        Arrays.sort(pBline1);
        Arrays.sort(pBline2);
        Arrays.sort(pBline3);

        //If they contain the same characters(numbers) they will return true
        if(Arrays.equals(winning5ball, pBline1) && pb.equals(line1PB)) {
            noOfTickets++;
        }

        if(Arrays.equals(winning5ball, pBline2) && pb.equals(line2PB)) {
            noOfTickets++;
        }

        if(Arrays.equals(winning5ball, pBline3) && pb.equals(line3PB)) {
            noOfTickets++;
        }

        return noOfTickets;
    }

    public double winningAmount(int p4, int pB) {
        double amount = 0;
        amount += (p4 * 20000) + (pB * 1000000);
        return amount;
    }
}