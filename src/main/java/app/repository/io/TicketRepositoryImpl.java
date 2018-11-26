package main.java.app.repository.io;

import main.java.app.model.Flight;
import main.java.app.model.Passenger;
import main.java.app.model.Ticket;
import main.java.app.repository.FlightRepository;
import main.java.app.repository.PassengerRepository;
import main.java.app.repository.TicketRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {
    private static final String FILE_TICKETS_PATH= "src/main/resources/tickets.csv";

    @Override
    public void insert(Ticket ticket) throws IOException {
        File fileWithTickets = new File(FILE_TICKETS_PATH);
        FileWriter fw = new FileWriter(fileWithTickets, true);
        try(BufferedWriter bw = new BufferedWriter(fw)) {
            String TictetToStrRepresenation = ticket.getId() +
                    "," + ticket.getFlight().getId() +
                    "," + ticket.getPassenger().getId() +
                    "," + ticket.getCls();
            bw.write(TictetToStrRepresenation);
            bw.newLine();
        }
    }

    @Override
    public void delete(Integer integer) throws IOException {
        File fileWithTickets = new File(FILE_TICKETS_PATH);
        FileReader fr = new FileReader(fileWithTickets);
        List<String> ticketList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                String[] splitLineArray = line.split(",");
                if(splitLineArray[0].equals(Integer.toString(integer))) {
                    continue;
                } else {
                    ticketList.add(line);
                }
            }
        }

        FileWriter fw = new FileWriter(fileWithTickets);
        try(BufferedWriter bw = new BufferedWriter(fw)) {
            for(String string : ticketList) {
                bw.write(string + "\n");
            }
        }
    }

    @Override
    public List<Ticket> findAll() throws FileNotFoundException, IOException {
        File fileWithTickets = new File(FILE_TICKETS_PATH);
        FileReader fr = new FileReader(fileWithTickets);
        List<String> linesList = new ArrayList<>();
        List<Ticket> ticketsList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                linesList.add(line);

                for(String lineInList : linesList) {
                    String[] splitLineArray = lineInList.split(",");

                    //--------------------------------------TICKET.ID---------------------------------------------------

                    Integer ticketId = Integer.parseInt(splitLineArray[0]);
                    String clsInTicket = splitLineArray[3];

                    //--------------------------------------FLIGHT.ID---------------------------------------------------

                    Integer flightId = Integer.parseInt(splitLineArray[1]);
                    FlightRepository flightRepository = new FlightRepositoryImpl();
                    Flight flight = flightRepository.getById(flightId);

                    //--------------------------------------PASSENGER.ID------------------------------------------------

                    Integer passengerId = Integer.parseInt(splitLineArray[2]);
                    PassengerRepository passengerRepository = new PassengerRepositoryImpl();
                    Passenger passenger = passengerRepository.getById(passengerId);

                    //--------------------------------------------------------------------------------------------------

                    ticketsList.add(new Ticket(
                            ticketId,
                            flight,
                            passenger,
                            clsInTicket
                    ));
                }
            }
        }
        return ticketsList;
    }

    @Override
    public Ticket getById(Integer integer) throws IOException {
        File fileWithTickets = new File(FILE_TICKETS_PATH);
        FileReader fr = new FileReader(fileWithTickets);
        String line;

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                String[] splitLineArray = line.split(",");
                Integer ticketId = Integer.parseInt(splitLineArray[0]);

                if(ticketId.equals(integer)) {
                    String clsInTicket = splitLineArray[3];

                    Integer flightId = Integer.parseInt(splitLineArray[1]);
                    FlightRepository flightRepository = new FlightRepositoryImpl();
                    Flight flight = flightRepository.getById(flightId);

                    Integer passengerId = Integer.parseInt(splitLineArray[2]);
                    PassengerRepository passengerRepository = new PassengerRepositoryImpl();
                    Passenger passenger = passengerRepository.getById(passengerId);

                    return new Ticket(
                            ticketId,
                            flight,
                            passenger,
                            clsInTicket
                    );
                }
            }
        }

        return null;
    }
}
