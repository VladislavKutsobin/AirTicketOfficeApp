package main.java.app.view;

import main.java.app.model.Flight;
import main.java.app.repository.FlightRepository;
import main.java.app.repository.io.FlightRepositoryImpl;

import java.io.IOException;
import java.util.Date;

public class Runner {
    public static void main(String[] args) throws IOException {
        FlightRepository flightRepository = new FlightRepositoryImpl();
        Flight flight = new Flight(2, "Moscow", "Barcelona", "Boeing Dreamliner",
                30, 10, "Nov 13 2018");
        //flightRepository.insert(flight);
        flightRepository.decreaseClsCapacity(flight, "B");
    }
}
