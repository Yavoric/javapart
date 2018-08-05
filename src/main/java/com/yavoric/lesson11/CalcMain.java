package com.yavoric.lesson11;

import java.math.BigDecimal;
import java.util.*;
public class CalcMain {
    public static void main(String[] args) {
        Operation x = new Operation();
        int j = SelectOperation();
        switch (j){
            case 1://Сложение
                System.out.println("Результат операции= "+x.Addition());
                break;
            case 2://Вычитание
                System.out.println("Результат операции= "+x.Subtraction());
                break;
            case 3:////Умножение
                System.out.println("Результат операции= "+x.Multiplication());
                break;
            case 4://Деление
                System.out.println("Результат операции= "+x.Division());
                break;
            case 5://Вычисление процента
                System.out.println("Результат операции= "+x.CalculationOfInterest());
                break;
            case 6://Вычисление квадратного корня
                System.out.println("Результат операции= "+x.CalculatingTheSquareRoot());
                break;
            case 7://вычисления квадрата числа
                System.out.println("Результат операции= "+x.CalculatingTheSquareOfNumber());
                break;
            default:
                System.out.println("Вы выбрали несуществующую операцию");
                break;
        }

    }
    private static int SelectOperation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите операцию: 1-Сложение; 2-Вычитание; 3- Умножение;4 - Деление;" +
                "5 - Вычисление процента; 6 -Вычисление квадратного корня; 7 - вычисления квадрата числа");
        int d = scanner.nextInt();
        return d;
    }

}
