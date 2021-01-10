package com.zybooks.cmsc234_project1_piggy_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText quarter;
    private EditText dime;
    private EditText nickel;
    private EditText penny;
    private EditText totalMoney;
    private EditText saveOrSpent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Initialize class properties with by registering them with their associated ids.
        quarter = (EditText) findViewById(R.id.quarters);
        dime = (EditText) findViewById(R.id.dimes);
        nickel = (EditText) findViewById(R.id.nickels);
        penny = (EditText) findViewById(R.id.pennies);
        totalMoney = (EditText) findViewById(R.id.total_money);
        saveOrSpent = (EditText) findViewById(R.id.money_to_save_or_spend);
    }

    //Event Handler Method
    public void onClick(View view) {
        //create a switch statement to handle events for the two buttons
        switch(view.getId()) {
            //In case Calculate Total button is clicked:
            case R.id.button1:

                int quarters =  Integer.parseInt(quarter.getText().toString());
                int dimes =  Integer.parseInt(dime.getText().toString());
                int nickels =  Integer.parseInt(nickel.getText().toString());
                int pennies =  Integer.parseInt(penny.getText().toString());

                // Set the total amount to the Total EditText field

                totalMoney.setText(String.valueOf(CalculationUtil.sum(quarters, dimes, nickels, pennies)));
                break;

            case R.id.button2:
                RadioButton spending = (RadioButton) findViewById(R.id.rb_spend);
                RadioButton saving = (RadioButton) findViewById((R.id.rb_save));

                double total = Double.parseDouble(totalMoney.getText().toString());
                double saveOrSpend = Double.parseDouble(saveOrSpent.getText().toString());

                if(spending.isChecked()) {
                    //Set the Total Amount after subtraction
                    if(spending.getText().length() != 0) {
                        totalMoney.setText(String.valueOf(CalculationUtil.subtract(total, saveOrSpend)));
                    } else {
                        if(saving.getText().length() == 0) {
                            Toast.makeText(this, "Please enter an amount to spend!",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }
                    }

                    break;

                } else if(saving.isChecked()) {
                    // Set the Total Amount after adding
                    if(saving.getText().length() != 0) {
                        totalMoney.setText(String.valueOf(CalculationUtil.add(total, saveOrSpend)));
                    } else {
                        if(saving.getText().length() == 0) {
                            Toast.makeText(this, "Please enter an amount to save!",
                                    Toast.LENGTH_LONG).show();
                            return;
                        }
                    }

                    break;
                }


        }
    }
}