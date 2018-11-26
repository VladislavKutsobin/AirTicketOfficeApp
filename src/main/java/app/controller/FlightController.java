package main.java.app.controller;

import main.java.app.model.Flight;
import main.java.app.repository.FlightRepository;
import main.java.app.repository.io.FlightRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class FlightController {
    FlightRepository flightRepository = new FlightRepositoryImpl();

    public void insert(Flight flight) throws IOException {
        if(flight == null) {
            throw new IllegalArgumentException();
        } else {
            flightRepository.insert(flight);
        }
    }

    public List<Flight> findAll() throws IOException {
        return flightRepository.findAll();
    }

    public void delete(Integer integer) throws IOException {
        if(integer == null || integer < 0) {
            throw new IllegalArgumentException();
        } else {
            flightRepository.delete(integer);
        }
    }

    public Flight getById(Integer integer) throws IOException {
        if(integer == null || integer < 0) {
            throw new IllegalArgumentException();
        }
        return flightRepository.getById(integer);
    }

    public List<Flight> searchByParams(String departurePoint, String arrivalPoint, String startDate, String endDate)
        throws IOException {
        if(departurePoint == null || arrivalPoint == null || startDate == null || endDate == null) {
            throw new IllegalArgumentException();
        }

        return flightRepository.searcheByAllParams(departurePoint, arrivalPoint, startDate, endDate);
    }
}
