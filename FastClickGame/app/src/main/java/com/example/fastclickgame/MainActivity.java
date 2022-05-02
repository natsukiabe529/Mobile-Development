package com.example.fastclickgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b_start, b_click1;
    TextView tv_timeLeft, tv_clicks;
    int numberOfClicks = 0;
    int secondsLeft = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_start = (Button) findViewById(R.id.b_start);
        b_click1 = (Button) findViewById(R.id.b_click1);
        tv_timeLeft = (TextView) findViewById(R.id.tv_timeLeft);
        tv_clicks = (TextView)  findViewById(R.id.tv_clicks);

        b_click1.setEnabled(false);

        final CountDownTimer timer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                secondsLeft--;
                tv_timeLeft.setText("Seconds left: " + secondsLeft);
            }

            @Override
            public void onFinish() {
                b_click1.setEnabled(false);
            }
        };

        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondsLeft = 20;
                numberOfClicks = 0;
                b_click1.setEnabled(true);
                timer.start();

            }
        });


        b_click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfClicks++;
                tv_clicks.setText("Number of clicks: " + numberOfClicks);

            }
        });
    }
}