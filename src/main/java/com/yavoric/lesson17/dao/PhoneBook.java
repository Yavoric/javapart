package com.yavoric.lesson17.dao;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Long> phoneBook;

    public PhoneBook(Map<String, Long> phoneBook) {
        this.phoneBook = phoneBook;
    }
    public boolean exists(String number, Long operator_id){ // существование номера у абонента
        return true;
    }
	public Set<String> getAllByNumber(Long operator_id){  // возвращает список номеров по абоненту
        return null;
    }
	public boolean add(String number, Long operator_id){   // добавляет новый номер (проверять формат - 12 цифр)
        return true;
    }
	public boolean remove(String number){  // удаляет номера для абонента
        return true;
    }
}
