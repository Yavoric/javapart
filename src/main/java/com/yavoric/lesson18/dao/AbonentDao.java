package com.yavoric.lesson18.dao;
import com.yavoric.lesson18.model.Abonent;

import java.util.List;

public interface AbonentDao {
    boolean save(Abonent abonent);
    boolean remove(Abonent abonent);
    List<Abonent> getAll();
    Abonent findById(long id);
}