package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    Button b_roll;
    TextView tv_rollNumber;
    ImageView iv_dice;


    // define the sensor variables
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[0];
            float z = sensorEvent.values[0];
            if(x != 0 || y != 0 || z != 0){
                Random r = new Random();
                int theRoll;

                // random number between 1 and 6
                theRoll = r.nextInt(6) + 1;

                tv_rollNumber.setText("You rolled a " + theRoll);

                switch(theRoll){
                    case 1:{
                        iv_dice.setImageResource(R.drawable.dice1);
                        break;
                    }
                    case 2:{
                        iv_dice.setImageResource(R.drawable.dice2);
                        break;
                    }
                    case 3:{
                        iv_dice.setImageResource(R.drawable.dice3);
                        break;
                    }
                    case 4:{
                        iv_dice.setImageResource(R.drawable.dice4);
                        break;
                    }
                    case 5:{
                        iv_dice.setImageResource(R.drawable.dice5);
                        break;
                    }
                    case 6:{
                        iv_dice.setImageResource(R.drawable.dice6);
                        break;
                    }
                }

            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_roll = (Button) findViewById(R.id.b_roll);
        tv_rollNumber = (TextView) findViewById(R.id.tv_rollNumber);
        iv_dice = (ImageView) findViewById(R.id.iv_dice);

        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int theRoll;

                // random number between 1 and 6
                theRoll = r.nextInt(6) + 1;

                tv_rollNumber.setText("You rolled a " + theRoll);

                switch(theRoll){
                    case 1:{
                        iv_dice.setImageResource(R.drawable.dice1);
                        break;
                    }
                    case 2:{
                        iv_dice.setImageResource(R.drawable.dice2);
                        break;
                    }
                    case 3:{
                        iv_dice.setImageResource(R.drawable.dice3);
                        break;
                    }
                    case 4:{
                        iv_dice.setImageResource(R.drawable.dice4);
                        break;
                    }
                    case 5:{
                        iv_dice.setImageResource(R.drawable.dice5);
                        break;
                    }
                    case 6:{
                        iv_dice.setImageResource(R.drawable.dice6);
                        break;
                    }
                }


            }
        });








        // initialize sensor objects
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }




    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }







}