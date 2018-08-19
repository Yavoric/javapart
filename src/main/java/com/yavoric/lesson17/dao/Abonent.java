package com.yavoric.lesson17.dao;

import java.util.Objects;

public class Abonent {
    private long abonent_id; 		// уникальный идентификатор
	private String firstName; 	// имя
	private String lastName;  	// фамилия
	private int age; 				// возраст
	private Enum gender; //пол

    public Abonent(long abonent_id, String firstName, String lastName, int age, Enum gender) {
        this.abonent_id = abonent_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public long getAbonent_id() {
        return abonent_id;
    }

    public void setAbonent_id(long abonent_id) {
        this.abonent_id = abonent_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Enum getGender() {
        return gender;
    }

    public void setGender(Enum gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "abonent_id=" + abonent_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonent abonent = (Abonent) o;
        return abonent_id == abonent.abonent_id;
    }
    public int compareTo(Abonent o) {
        if (this.abonent_id > o.abonent_id)
            return -1;

        if (this.abonent_id < o.abonent_id)
            return 1;

        return 0;

    }
}
