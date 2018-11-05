package main.java.app.repository;

import main.java.app.model.Passenger;

import java.util.List;

public interface PassengerRepository {
    void insert(Passenger passenger);
    void delete(int id);
    List<Passenger> findAll();

    Passenger getById(int id);

}
