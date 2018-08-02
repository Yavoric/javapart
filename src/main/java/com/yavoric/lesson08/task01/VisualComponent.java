package com.yavoric.lesson08.task01;

public interface VisualComponent {

    void draw ();
    default void draw3D(){
        System.out.println("Draw->3D");
    }
    default void draw3D(int h){
        System.out.println("Draw->3D" + h);
    }
}
