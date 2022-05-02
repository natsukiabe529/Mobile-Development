package com.example.peoplelistchallenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PersonalInformation App";

    MyApplication myApplication = (MyApplication) this.getApplication();

    List<PersonalInformation> personalInformationList;

    Button btn_addOne;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        personalInformationList = myApplication.getPersonalInformationList();

        Log.d(TAG, "onCreate: " + personalInformationList.toString());
        Toast.makeText(this, "Personal Information count = " +personalInformationList.size(), Toast.LENGTH_SHORT).show();

        btn_addOne = findViewById(R.id.btn_addOne);

        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddEditOne.class);
                startActivity(intent);

            }
        });

        recyclerView = findViewById(R.id.lv_peopleList);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecycleViewAdapter(personalInformationList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);


    }


}