package main.java.app.model;

public class Ticket extends BaseEntity {
    private String description;

    public Ticket(int id, Flight flight, Passenger passenger) {
        super(id);
        this.description = "Passengerr, " + passenger.getFirstName() + passenger.getLastName() + ", we are waiting for" +
                " You on flight " + flight.getPlane() + " " + flight.getDate() ;
    }

}
