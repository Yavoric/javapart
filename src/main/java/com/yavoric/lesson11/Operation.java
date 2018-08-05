package com.yavoric.lesson11;
import java.util.Scanner;
public class Operation implements ArithmeticOperations {
    private static double SetOperandOne(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число А ");
        Double n = scanner.nextDouble();
        return n;
    }
    private static double SetOperandTwo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Число В ");
        Double w = scanner.nextDouble();
        return w;
    }
    public double Addition(){//Сложение
        double a =SetOperandOne();
        double b = SetOperandTwo();
        double z = a+b;
        return z;
    }
    public double Subtraction() {//Вычитание
        double a =SetOperandOne();
        double b = SetOperandTwo();
        double z = a-b;
        return z;
    }
    public double Multiplication() {
        ;//Умножение
        double a = SetOperandOne();
        double b = SetOperandTwo();
        double z = a * b;
        return z;
    }
    public double Division() {//Деление
        double a = SetOperandOne();
        double b = SetOperandTwo();
        double z = a / b;
        return z;
    }
    public double CalculationOfInterest() { //Вычисление процента
        double a = SetOperandOne();
        double b = SetOperandTwo();
        double z = b /a * 100;
        return z;
    }
    public double CalculatingTheSquareRoot() { //Вычисление квадрaтного корня
        double a = SetOperandOne();
        double z = Math.sqrt(a);
        return z;
    }
    public double CalculatingTheSquareOfNumber() {//вычисления квадрата числа
        double a = SetOperandOne();
        double z = a *a;
        return z;
    }
}


