package com.yavoric.lesson08.task01;
//Переделана реализация согласно Задания 10
import com.yavoric.lesson08.task01.CheckBox;
import com.yavoric.lesson08.task01.RoundButton;

public class Task01 {
    public static void main(String[] args) {
        Component[] components = new Component[10];
        //intputArreyComponent ();


        components[0] = new Label();
        components[1] = new Button();
        components[2] = new RoundButton();
        components[3] = new CheckBox();
        components[4] = new Label();
        components[5] = new Button();
        components[6] = new RoundButton();
        components[7] = new CheckBox();
        components[8] = new Label();
        components[9] = new Button();
        System.out.println("Вывод всех компонентов");
        for (int i = 0; i < components.length; i++) {
            components[i].draw();
            components[i].draw3D();
            components[i].draw3D(i);
        }
        System.out.println("Вывод компонентов Button и его наследников ");
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof Button) {
                components[i].draw();
                components[i].draw3D();

            }

    /*public static Component intputArreyComponent  (components){
        for (int i = 0; i<10; i++){
            System.out.println("1-Label 2-Button- ");
            System.out.println("Выберите");

        }
    }
    Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число А");
    Variable2.a = scanner.nextInt();
        System.out.println("Введите число B");
    Variable2.b= scanner.nextInt();
        System.out.println("Введите число C");
    Variable2.c = scanner.nextInt();*/
        }
    }
}