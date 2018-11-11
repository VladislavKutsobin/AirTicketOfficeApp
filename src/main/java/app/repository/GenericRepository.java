package main.java.app.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {
    void insert(T t) throws IOException;
    void delete(ID id);
    List<T> findAll() throws FileNotFoundException, IOException;

    T getById(ID id);
}
