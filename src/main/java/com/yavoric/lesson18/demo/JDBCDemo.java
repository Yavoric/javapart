package com.yavoric.lesson18.demo;
import com.yavoric.lesson18.dao.AbonentDao;
import com.yavoric.lesson18.dao.impl.jdbc.AbonentDaoImpl;

public class JDBCDemo {
    public static void main(String[] args) {
        demoReadAbonents();
    }

    private static void demoReadAbonents() {
        AbonentDao abonentDao = new AbonentDaoImpl();
        abonentDao.getAll().stream()
                .forEach(System.out::println);
    }
}