package com.yavoric.lesson14;
        import com.yavoric.lesson14.task6.PhoneNumber;

        import java.util.*;
        import java.util.Map.Entry;

public class PersonMain {
    public static void main(String[] args) {
        personExr();
        PhoneNumber asd = new PhoneNumber();
        System.out.println ("Телефонный номер = "+asd.getFullPnoneNumber());




    }

    private static void personExr() {
        Person[] personArr = new Person[100];
        fillPersonsRandom(personArr);
       // System.out.println (Arrays.toString(personArr));
        List<Person> personList = new ArrayList<>(Arrays.asList(personArr));
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        Map<Long, Person> personMap = new HashMap<>();
        for (int i = 0; i<personArr.length; i++){
            personMap.put(personArr[i].getId(),personArr[i]);
        }
        System.out.println( "ПЕрсон мап"+personMap);
        for (Map.Entry<Long, Person> entry : personMap.entrySet()){
            System.out.println("id->"+entry.getKey());
            System.out.println("person->"+entry.getValue());
            System.out.println("__________________________");
        }

            //personList.sort(Person::compareTo);
        personList.sort((p1,p2)-> (p1.getName().compareTo(p2.getName())));
        //personList.sort((a1)->Character.compare()
            //System.out.println(personList);
            for (Person p : personList) {
                if (p.getAge() > 20 && p.getAge() < 50)
                    System.out.println(p);
            }


    }




    private static void fillPersonsRandom(Person[] personArr) {
        String[] names = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max"};
        final int ageFrom = 10;
        final int ageTo = 90;
        long id = 123456;

        for (int i = 0; i < personArr.length; i++) {
            id++;
            int nameIndex = (int) (Math.random() * names.length);
            String name = names[nameIndex];
            int age = ageFrom + (int) (Math.random() * (ageTo - ageFrom));
            personArr[i] = new Person(id, name, age);
        }
    }

}
