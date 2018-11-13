package main.java.app.view;

import main.java.app.model.Flight;
import main.java.app.model.Passenger;
import main.java.app.model.Ticket;
import main.java.app.repository.FlightRepository;
import main.java.app.repository.PassengerRepository;
import main.java.app.repository.TicketRepository;
import main.java.app.repository.io.FlightRepositoryImpl;
import main.java.app.repository.io.PassengerRepositoryImpl;
import main.java.app.repository.io.TicketRepositoryImpl;

import java.io.IOException;
import java.util.Date;

public class Runner {
    public static void main(String[] args) throws IOException {
        FlightRepository flightRepository = new FlightRepositoryImpl();
        Flight flight = new Flight(1, "Moscow", "Barcelona", "Boeing Dreamliner",
                30, 10, "Nov 13 2018");
        PassengerRepository passengerRepository = new PassengerRepositoryImpl();
        Passenger passenger = new Passenger(1,"Vladislav","Kutsobin",24);

        //flightRepository.insert(flight);
        //passengerRepository.insert(passenger);

        TicketRepository ticketRepository = new TicketRepositoryImpl();
        Ticket ticket = new Ticket(1, flight, passenger, "B");

        ticketRepository.insert(ticket);
        flightRepository.decreaseClsCapacity(ticket.getFlight(),ticket.getCls());

    }
}
