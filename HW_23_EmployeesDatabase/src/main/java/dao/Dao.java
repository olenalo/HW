package dao;

import models.Department;

import java.util.List;

public interface Dao<T> {

    T get(long id);  // TODO handle null

    List<T> getAll();

    List<T> getAllOrdered(String orderBy);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
