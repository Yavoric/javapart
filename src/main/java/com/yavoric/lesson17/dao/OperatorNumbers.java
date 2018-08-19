package com.yavoric.lesson17.dao;

import java.util.Map;
import java.util.Set;

public class OperatorNumbers {
    private Map<String, Long> operatorNumbers;

    public OperatorNumbers(Map<String, Long> operatorNumbers) {
        this.operatorNumbers = operatorNumbers;
    }
    public boolean exists(String number, Long operator_id){ // существование номера у оператора
        return true;
    }
	public Set<String> getAllByNumber(Long operator_id){ // возвращает список номеров по оператору
        return null;
    }
	public boolean add(String number, Long operator_id){ // добавляет новый номер (проверять формат - 12 цифр)
        return true;
    }
	public boolean remove(String number){ // удаляет номер
        return true;
    }

}
