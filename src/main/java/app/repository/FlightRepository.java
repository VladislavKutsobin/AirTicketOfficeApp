package main.java.app.repository;
import main.java.app.model.Flight;
import main.java.app.model.Passenger;

import java.util.List;

public interface FlightRepository extends GenericRepository<Flight, Integer> {

    List<Flight> searchByDeparture(String departurePoint);
    List<Flight> searchByArrival(String arrivalPoint);
    List<Flight> searchByDate(String date);
}
