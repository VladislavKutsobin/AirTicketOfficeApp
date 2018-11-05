package main.java.app.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    void insert(T t);
    void delete(ID id);
    List<T> findAll();

    T getById();
}
