package com.yavoric.lesson13;
import java.math.BigInteger;
import java.util.*;
public class Demo3 {

    public static void main(String[] args) {
        List<BigInteger> bigListNumber = new ArrayList<>();
        int c = 0;
        BigInteger big = new BigInteger("9990000000");
        BigInteger a = new BigInteger("10000000000");
        BigInteger b = new BigInteger("100000000000");
        BigInteger d = new BigInteger("100000000000");


        for (; ; ) {
            c = 1 + (int) (Math.random() * 1000000);
            if (c % 5 == 0) {
                big = big.add(d.valueOf(c));
                bigListNumber.add(big);


            }

        }
        //System.out.println( bigListNumber);
    }

}
