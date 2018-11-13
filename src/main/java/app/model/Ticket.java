package main.java.app.model;

import java.util.Date;

public class Ticket extends BaseEntity {
    private Flight flight;
    private Passenger passenger;
    private String dateCreated;
    String cls;

    public Ticket(int id, Flight flight, Passenger passenger, String cls) {
        super(id);
        this.flight = flight;
        this.passenger = passenger;
        Date dateCreated = new Date();
        this.dateCreated = dateCreated.toString();
        this.cls = cls;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }
}
