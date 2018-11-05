package main.java.app.repository;
import main.java.app.model.Flight;
import main.java.app.model.Passenger;

import java.util.List;

public interface FlightRepository {
    Flight searchByDeparture(String departurePoint);
    Flight searchByArrival(String arrivalPoint);
    Flight searchByDate(String date);
    List<Flight> showAllFlights();
    boolean buyTicket(Flight flight, Passenger passenger);
    boolean returnTicket(int id);
}
