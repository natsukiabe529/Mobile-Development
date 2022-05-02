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
        President p3 = new President(3, "James Madison", 1808,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/James_Madison.jpg/320px-James_Madison.jpg");
        President p4 = new President(4, "James Monroe", 1816,"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/James_Monroe_White_House_portrait_1819.jpg/320px-James_Monroe_White_House_portrait_1819.jpg");
        President p5 = new President(5, "John Quincy Adams", 1824,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/JQA_Photo.tif/lossy-page1-320px-JQA_Photo.tif.jpg");
        President p6 = new President(6, "Andrew Jackson", 1828,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Andrew_jackson_head.jpg/320px-Andrew_jackson_head.jpg");
        President p7 = new President(7,"Martin Van Buren", 1836,"https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Martin_Van_Buren_edit.jpg/320px-Martin_Van_Buren_edit.jpg");
        President p8 = new President(8, "William Henry Harrison", 1840,"https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/William_Henry_Harrison_by_James_Reid_Lambdin%2C_1835_crop.jpg/320px-William_Henry_Harrison_by_James_Reid_Lambdin%2C_1835_crop.jpg");
        President p9 = new President(9,"John Tyler", 1840,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/John_Tyler%2C_Jr.jpg/320px-John_Tyler%2C_Jr.jpg");

        presidentList.addAll(Arrays.asList(new President[]{p0, p1, p2, p3, p4, p5, p6, p7, p8,p9}));
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
