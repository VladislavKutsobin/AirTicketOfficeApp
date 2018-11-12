package main.java.app.repository.io;

import main.java.app.model.Passenger;
import main.java.app.repository.PassengerRepository;

import java.io.*;
import java.util.List;

public class PassengerRepositoryImpl implements PassengerRepository {
    private static String FILE_PASSENGER_PATH = "src/main/resources/passengers.csv";

    @Override
    public void insert(Passenger passenger) throws IOException {
        File fileWithPassengers = new File(FILE_PASSENGER_PATH);
        FileWriter fw = new FileWriter(fileWithPassengers, true);
        try(BufferedWriter bw = new BufferedWriter(fw)) {
            String PassengerToStringRepresentation = passenger.getId() + "," + passenger.getFirstName() + "," +
                    passenger.getLastName() + "," + passenger.getAge();
            bw.write(PassengerToStringRepresentation);
            bw.newLine();
        }
    }

    @Override
    public void delete(Integer integer) throws IOException {

    }

    @Override
    public List<Passenger> findAll() throws FileNotFoundException, IOException {
        return null;
    }

    @Override
    public Passenger getById(Integer integer) throws IOException {
        return null;
    }
}
