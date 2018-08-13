package com.yavoric.lesson14.task6;
import java.util.*;
import java.util.Map.Entry;
public class SubscriberMain {
    public static void main(String[] args) {
        personExr();
    }
    private static void personExr() {
        Subscriber[] subscriberArr = new Subscriber[100];
        fillSubscriberRandom(subscriberArr);
        // System.out.println (Arrays.toString(personArr));
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




    private static void fillSubscriberRandom(Subscriber[] subscriberArr) {
        String[] fName = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max"};
        String[] lName = {"Ivanov","Petrov","Sidorov","Frolov","Kirilov","Maksimov","Saidov","Vavilov","Zairov"};
        PhoneNumber phoneNumber = new PhoneNumber();
        final int ageFrom = 18;
        final int ageTo = 90;
        long id = 123456;

        for (int i = 0; i < subscriberArr.length; i++) {
            id++;
            int fNameIndex = (int) (Math.random() * fName.length);
            int lNameIndex = (int) (Math.random() * lName.length);
            String firstName =fName[fNameIndex];
            String lastName = fName[lNameIndex];
            int age = ageFrom + (int) (Math.random() * (ageTo - ageFrom));
            subscriberArr[i] = new Subscriber(id, firstName,lastName, age, phoneNumber.getFullPnoneNumber());
        }
    }
}

