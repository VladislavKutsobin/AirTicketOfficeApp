package main.java.app.controller;

import main.java.app.model.Ticket;
import main.java.app.repository.FlightRepository;
import main.java.app.repository.TicketRepository;
import main.java.app.repository.io.FlightRepositoryImpl;
import main.java.app.repository.io.TicketRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class TicketController {
    TicketRepository ticketRepository = new TicketRepositoryImpl();
    FlightRepository flightRepository = new FlightRepositoryImpl();

    public List<Ticket> findAll() throws IOException {
        return ticketRepository.findAll();
    }

    public Ticket getById(Integer integer) throws IOException {
        if(integer == null || integer < 0) {
            throw new IllegalArgumentException();
        }
        return ticketRepository.getById(integer);
    }


    public void buyTicket(Ticket ticket) throws IOException {
        if(ticket == null)/* || !ticket.getCls().equals("B") || !ticket.getCls().equals("E")) */{
            throw new IllegalArgumentException();
        } else {
            ticketRepository.insert(ticket);
            flightRepository.decreaseClsCapacity(ticket.getFlight(), ticket.getCls());
        }
    }

    public void returnTicket(Ticket ticket) throws IOException {
        if(ticket == null) /*|| !ticket.getCls().equals("E") || !ticket.getCls().equals("B"))*/ {
            throw new IllegalArgumentException();
        } else {
            //System.out.println(ticket.getId());
            ticketRepository.delete(ticket.getId());
            flightRepository.increaseClsCapacity(ticket.getFlight(), ticket.getCls());
        }
    }
}
