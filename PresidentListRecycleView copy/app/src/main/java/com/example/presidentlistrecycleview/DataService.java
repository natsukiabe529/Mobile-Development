package com.example.presidentlistrecycleview;

import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataService {
    Context context;

    ObjectMapper om = new ObjectMapper();

    public DataService(Context context){
        this.context = context;
    }

    public void writeList(List<President> presidentList, String filename){
        File path = context.getExternalFilesDir(null);
        File file = new File(path, filename);
        try{
            om.writerWithDefaultPrettyPrinter().writeValue(file, presidentList);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public PresidentList readList(List<President> presidentList, String filename){
        File path = context.getExternalFilesDir(null);
        File file = new File(path, filename);
        PresidentList returnList = new PresidentList();

        try{
            returnList = om.readValue(file,PresidentList.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return returnList;
    }
}
