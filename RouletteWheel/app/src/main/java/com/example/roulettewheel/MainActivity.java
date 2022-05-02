package com.example.roulettewheel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_roulette;
    EditText et_cashAmount, et_redBets, et_blackBets, et_firstDozen, et_secondDozen, et_thirdDozen, et_odd, et_even, et_oneNumber, et_amount;
    Button b_wheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_roulette = (ImageView)  findViewById(R.id.iv_roulette);
        et_cashAmount = (EditText)  findViewById(R.id.et_cashAmount);
        et_redBets = (EditText)  findViewById(R.id.et_redBets);
        et_blackBets = (EditText)  findViewById(R.id.et_blackBets);
        et_firstDozen = (EditText)  findViewById(R.id.et_firstDozen);
        et_secondDozen = (EditText)  findViewById(R.id.et_secondDozen);
        et_thirdDozen = (EditText)  findViewById(R.id.et_thirdDozen);
        et_odd = (EditText)  findViewById(R.id.et_odd);
        et_even = (EditText)  findViewById(R.id.et_even);
        et_oneNumber = (EditText)  findViewById(R.id.et_oneNumber);
        et_amount = (EditText)  findViewById(R.id.et_amount);
        b_wheel = (Button) findViewById(R.id.b_wheel);

        b_wheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // roulette numbers
                int[] rouletteNumbers = {0, 26, 3, 35, 12, 28, 7, 29, 18, 22,
                        9, 31, 14, 20, 1, 33, 16, 24, 5, 10,
                        23, 8, 30, 11, 36, 13, 27, 6, 34, 17,
                        25, 2, 21, 4, 19, 15, 32};

                int spinDegrees;
                Random r = new Random();
                spinDegrees = r.nextInt(360);

                RotateAnimation ra = new RotateAnimation(0, spinDegrees - 4 + 360,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);

                ra.setFillAfter(true);
                ra.setDuration(8000);
                ra.setInterpolator(new AccelerateDecelerateInterpolator());
                iv_roulette.startAnimation(ra);

                double IndexNumber;
                IndexNumber = Math.floor(spinDegrees / 9.7);
                int indexNumber = (int) IndexNumber;

                    // red bets
                    String Red;
                    int red = 0;
                    Red = et_redBets.getText().toString();
                    if (Red.matches("")) {
                        red = 0;
                    } else if (rouletteNumbers[indexNumber] == 32 || rouletteNumbers[indexNumber] == 19 || rouletteNumbers[indexNumber] == 21 ||
                            rouletteNumbers[indexNumber] == 25 || rouletteNumbers[indexNumber] == 34 || rouletteNumbers[indexNumber] == 27 ||
                            rouletteNumbers[indexNumber] == 36 || rouletteNumbers[indexNumber] == 30 || rouletteNumbers[indexNumber] == 23 ||
                            rouletteNumbers[indexNumber] == 5 || rouletteNumbers[indexNumber] == 16 || rouletteNumbers[indexNumber] == 1 ||
                            rouletteNumbers[indexNumber] == 14 || rouletteNumbers[indexNumber] == 9 || rouletteNumbers[indexNumber] == 18 ||
                            rouletteNumbers[indexNumber] == 7 || rouletteNumbers[indexNumber] == 12 || rouletteNumbers[indexNumber] == 3) {
                        red = Integer.parseInt(Red);
                        red = red * 2;
                    }

                    // black bets
                    String Black;
                    int black = 0;
                    Black = et_blackBets.getText().toString();
                    if (Black.matches("")) {
                        black = 0;
                    } else if (rouletteNumbers[indexNumber] == 15 || rouletteNumbers[indexNumber] == 4 || rouletteNumbers[indexNumber] == 2 ||
                            rouletteNumbers[indexNumber] == 17 || rouletteNumbers[indexNumber] == 6 || rouletteNumbers[indexNumber] == 13 ||
                            rouletteNumbers[indexNumber] == 11 || rouletteNumbers[indexNumber] == 8 || rouletteNumbers[indexNumber] == 10 ||
                            rouletteNumbers[indexNumber] == 24 || rouletteNumbers[indexNumber] == 33 || rouletteNumbers[indexNumber] == 20 ||
                            rouletteNumbers[indexNumber] == 31 || rouletteNumbers[indexNumber] == 22 || rouletteNumbers[indexNumber] == 29 ||
                            rouletteNumbers[indexNumber] == 28 || rouletteNumbers[indexNumber] == 35 || rouletteNumbers[indexNumber] == 26) {
                        black = Integer.parseInt(Black);
                        black = black * 2;
                    }

                    // odd bets
                    String Odd;
                    int odd = 0;
                    Odd = et_odd.getText().toString();
                    if (Odd.matches("")) {
                        odd = 0;
                    } else if (rouletteNumbers[indexNumber] == 1 || rouletteNumbers[indexNumber] == 3 || rouletteNumbers[indexNumber] == 5 ||
                            rouletteNumbers[indexNumber] == 7 || rouletteNumbers[indexNumber] == 9 || rouletteNumbers[indexNumber] == 11 ||
                            rouletteNumbers[indexNumber] == 13 || rouletteNumbers[indexNumber] == 15 || rouletteNumbers[indexNumber] == 17 ||
                            rouletteNumbers[indexNumber] == 19 || rouletteNumbers[indexNumber] == 21 || rouletteNumbers[indexNumber] == 23 ||
                            rouletteNumbers[indexNumber] == 25 || rouletteNumbers[indexNumber] == 27 || rouletteNumbers[indexNumber] == 29 ||
                            rouletteNumbers[indexNumber] == 31 || rouletteNumbers[indexNumber] == 33 || rouletteNumbers[indexNumber] == 35) {
                        odd = Integer.parseInt(Odd);
                        odd = odd * 2;
                    }

                    // even bets
                    String Even;
                    int even = 0;
                    Even = et_even.getText().toString();
                    if (Even.matches("")) {
                        even = 0;
                    } else if (rouletteNumbers[indexNumber] == 2 || rouletteNumbers[indexNumber] == 4 || rouletteNumbers[indexNumber] == 6 ||
                            rouletteNumbers[indexNumber] == 8 || rouletteNumbers[indexNumber] == 10 || rouletteNumbers[indexNumber] == 12 ||
                            rouletteNumbers[indexNumber] == 14 || rouletteNumbers[indexNumber] == 16 || rouletteNumbers[indexNumber] == 18 ||
                            rouletteNumbers[indexNumber] == 20 || rouletteNumbers[indexNumber] == 22 || rouletteNumbers[indexNumber] == 24 ||
                            rouletteNumbers[indexNumber] == 26 || rouletteNumbers[indexNumber] == 28 || rouletteNumbers[indexNumber] == 30 ||
                            rouletteNumbers[indexNumber] == 32 || rouletteNumbers[indexNumber] == 34 || rouletteNumbers[indexNumber] == 36) {
                        even = Integer.parseInt(Even);
                        even = even * 2;
                    }

                    // first dozen bets
                    String FirstDozen;
                    int firstDozen = 0;
                    FirstDozen = et_firstDozen.getText().toString();
                    if (FirstDozen.matches("")) {
                        firstDozen = 0;
                    } else if (rouletteNumbers[indexNumber] == 1 || rouletteNumbers[indexNumber] == 2 || rouletteNumbers[indexNumber] == 3 ||
                            rouletteNumbers[indexNumber] == 4 || rouletteNumbers[indexNumber] == 5 || rouletteNumbers[indexNumber] == 6 ||
                            rouletteNumbers[indexNumber] == 7 || rouletteNumbers[indexNumber] == 8 || rouletteNumbers[indexNumber] == 9 ||
                            rouletteNumbers[indexNumber] == 10 || rouletteNumbers[indexNumber] == 11 || rouletteNumbers[indexNumber] == 12) {
                        firstDozen = Integer.parseInt(FirstDozen);
                        firstDozen = firstDozen * 3;
                    }

                    // second dozen bets
                    String SecondDozen;
                    int secondDozen = 0;
                    SecondDozen = et_secondDozen.getText().toString();
                    if (SecondDozen.matches("")) {
                        secondDozen = 0;
                    } else if (rouletteNumbers[indexNumber] == 13 || rouletteNumbers[indexNumber] == 14 || rouletteNumbers[indexNumber] == 15 ||
                            rouletteNumbers[indexNumber] == 16 || rouletteNumbers[indexNumber] == 17 || rouletteNumbers[indexNumber] == 18 ||
                            rouletteNumbers[indexNumber] == 19 || rouletteNumbers[indexNumber] == 20 || rouletteNumbers[indexNumber] == 21 ||
                            rouletteNumbers[indexNumber] == 22 || rouletteNumbers[indexNumber] == 23 || rouletteNumbers[indexNumber] == 24) {
                        secondDozen = Integer.parseInt(SecondDozen);
                        secondDozen = secondDozen * 3;
                    }

                    // third dozen bets
                    String ThirdDozen;
                    int thirdDozen = 0;
                    ThirdDozen = et_thirdDozen.getText().toString();
                    if (ThirdDozen.matches("")) {
                        thirdDozen = 0;
                    } else if (rouletteNumbers[indexNumber] == 25 || rouletteNumbers[indexNumber] == 26 || rouletteNumbers[indexNumber] == 27 ||
                            rouletteNumbers[indexNumber] == 28 || rouletteNumbers[indexNumber] == 29 || rouletteNumbers[indexNumber] == 30 ||
                            rouletteNumbers[indexNumber] == 31 || rouletteNumbers[indexNumber] == 32 || rouletteNumbers[indexNumber] == 33 ||
                            rouletteNumbers[indexNumber] == 34 || rouletteNumbers[indexNumber] == 35 || rouletteNumbers[indexNumber] == 36) {
                        thirdDozen = Integer.parseInt(ThirdDozen);
                        thirdDozen = thirdDozen * 3;
                    }

                    // one number bets
                    String OneNumber;
                    int oneNumber = 0;
                    OneNumber = et_amount.getText().toString();
                    if (OneNumber.matches("")) {
                        oneNumber = 0;
                    } else if (rouletteNumbers[indexNumber] == Integer.parseInt(et_oneNumber.getText().toString())) {
                        oneNumber = Integer.parseInt(OneNumber);
                        oneNumber = oneNumber * 36;
                    }

                    // total winning amount
                    int totalAmount;
                    totalAmount = red + black + odd + even + firstDozen + secondDozen + thirdDozen + oneNumber;
                    




                    ra.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Toast.makeText(MainActivity.this, "Drawn Number: " + rouletteNumbers[indexNumber], Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, "You win $" + totalAmount, Toast.LENGTH_SHORT).show();

                            String TotalAmount;
                            TotalAmount = String.valueOf(totalAmount);
                            et_cashAmount.setText(TotalAmount);





                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                }

        });
    }
}