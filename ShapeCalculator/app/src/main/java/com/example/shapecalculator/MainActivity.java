package com.example.shapecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button rectangle, triangle, rhombus;
    EditText widthInput, heightInput;
    TextView areaOutput, perimeterOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rectangle = (Button) findViewById(R.id.rectangle);
        triangle = (Button) findViewById(R.id.triangle);
        rhombus = (Button) findViewById(R.id.rhombus);
        widthInput = (EditText) findViewById(R.id.widthInput);
        heightInput = (EditText) findViewById(R.id.heightInput);
        areaOutput = (TextView) findViewById(R.id.areaOutput);
        perimeterOutput = (TextView) findViewById(R.id.perimeterOutput);

        rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shapeCalculator r = new shapeCalculator();

                int height; // height input from the user
                int width;  // width input from the user
                int area;  // area output value
                int perimeter;  // perimeter output value

                // get the number from the user input and convert it to int
                height = Integer.parseInt(heightInput.getText().toString());
                width = Integer.parseInt(widthInput.getText().toString());

                // compute the number using shapeCalculator class
                area = r.areaR(height, width);
                perimeter = r.perimeterR(height, width);

                // convert int back into string
                String areaoutput = String.valueOf(area);
                String perimeteroutput = String.valueOf(perimeter);

                // output the result
                areaOutput.setText(areaoutput);
                perimeterOutput.setText(perimeteroutput);


            }
        });

        triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shapeCalculator t = new shapeCalculator();

                int height; // height input from the user
                int width;  // width input from the user
                int area;  // area output value
                int perimeter;  // perimeter output value

                // get the number from the user input and convert it to int
                height = Integer.parseInt(heightInput.getText().toString());
                width = Integer.parseInt(widthInput.getText().toString());

                // compute the number using shapeCalculator class
                area = t.areaT(height, width);
                perimeter = t.perimeterT(height, width);

                // convert int back into string
                String areaoutput = String.valueOf(area);
                String perimeteroutput = String.valueOf(perimeter);

                // output the result
                areaOutput.setText(areaoutput);
                perimeterOutput.setText(perimeteroutput);


            }
        });

        rhombus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shapeCalculator rH = new shapeCalculator();

                int height; // height input from the user
                int width;  // width input from the user
                int area;  // area output value
                int perimeter;  // perimeter output value

                // get the number from the user input and convert it to int
                height = Integer.parseInt(heightInput.getText().toString());
                width = Integer.parseInt(widthInput.getText().toString());

                // compute the number using shapeCalculator class
                area = rH.areaRh(height, width);
                perimeter = rH.perimeterRh(width);

                // convert int back into string
                String areaoutput = String.valueOf(area);
                String perimeteroutput = String.valueOf(perimeter);

                // output the result
                areaOutput.setText(areaoutput);
                perimeterOutput.setText(perimeteroutput);


            }
        });


    }
}