package com.example.jokesapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_joke1, btn_joke2, btn_joke3, btn_joke4, btn_joke5, btn_joke6;
    TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_joke1 = findViewById(R.id.btn_joke1);
        btn_joke2 = findViewById(R.id.btn_joke2);
        btn_joke3 = findViewById(R.id.btn_joke3);
        btn_joke4 = findViewById(R.id.btn_joke4);
        tv_message = findViewById(R.id.tv_message);
        btn_joke5 = findViewById(R.id.btn_joke5);
        btn_joke6 = findViewById(R.id.btn_joke6);

        // create click listeners
        btn_joke1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "To get to the other side", Toast.LENGTH_SHORT).show();

            }
        });

        btn_joke2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Bison", Toast.LENGTH_SHORT).show();
            }
        });

        btn_joke3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Red Paint", Toast.LENGTH_SHORT).show();
            }
        });

        // jokes 4, 5, and 6 will use the textview to display the answers
        btn_joke4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_message.setText("B");
            }
        });

        btn_joke5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_message.setText("I'm just very relaxed");
            }
        });

        btn_joke6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_message.setText("Never let a kiss fool you");
            }
        });


    }
}