package com.example.shapecalculator;

public class shapeCalculator {

    public int areaR(int height, int width){
        int returnValue;
        returnValue = height * width;
        return returnValue;
    }

    public int perimeterR(int height, int width){
        int returnValue;
        returnValue = (2 * height) + (2 * width);
        return returnValue;
    }

    public int areaT(int height, int width){
        int returnValue;
        returnValue = height * width / 2;
        return returnValue;
    }

    public int perimeterT(int height, int width){
        double slopeLength;
        slopeLength = Math.sqrt((height*height)+(width*width));
        int returnValue;
        int slopeLength1 = (int)slopeLength;
        returnValue = height + width + slopeLength1;
        return returnValue;
    }

    public int areaRh(int height, int width){
        int returnValue;
        returnValue = height * width;
        return returnValue;
    }

    public int perimeterRh(int width){
        int returnValue;
        returnValue = 4 * width;
        return returnValue;
    }


}
