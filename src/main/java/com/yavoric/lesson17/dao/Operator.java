package com.yavoric.lesson17.dao;

import java.util.Objects;

public class Operator {
    private long operator_id;
	private String name;
	private int price;
	private String address;

    public Operator(long operator_id, String name, int price, String address) {
        this.operator_id = operator_id;
        this.name = name;
        this.price = price;
        this.address = address;
    }

    public long getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(long operator_id) {
        this.operator_id = operator_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return operator_id == operator.operator_id;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "operator_id=" + operator_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                '}';
    }
}
