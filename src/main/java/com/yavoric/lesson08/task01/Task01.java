package com.yavoric.lesson08.task01;
//Переделана реализация согласно Задания 10
import com.yavoric.lesson08.task01.CheckBox;
import com.yavoric.lesson08.task01.RoundButton;

public class Task01 {
    public static void main(String[] args) {
        Component[] components = new Component[30];
        //intputArreyComponent ();
        for (int i = 0; i < components.length; i++) {
            int с = 1 + (int) (Math.random() * 4);
            switch (с) {
                case 1:
                    components[i] = new Label();
                    break;
                case 2:
                    components[i] = new Button();
                    break;
                case 3:
                    components[i] = new RoundButton();
                    break;
                case 4:
                    components[i] = new CheckBox();
                    break;
                    default: break;

            }
        }
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

    /*public static Component fillComponent  (components){
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