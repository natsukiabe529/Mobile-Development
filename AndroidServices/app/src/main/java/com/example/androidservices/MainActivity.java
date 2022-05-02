package com.example.androidservices;

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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_web, btn_email, btn_dial, btn_call, btn_text, btn_maps;
    EditText et_data;

    final static int PERMISSION_TO_CALL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_web = findViewById(R.id.btn_web);
        btn_email = findViewById(R.id.btn_email);
        btn_dial = findViewById(R.id.btn_dial);
        btn_call = findViewById(R.id.btn_call);
        btn_text = findViewById(R.id.btn_text);
        btn_maps = findViewById(R.id.btn_maps);
        et_data = findViewById(R.id.et_data);

        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openWebPage(et_data.getText().toString());
            }
        });

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String [] addresses = new String [1];
                addresses [0] = et_data.getText().toString();

                composeEmail(addresses, "hello");

            }
        });

        btn_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialPhoneNumber(et_data.getText().toString());

            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPhoneNumber(et_data.getText().toString());
            }
        });

        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                composeMmsMessage(et_data.getText().toString(), "Hello");
            }
        });

        btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mapsQuery = "geo:0,0?q=" + et_data.getText().toString();
                Uri mapuri = Uri.parse(mapsQuery);
                showMap(mapuri);

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
            ActivityCompat.requestPermissions(MainActivity.this,
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
                    callPhoneNumber(et_data.getText().toString());
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

