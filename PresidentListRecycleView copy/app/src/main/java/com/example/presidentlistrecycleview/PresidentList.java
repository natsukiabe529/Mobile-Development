package com.example.presidentlistrecycleview;

import java.util.ArrayList;
import java.util.List;

public class PresidentList {

    private List<President> presidentList = new ArrayList<President>();

    public PresidentList(List<President> presidentList){
        this.presidentList = presidentList;
    }

    public List<President> getPresidentList(){

        return presidentList;
    }

    @Override
    public String toString() {
        return "PresidentList{" +
                "presidentList=" + presidentList +
                '}';
    }

    public PresidentList(){

    }

    public void setPresidentList(List<President>presidentList){
        this.presidentList = presidentList;
    }
}
