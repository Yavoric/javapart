package com.yavoric.lesson14.task6;

public class PhoneNumber {
    private String[] number = {"0","1","2","3","4","5","6","7","8","9"};
    private String elementaryPhnoneNumber = "380";
    private String fullPhnoneNumber;
    public String getFullPnoneNumber(){
        fullPhnoneNumber = elementaryPhnoneNumber;
        for (int i =0; i<9;i++){
            int c = (int) (Math.random()* 9);
            fullPhnoneNumber = fullPhnoneNumber+number[c];
        }
        return fullPhnoneNumber;
    }


}
