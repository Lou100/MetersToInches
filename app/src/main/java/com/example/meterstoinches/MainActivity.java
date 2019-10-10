package com.example.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Setting up strings to program buttons and text views
    private EditText metersEditText;
    private Button convertButtonId;
    private TextView resultId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* finding the buttons and text views in activity_main.xml and programming them in
        MainActivity.java
         */

        metersEditText = (EditText) findViewById(R.id.metersEditText);
        resultId = (TextView) findViewById(R.id.resultId);
        convertButtonId = (Button) findViewById(R.id.convertButtonId);

        convertButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Conversion formula from meters to inches
                // 1 meter is equal to 39.3701 inches
                double multiplier = 39.37d;
                double result = 0.0d;


                //If statement to prevent app from crashing if user enters no meters
                if (metersEditText.getText().toString().equals("")) {

                    /* If no number was entered a red error message
                    will display indicating no number was entered
                     */
                    resultId.setText(R.string.error_message);
                    resultId.setTextColor(Color.RED);

                }else{
                    // Else if a number was entered the inches conversion result will display in dark grey
                    double meterValue = Double.parseDouble(metersEditText.getText().toString());
                    result = meterValue*multiplier;

                    resultId.setTextColor(Color.DKGRAY);
                    resultId.setText(String.format("%.2f",result)+ "inches");

                }





            }
        });
    }
}
