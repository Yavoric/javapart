package com.yavoric.lesson13;
import java.util.*;
public class Demo1 {
    public static void main(String[] args) {
        String[] name = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max"};//Начальный список имен
        String[] nameAdd = {"Philip", "Joseph", "Leon"};//Имена, которые нужно добавиить
        String[] nameDel = {"Veronica", "Leonid"};//Импена, которые нужно удалить
        String[] nameExch = {"Helen","Elizabet"};//Helen на Elizabet имена, которые нужно поменять
        String[] nameLeave = {"Kate","Helen"};
        String nameSerch = "Andry";
        List<String> listName = new ArrayList<>();
        //a) Создать список List из элементов массива и вывести на экран
        for (int i=0; i< name.length; i++){
            listName.add(name[i]);
        }
        System.out.println(" Первоначальный список имен :  "+listName);
        //b) Добавить 3 новых имени в список (Philip, Joseph, Leon) и вывести весь список на экран
        for (int i=0; i< nameAdd.length; i++) {
            listName.add(nameAdd[i]);
        }
        System.out.println("Список после добавления  имен: "+listName);
        //c) Удалить из списка все имена: Veronica, Leonid и вывести на экран
        for (int i=0; i< nameDel.length; i++) {
            listName.remove(nameDel[i]);
        }
        System.out.println(" Список  после удаления  имен: "+listName);
        //d) Поменять имя Helen на Elizabet
        listName.add(listName.indexOf(nameExch[0]),nameExch[1]);
        listName.remove(nameExch[0]);
        System.out.println(" Список  после  замены   имен: " +listName);
        //e) Отсортировать имена по алфавиту и вывести на экран
        Collections.sort(listName);
        System.out.println("Список отсортирован по А дл Я: "+listName);
        //f) Отсортировать имена в обратном порядке и вывести имена на экран
        Collections.reverse(listName);
        System.out.println("Список отсортирован по Я дл А: "+listName );
        //i) Проверить, содержит ли список имя Andry
        System.out.println("Список содержит имя "+ nameSerch+ ": "+listName.equals(nameSerch));
        //j) Удалить из списка все имена кроме Kate и Helen
        for (int i=0; i< nameLeave.length; i++){
            while(listName.remove(nameLeave[i])) {}
        }
        System.out.println("Список имен после удалени: "+listName );
    }

}
