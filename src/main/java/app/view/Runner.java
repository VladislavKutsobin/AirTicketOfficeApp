package main.java.app.view;

import main.java.app.model.Flight;
import main.java.app.repository.FlightRepository;
import main.java.app.repository.io.FlightRepositoryImpl;

import java.io.IOException;
import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepositoryImpl();
        Flight flight = new Flight(2, "Moscow", "Barcelona", "Boeing Dreamliner",
                30, 10, "Nov 13 2018");
        /*try {
            flightRepository.insert(flight);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            System.out.println(flightRepository.searchByDeparture("Moscow"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
