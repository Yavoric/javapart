package com.yavoric.lesson14.task1;

public class LambdaEmpl implements Lambda {
    @Override
    public int operation(int x) {
        if (x>=10 )
            return x+1;
        return x;
    }
}
