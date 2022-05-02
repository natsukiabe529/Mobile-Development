package com.example.photoapp;

import android.app.Application;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class myApp extends Application  {
    List<Uri>UriList = new ArrayList<>();
    public myApp (){
        this.UriList = new ArrayList<>();
    }

    public List<Uri> getUriList() {
        return UriList;
    }

    public void setUriList(List<Uri> uriList){

    }


}
