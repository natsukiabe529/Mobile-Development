package com.example.romannumeralconverter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberConverter {
    public String toRoman(int numberInput){
        if(numberInput < 0 || numberInput > 10000){
            return "Sorry, I can't do that";
        }

        String returnValue = "";

        while(numberInput >= 1000){
            returnValue += "M";
            numberInput = numberInput - 1000;
        }

        while(numberInput >= 900){
            returnValue += "CM";
            numberInput = numberInput - 900;
        }

        while(numberInput >= 500){
            returnValue += "D";
            numberInput = numberInput - 500;
        }

        while(numberInput >= 400){
            returnValue += "CD";
            numberInput = numberInput - 400;
        }

        while(numberInput >= 100){
            returnValue += "C";
            numberInput = numberInput - 100;
        }

        while(numberInput >= 90){
            returnValue += "XC";
            numberInput = numberInput - 90;
        }

        while(numberInput >= 50){
            returnValue += "L";
            numberInput = numberInput - 50;
        }

        while(numberInput >= 40){
            returnValue += "XL";
            numberInput = numberInput - 40;
        }

        while(numberInput >= 10){
            returnValue += "X";
            numberInput = numberInput - 10;
        }

        while(numberInput >= 9){
            returnValue += "IX";
            numberInput = numberInput - 9;
        }

        while(numberInput >= 5){
            returnValue += "V";
            numberInput = numberInput - 5;
        }

        while(numberInput >= 4){
            returnValue += "IV";
            numberInput = numberInput - 4;
        }

        while(numberInput >= 1){
            returnValue += "I";
            numberInput = numberInput - 1;
        }

        // return a string value of the numeral
        return returnValue;
    }



    public int romanToInteger(String roman)
    {
        Map<Character,Integer> numbersMap = new HashMap<>();
        numbersMap.put('I',1);
        numbersMap.put('V',5);
        numbersMap.put('X',10);
        numbersMap.put('L',50);
        numbersMap.put('C',100);
        numbersMap.put('D',500);
        numbersMap.put('M',1000);

        int result=0;

        for(int i=0;i<roman.length();i++)
        {
            char ch = roman.charAt(i);      // Current Roman Character

            //Case 1
            if(i>0 && numbersMap.get(ch) > numbersMap.get(roman.charAt(i-1)))
            {
                result += numbersMap.get(ch) - 2*numbersMap.get(roman.charAt(i-1));
            }

            // Case 2: just add the corresponding number to result.
            else
                result += numbersMap.get(ch);
        }

        return result;
    }

}
