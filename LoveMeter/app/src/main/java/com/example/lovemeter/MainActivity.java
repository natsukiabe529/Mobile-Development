package com.example.lovemeter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b_compute;
    ImageView iv_needle, iv_meter;
    EditText et_yourname, et_otherpersonname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_compute = (Button) findViewById(R.id.b_compute);
        iv_needle = (ImageView)  findViewById(R.id.iv_needle);
        iv_meter = (ImageView) findViewById(R.id.iv_meter);
        et_yourname = (EditText)  findViewById(R.id.et_yourname);
        et_otherpersonname = (EditText)  findViewById(R.id.et_otherpersonname);

        b_compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yourName = et_yourname.getText().toString().toLowerCase();
                String otherPersonName = et_otherpersonname.getText().toString().toLowerCase() ;

                float totalLetters = yourName.length() + otherPersonName.length();
                float totalMatches = 0;

                for(int i = 0; i < yourName.length(); i++){
                    for(int j = 0; j < otherPersonName.length(); j++){
                        if(yourName.charAt(i) == otherPersonName.charAt(j)){
                            totalMatches++;
                        }
                    }
                }

                for(int i = 0; i < otherPersonName.length(); i++){
                    for(int j = 0; j < yourName.length(); j++){
                        if(otherPersonName.charAt(i) == yourName.charAt(j)){
                            totalMatches++;
                        }
                    }
                }

                float compatScore = totalMatches / totalLetters;

                int loveScore = ((int) (compatScore * 100)) - 50;

                RotateAnimation ra = new RotateAnimation(0, 360+loveScore,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);

                ra.setFillAfter(true);
                ra.setDuration(2000);
                ra.setInterpolator(new AccelerateDecelerateInterpolator());
                iv_needle.startAnimation(ra);

                Toast.makeText(MainActivity.this, "Love Score: " + loveScore, Toast.LENGTH_SHORT).show();

            }
        });
    }
}