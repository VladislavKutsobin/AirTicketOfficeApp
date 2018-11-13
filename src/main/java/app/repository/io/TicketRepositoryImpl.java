package main.java.app.repository.io;

import main.java.app.model.Ticket;
import main.java.app.repository.TicketRepository;

import java.io.*;
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

    }

    @Override
    public List<Ticket> findAll() throws FileNotFoundException, IOException {
        return null;
    }

    @Override
    public Ticket getById(Integer integer) throws IOException {
        return null;
    }
}
