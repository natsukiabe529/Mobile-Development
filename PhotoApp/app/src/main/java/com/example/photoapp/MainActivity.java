package com.example.photoapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_take, btn_load, btn_list;
    TextView tv_message;
    ImageView iv_photo;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int SELECT_A_PHOTO =2;
    int requestCode = 1;
    String currentPhotoPath;

    List<Uri> uriList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_take = findViewById(R.id.btn_take);
        btn_load = findViewById(R.id.btn_load);
        btn_list = findViewById(R.id.btn_list);
        tv_message = findViewById(R.id.tv_message);
        iv_photo = findViewById(R.id.iv_photo);

        btn_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, SELECT_A_PHOTO);
            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), photoList.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uriList = ((myApp) this.getApplication()).getUriList();

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            // Set the image in the iv_photo
            Glide.with(this).load(currentPhotoPath).into(iv_photo);
            // Show the file name in tv_message
            tv_message.setText(currentPhotoPath);

            uriList.add(Uri.fromFile(new File(currentPhotoPath)));
        }
        if (requestCode == SELECT_A_PHOTO && resultCode == RESULT_OK)
        {
            Uri selectedPhoto = data.getData();
            // Set the image in the iv_photo
            Glide.with(this).load(selectedPhoto).into(iv_photo);
            // Show the file name in tv_message
            tv_message.setText(selectedPhoto.toString());

            uriList.add(selectedPhoto);
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                Toast.makeText(this, "Something went wrong, could not create file.", Toast.LENGTH_SHORT).show();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.photoapp.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    // Saves File
    private File createImageFile() throws IOException {
        // creates image file name
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String imageFileName = "PNG" + timeStamp + "";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".png", storageDir);
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }







}