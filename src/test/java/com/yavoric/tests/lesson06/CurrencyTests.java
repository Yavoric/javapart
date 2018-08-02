package com.yavoric.tests.lesson06;

import com.yavoric.lesson06.task.Currency;
import com.yavoric.lesson06.test.CurrencyTestData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CurrencyTests {

    @Test
    public void constructorTest() {
        // ******test data******
        // 1 Способ - используем сырой массив

//        int[] values = {10, 0, -3};
//        String[] names = {"руб", "грн", "$"};

        // 2 Способ - используем вспомогательный класс 'CurrencyTestData'
        CurrencyTestData[] positiveTestData = new CurrencyTestData[]{
                new CurrencyTestData(10, "руб"),
                new CurrencyTestData(0, "грн"),
                new CurrencyTestData(-3, "$")
        };

        CurrencyTestData[] negativeTestData = new CurrencyTestData[]{
                new CurrencyTestData(10, ""),
                new CurrencyTestData(0, "@"),
                new CurrencyTestData(-3, "euro")
        };

        // test logic
        for (int i = 0; i < positiveTestData.length; i++) {
//            Currency cur = new Currency(values[i], names[i]);
//            assert cur.getValue() == values[i];
//            assert cur.getName().equals(names[i]);

            String name = positiveTestData[i].getName();
            double value = positiveTestData[i].getValue();

            Currency cur = new Currency(value, name);
            Assert.assertEquals(cur.getValue(), value);
            Assert.assertEquals(cur.getName(), name);
            Assert.assertEquals((double) 1, 1.0);
            Assert.assertTrue(cur.isValid());
        }

        System.out.println("Check negative: ");
        for (int i = 0; i < negativeTestData.length; i++) {
//            Currency cur = new Currency(values[i], names[i]);
//            assert cur.getValue() == values[i];
//            assert cur.getName().equals(names[i]);

            String name = negativeTestData[i].getName();
            double value = negativeTestData[i].getValue();

            System.out.println("Name: " + name);
            System.out.println("Value: " + value);

            Currency cur = new Currency(value, name);
            assert !cur.isValid();

        }
    }

    public void copyConstructorTest() {
    }

    public void isEqualTest() {
        Currency cur1 = new Currency(10, "руб");
        Currency cur2 = new Currency(10, "руб");
        Currency cur3 = new Currency(11, "руб");

        assert cur1.isEqual(cur2);
        assert !cur1.isEqual(cur3);
    }

    public void testConstructorUsingObject() {
        // ******test data******
        // 1 Способ - используем сырой массив

//        int[] values = {10, 0, -3};
//        String[] names = {"руб", "грн", "$"};

        // 2 Способ - используем полиморфизм
//        Object[] arr1 = {10, "руб"};
//        Object[] arr2 = {0, "грн"};
//        Object[] arr3 = {-3, "$"};
//
//        Object[][] data_old = {
//                arr1,
//                arr2,
//                arr3
//        };

        Object[][] positiveTestData = {
                {10, "руб"},
                {0, "грн"},
                {-3, "$"}
//            new Object[] {-3, "$"},
        };

        Object[][] negativeTestData = {
                {10, "@"},
                {0, ""},
                {-3.0, "uah"}
//            new Object[] {-3, "$"},
        };

        // test logic
        for (int i = 0; i < positiveTestData.length; i++) {
//            Currency cur = new Currency(values[i], names[i]);
//            assert cur.getValue() == values[i];
//            assert cur.getName().equals(names[i]);

            String name = (String)positiveTestData[i][1];
            double value =  ((Number)positiveTestData[i][0]).doubleValue();

            Currency cur = new Currency(value, name);
            assert cur.getValue() == value;
            assert cur.getName().equals(name);
            assert cur.isValid();
        }

        for (int i = 0; i < negativeTestData.length; i++) {
//            Currency cur = new Currency(values[i], names[i]);
//            assert cur.getValue() == values[i];
//            assert cur.getName().equals(names[i]);

            String name = (String)negativeTestData[i][1];
            double value = ((Number)negativeTestData[i][0]).doubleValue();

            Currency cur = new Currency(value, name);
            assert !cur.isValid();

        }
    }
}