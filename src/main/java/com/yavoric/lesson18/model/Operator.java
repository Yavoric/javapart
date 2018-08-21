package com.yavoric.lesson18.model;
import java.util.*;
import java.math.BigDecimal;

public class Operator {
    private long operatorId;
	private String name;
    private BigDecimal fee; // aбонплата
	private String address;
	private List<String> phoneNumbers; // Список телефонных номеров

    public Operator(long operatorId, String name, BigDecimal fee, String address, List<String> phoneNumbers) {
        this.operatorId = operatorId;
        this.name = name;
        this.fee = fee;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(long operatorId) {
        this.operatorId = operatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "operatorId=" + operatorId +
                ", name='" + name + '\'' +
                ", fee=" + fee +
                ", address='" + address + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return operatorId == operator.operatorId;
    }


}
