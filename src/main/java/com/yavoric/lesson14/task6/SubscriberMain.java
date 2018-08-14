package com.yavoric.lesson14.task6;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Map.Entry;
public class SubscriberMain {
    public static void main(String[] args) {
        personExr();
    }
    private static void personExr() {
        Subscriber[] subscriberArr = new Subscriber[100];
        fillSubscriberRandom(subscriberArr);
        // System.out.println (Arrays.toString(personArr));
        //Из массива: исключить дубликаты, отсортировать по id, сохранить в список (List)
        streamCollect();

        List<Subscriber> subscribersList = new ArrayList<>(Arrays.asList(subscriberArr));
        for (int i = 0; i < subscribersList.size(); i++) {
            System.out.println(subscribersList.get(i));
        }
        Map<Long, Subscriber> subscriberMap = new HashMap<>();
        for (int i = 0; i<subscriberArr.length; i++){
            subscriberMap.put(subscriberArr[i].getId(),subscriberArr[i]);
        }
        System.out.println( "Абонент мап"+subscriberMap);
        for (Map.Entry<Long, Subscriber> entry : subscriberMap.entrySet()){
            System.out.println("id->"+entry.getKey());
            System.out.println("subscriber->"+entry.getValue());
            System.out.println("__________________________");
        }
        //subscribersList.sort(Subscriber::compareTo);
        //System.out.println(subscribersList);

    }
    private static void streamCollect() {
        Subscriber[] subscriberArr = new Subscriber[100];
        fillSubscriberRandom(subscriberArr);
        List<Subscriber> subscribersList =
                Arrays.stream(subscriberArr)
                        .distinct()
                        .sorted(Subscriber::compareTo)
                        .collect(Collectors.toList());

        System.out.println(subscribersList);
    }




    private static void fillSubscriberRandom(Subscriber[] subscriberArr) {
        String[] fName = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max"};
        String[] lName = {"Ivanov","Petrov","Sidorov","Frolov","Kirilov","Maksimov","Saidov","Vavilov","Zairov"};
        String[] number = {"0","1","2","3","4","5","6","7","8","9"};
        String elementaryPhoneNumber = "999";
        long id = 123456;
        final int ageFrom = 18;
        final int ageTo = 90;
        for (Subscriber s : subscriberArr) {
            subscriberArr[s].equals(id, ageFrom, ageTo,fName,lName, number, elementaryPhoneNumber);
        }

    }
}

