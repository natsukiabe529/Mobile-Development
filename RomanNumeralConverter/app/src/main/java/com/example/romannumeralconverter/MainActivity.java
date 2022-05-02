package com.example.romannumeralconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b_convertToRoman, b_convertToNumber;
    EditText et_number, et_romanInput;
    TextView tv_romanOutput, tv_numberOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_convertToNumber = (Button) findViewById(R.id.b_convertToNumber);
        b_convertToRoman = (Button) findViewById(R.id.b_convertToRoman);
        et_number = (EditText) findViewById(R.id.et_number);
        et_romanInput = (EditText) findViewById(R.id.et_romanInput);
        tv_numberOutput = (TextView) findViewById(R.id.tv_numberOutput);
        tv_romanOutput = (TextView) findViewById(R.id.tv_romanOutput);

        b_convertToNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // we need to convert a roman numeral to a number
                NumberConverter rc = new NumberConverter();

                String theRoman;  // the input from the user
                int theNumber;  // an integer to send back to the user

                // get the roman numeral from the edit text field
                theRoman = et_romanInput.getText().toString();
                // get the computed integer from our NumberConverter class
                theNumber = rc.romanToInteger(theRoman);

                // convert an integer to a string
                String num = String.valueOf(theNumber);

                // send the string back to the screen in the textview field
                tv_numberOutput.setText(num);

            }
        });


        b_convertToRoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // we need to convert a number to a numeral
                NumberConverter nc = new NumberConverter();

                int theNumber;  // the input from the user
                String theRoman;  // string to send back to the user

                // get the number from the edit text field
                theNumber = Integer.parseInt(et_number.getText().toString());

                // get the computed roman numeral from our NumberConvert class
                theRoman = nc.toRoman(theNumber);

                // send the string back to the screen in the textview field
                tv_romanOutput.setText(theRoman);
            }
        });

    }
}