package com.jaja.billsplitbeta;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class evenInput extends AppCompatActivity {
    //global variables
    public static double totalAmount = 0;
    public static int numPeople = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialize
        super.onCreate(savedInstanceState);
        setContentView(R.layout.even_input);

        //declare variables
        final Button personMinusButton = (Button) findViewById(R.id.decrementButton);
        final Button personPlusButton = (Button) findViewById(R.id.incrementButton);
        final EditText peopleNumberField = (EditText) findViewById(R.id.peopleNumber);
        final EditText totalValueField = (EditText) findViewById(R.id.totalValue);
        final Button resetButton = (Button) findViewById(R.id.resetButton);
        final Button nextButton = (Button) findViewById(R.id.nextButton);
        final Switch modeSwitch = (Switch) findViewById(R.id.modeSwitch);

        //display initial values
        modeSwitch.setVisibility(View.INVISIBLE);
        peopleNumberField.setText(String.valueOf(numPeople));
        totalValueField.setText(String.valueOf(totalAmount));

        //Button Actions
        personMinusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numPeople = Integer.parseInt(peopleNumberField.getText().toString());
                peopleNumberField.setTextColor(Color.BLACK);
                if (numPeople > 2) {
                    numPeople--;
                } else {
                    peopleNumberField.setTextColor(Color.RED);
                }
                peopleNumberField.setText(String.valueOf(numPeople));
            }
        });

        personPlusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                peopleNumberField.setTextColor(Color.BLACK);
                numPeople = Integer.parseInt(peopleNumberField.getText().toString());
                numPeople++;
                peopleNumberField.setText(String.valueOf(numPeople));
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numPeople = 3;
                totalAmount = 0;
                peopleNumberField.setText(String.valueOf(numPeople));
                totalValueField.setText(String.valueOf(totalAmount));
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() { //goto even result
            public void onClick(View v) {
                totalValueField.setTextColor(Color.BLACK);
                totalAmount = Double.parseDouble(totalValueField.getText().toString());
                if (totalAmount > 0) {
                    Intent transition = new Intent(evenInput.this, evenResult.class);
                    numPeople = Integer.parseInt(peopleNumberField.getText().toString());
                    startActivity(transition);
                } else {
                    totalValueField.setTextColor(Color.RED);
                    //The noob dev doesn't know how to send a message
                }
            }
        });
    }
}
