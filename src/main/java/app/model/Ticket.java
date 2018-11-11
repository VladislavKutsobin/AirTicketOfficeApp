package main.java.app.model;

import java.util.Date;

public class Ticket extends BaseEntity {
    private Flight flight;
    private Passenger passenger;
    private String dateCreated;

    public Ticket(int id, Flight flight, Passenger passenger) {
        super(id);
        this.flight = flight;
        this.passenger = passenger;
        Date dateCreated = new Date();
        this.dateCreated = dateCreated.toString();
    }

}
