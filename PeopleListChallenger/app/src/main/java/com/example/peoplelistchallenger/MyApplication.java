package com.example.peoplelistchallenger;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    private static List<PersonalInformation> personalInformationList = new ArrayList<PersonalInformation>();
    private static int nextId = 3;
    public MyApplication() {
        fillPersonalInformationList();
    }

    private void fillPersonalInformationList(){
        PersonalInformation pi1 = new PersonalInformation(0, "Natsuki", "Gilbert", 123455, "sdf@hotmail.com", "https://cdn.pixabay.com/photo/2020/02/03/12/37/guy-4815579_1280.jpg");
        PersonalInformation pi2 = new PersonalInformation(1, "David", "Gilbert", 2347879, "wesd@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/3/38/Guy_Standing_%28cropped%29.jpeg");
        PersonalInformation pi3 = new PersonalInformation(2, "Christian", "Charlotte", 8792374, "oefh@yahoo.com", "https://upload.wikimedia.org/wikipedia/commons/c/c7/%C3%96sterreichischer_Filmpreis_2017_photo_call_A_Good_American_Guy_Farley.jpg");

        personalInformationList.addAll(Arrays.asList( new PersonalInformation[] {pi1, pi2, pi3}));
    }

    public static List<PersonalInformation> getPersonalInformationList() {
        return personalInformationList;
    }

    public static void setPersonalInformationList(List<PersonalInformation> personalInformationList) {
        MyApplication.personalInformationList = personalInformationList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
