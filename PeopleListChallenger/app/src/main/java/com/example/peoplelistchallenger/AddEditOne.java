package com.example.peoplelistchallenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    List<PersonalInformation> personalInformationList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    Button btn_take, btn_choose;
    Button btn_saveChange, btn_return;
    Button btn_call, btn_text, btn_map, btn_email, btn_web;
    EditText et_name, et_address, et_phone, et_email, et_url;
    int id;

    final static int PERMISSION_TO_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        personalInformationList = myApplication.getPersonalInformationList();

        btn_take = findViewById(R.id.btn_take);
        btn_choose = findViewById(R.id.btn_choose);
        btn_saveChange = findViewById(R.id.btn_saveChange);
        btn_return = findViewById(R.id.btn_return);
        btn_call = findViewById(R.id.btn_call);
        btn_text = findViewById(R.id.btn_text);
        btn_map = findViewById(R.id.btn_map);
        btn_email = findViewById(R.id.btn_email);
        btn_web = findViewById(R.id.btn_web);
        et_name = findViewById(R.id.et_name);
        et_address = findViewById(R.id.et_address);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_url = findViewById(R.id.et_url);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        PersonalInformation personalInformation = null;

        if(id >= 0){
            // edit the personal information
            for(PersonalInformation p: personalInformationList){
                if(p.getId() == id){
                    personalInformation = p;
                }
            }
            et_name.setText(personalInformation.getName());
            et_address.setText(personalInformation.getAddress());
            et_phone.setText(String.valueOf(personalInformation.getPhone()));
            et_email.setText(personalInformation.getEmail());
            et_url.setText(personalInformation.getImageURL());

        }else{
            // create new personal information
        }

        btn_saveChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(id >- 0){
                    // update
                    PersonalInformation updatePersonalInformation = new PersonalInformation(id, et_name.getText().toString(), et_address.getText().toString(), Integer.parseInt(et_phone.getText().toString()), et_email.getText().toString(), et_url.getText().toString());
                    personalInformationList.set(id, updatePersonalInformation);
                }else{
                    // add new personal information
                    // create personal information object
                    int nextId = myApplication.getNextId();
                    PersonalInformation newPersonalInformation = new PersonalInformation(nextId, et_name.getText().toString(), et_address.getText().toString(), Integer.parseInt(et_phone.getText().toString()), et_email.getText().toString(), et_url.getText().toString());

                    // add the object to the global list of presidents
                    personalInformationList.add(newPersonalInformation);
                    myApplication.setNextId(nextId++);
                }



                Intent intent = new Intent(AddEditOne.this, AddEditOne.class);
                startActivity(intent);

            }
        });

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });




        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPhoneNumber(et_phone.getText().toString());
            }
        });

        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                composeMmsMessage(et_phone.getText().toString(), "Hello");
            }
        });

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mapsQuery = "geo:0,0?q=" + et_address.getText().toString();
                Uri mapuri = Uri.parse(mapsQuery);
                showMap(mapuri);
            }
        });

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] addresses = new String [1];
                addresses [0] = et_email.getText().toString();

                composeEmail(addresses, "hello");
            }
        });

        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage(et_name.getText().toString());
            }
        });
    }


    public void openWebPage(String url) {
        if(!url.startsWith("http://") || !url.startsWith("https://")){
            url = "http://" + url;
        }
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void callPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(AddEditOne.this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISSION_TO_CALL);
        }
        else {

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_TO_CALL:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    callPhoneNumber(et_phone.getText().toString());
                } else {
                    Toast.makeText(this, "Cannot make a call without your permissions", Toast.LENGTH_SHORT).show();
                }
                return;
        }
        // Other 'case' lines to check for other
        // permissions this app might request.
    }


    public void composeMmsMessage(String phoneNumber, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}