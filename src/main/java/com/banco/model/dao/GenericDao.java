package com.banco.model.dao;

import java.util.List;

public interface GenericDao<T> {
    void save(T t);
    void delete(T t);
    void alter(T t);
    List<T> findAll(Class<T> type);
}
