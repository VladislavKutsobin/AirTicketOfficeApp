package main.java.app.repository;

import main.java.app.model.Flight;
import main.java.app.model.Passenger;
import main.java.app.model.Ticket;

public interface TicketRepository extends GenericRepository<Ticket, Integer> {
    Ticket buyTicket(Flight flight, Passenger passenger);
    boolean returnTicket(Integer id);
}
