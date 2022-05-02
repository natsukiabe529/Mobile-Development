package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_toPage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_toPage2 = findViewById(R.id.btn_toPage2);

        btn_toPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToPageTwo = new Intent(view.getContext(), MainActivity2.class);
                startActivity(goToPageTwo);

            }
        });
    }
}