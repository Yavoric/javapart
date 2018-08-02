package com.yavoric.lesson08.task01;

public class Component implements VisualComponent {
//@Override
    String caption = "Название";

    public void draw(){
    System.out.println(caption);
}
}