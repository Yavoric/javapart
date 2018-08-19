package com.yavoric.lesson17.dao;

import java.util.List;
import java.util.Map;

public class Operators {
    private Map<Long, Operator> operators;

    public Operators(Map<Long, Operator> operators) {
        this.operators = operators;
    }
    public   Operator getById(long operator_id){
        return null;
    }
	public List<Operator> getAll(){// возвращает всех операторов в виде списка
        return null;
    }
	public boolean add(Operator operator){// добавляет нового оператора
        return true;
    }
	public boolean remove(long operator_id){
        return true;
    }
	public boolean edit(long operator_id, Operator operator){
        return true;
    }
}

