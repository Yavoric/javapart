package com.yavoric.lesson08.task01;

public class Label extends Component {

  //  @Override
    public void draw(int a) {
        {
            caption = "Надпись";
            System.out.println("Компонент Label");
            System.out.println("_____________");
            System.out.println("|"+caption+a+"|");
            System.out.println("_____________");
        }

    }
}
