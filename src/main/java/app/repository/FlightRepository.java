package main.java.app.repository;
import main.java.app.model.Flight;
import main.java.app.model.Passenger;

import java.io.IOException;
import java.util.List;

public interface FlightRepository extends GenericRepository<Flight, Integer> {

    List<Flight> searchByDeparture(String departurePoint) throws IOException;
    List<Flight> searchByArrival(String arrivalPoint) throws IOException;
    List<Flight> searchByDate(String date) throws IOException;
    void decreaseClsCapacity(Flight flight, String cls) throws IOException;
    void increaseClsCapacity(Flight flight, String cls) throws IOException;
}
