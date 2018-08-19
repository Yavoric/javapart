package com.yavoric.tests.lesson11;
import com.yavoric.lesson11.CalcMain;
import com.yavoric.lesson11.Operation;
public class CalculatorTests {
    public static void main(String[] args) {
        double[] arr1 = {1, 2, 3, 4, 5};
        Operation x = new Operation();
        if (x.Addition() ==15) {

            System.out.println("Test Sucses");

        }
    }
}
