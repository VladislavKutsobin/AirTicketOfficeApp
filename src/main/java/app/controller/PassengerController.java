package main.java.app.controller;

import main.java.app.model.Passenger;
import main.java.app.repository.PassengerRepository;
import main.java.app.repository.io.PassengerRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class PassengerController {
    PassengerRepository passengerRepository = new PassengerRepositoryImpl();

    public void insert(Passenger passenger) throws IOException {
        if(passenger == null) {
            throw new IllegalArgumentException();
        } else {
            passengerRepository.insert(passenger);
        }
    }

    public List<Passenger> findAll() throws IOException {
        return passengerRepository.findAll();
    }

    public void delete(Integer integer) throws IOException {
        if(integer == null || integer < 0) {
            throw new IllegalArgumentException();
        } else {
            passengerRepository.delete(integer);
        }
    }

    public Passenger getById(Integer integer) throws IOException {
        if(integer == null || integer < 0) {
            throw new IllegalArgumentException();
            }
        return passengerRepository.getById(integer);
    }
}
