package com.example.presidentlistrecycleview;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    private static List<President> presidentList = new ArrayList<President>();
    private static int nextId = 10;

    public MyApplication() {
        fillPresidentList();
    }

    private void fillPresidentList() {
        President p0 = new President(0, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/320px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1, "John Adams", 1796, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg/320px-John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg");
        President p2 = new President(2, "Thomas Jefferson", 1800,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg/320px-Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg");


        presidentList.addAll(Arrays.asList(new President[]{p0, p1, p2}));
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
