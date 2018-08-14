package com.yavoric.lesson14.task6;

import java.util.Objects;
public class Subscriber implements Comparable<Subscriber> {
    private Long id; 				// уникальный идентификатор
    private String firstName; 	// имя
    private String lastName;  	// фамилия
    private int age; 				// возраст
    private String phoneNumber; 	// телефонный номер (12 цифр: 380509373356)
    public void setId(Long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPhoneNumber(String[] number, String elementaryPhoneNumber, String phoneNumber) {
        phoneNumber = elementaryPhoneNumber;
        for (int i =0; i<8;i++){
            int c = (int) (Math.random()* 9);
            phoneNumber = phoneNumber+number[c];
        }
        phoneNumber = phoneNumber+"5";
        this.phoneNumber = phoneNumber;
    }
    public Long getId() {
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public  void equals1(long nId,int ageFrom,int ageTo,String[] fName,String[] lName,
                        String[] number, String elementaryPhoneNumber){
        nId ++;
        this.id = nId;
        int fId = 0;
        fId = (int) (Math.random() * (fName.length - 1));
        this.firstName = fName[fId];
        fId = 0;
        fId = (int) (Math.random() * lName.length - 1);
        this.lastName = lName[fId];
        int nage = ageFrom + (int) (Math.random() * (ageTo - ageFrom));
        this.age = nage;
        phoneNumber = elementaryPhoneNumber;
        for (int i =0; i<8;i++){
            int c = (int) (Math.random()* 9);
            phoneNumber = phoneNumber+number[c];
        }
        this.phoneNumber = phoneNumber+"5";

    }
    public Subscriber(long id, String firstName, String lastName, int age, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }






    @Override
    public String toString() {
        return "ID:"+id+" Имя:"+firstName +" Фамилия:"+lastName+" Возраст:"+age+" Телефонный номер:"+phoneNumber;
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
