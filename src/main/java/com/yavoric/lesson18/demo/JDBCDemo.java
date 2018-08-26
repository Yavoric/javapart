package com.yavoric.lesson18.demo;
import com.yavoric.lesson18.dao.AbonentDao;
import com.yavoric.lesson18.dao.impl.jdbc.AbonentDaoImpl;
import com.yavoric.lesson18.model.Abonent;
import com.yavoric.lesson18.model.Gender;

public class JDBCDemo {
    public static void main(String[] args) {
        demoReadAbonents();
        demoInsertAbonents();
    }

    private static void demoReadAbonents() {
        AbonentDao abonentDao = new AbonentDaoImpl();
        abonentDao.getAll().stream()
                .forEach(System.out::println);
    }
    private static void demoInsertAbonents() {
        AbonentDao abonentDao = new AbonentDaoImpl();
        Abonent abonent = new Abonent();
        abonent.setFirstName("first_name");
        abonent.setLastName("last_name");
        abonent.setAge(19);
        abonent.setGender(Gender.FEMALE);

        abonentDao.save(abonent);
    }
}