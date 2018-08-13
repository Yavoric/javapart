package com.yavoric.lesson14.task6;

import java.util.Objects;
public class Subscriber implements Comparable<Subscriber> {
    private Long id; 				// уникальный идентификатор
    private String firstName; 	// имя
    private String lastName;  	// фамилия
    private int age; 				// возраст
    private String phoneNumber; 	// телефонный номер (12 цифр: 380509373356)
    public  void equals(){


    }
    public Subscriber(long id, String firstName, String lastName, int age, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return id+firstName +lastName+age+lastName+age+phoneNumber;
    }
    /*@Override
    public  boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber subscriber = (Subscriber) o;
        return id == Subscriber.id &&
                age == Subscriber.age &&
                Objects.equals(firstName, subscriber.firstName);

    }*/
    @Override
    public int compareTo(Subscriber o) {
        if (this.id > o.id)
            return -1;

        if (this.id < o.id)
            return 1;

        return 0;

    }

}
