package main.java.app.repository.io;

import main.java.app.model.Passenger;
import main.java.app.repository.PassengerRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepositoryImpl implements PassengerRepository {
    private static final String FILE_PASSENGER_PATH = "src/main/resources/passengers.csv";

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
        File fileWithPassengers = new File(FILE_PASSENGER_PATH);
        FileReader fr = new FileReader(fileWithPassengers);
        List<String> passengersList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                String [] splitArray = line.split(",");
                if(splitArray[0].equals(Integer.toString(integer))) {
                    continue;
                } else {
                    passengersList.add(line);
                }
            }

            FileWriter fw = new FileWriter(fileWithPassengers, false);
            try(BufferedWriter bw = new BufferedWriter(fw)) {
                for(String str : passengersList) {
                    bw.write(str + "\n");
                }
            }
        }
    }

    @Override
    public List<Passenger> findAll() throws FileNotFoundException, IOException {
        File fileWithFlights = new File(FILE_PASSENGER_PATH);
        FileReader fr = new FileReader(fileWithFlights);
        List<String> linesList = new ArrayList<>();
        List<Passenger> passengersList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine()) != null) {
                linesList.add(line);
            }

            for(String lineInList : linesList) {
                String[] lineSplitArray = lineInList.split(",");
                passengersList.add(new Passenger(Integer.parseInt(lineSplitArray[0]),
                        lineSplitArray[1],
                        lineSplitArray[2],
                        Integer.parseInt(lineSplitArray[3])));
            }
        }
        return passengersList;
    }

    @Override
    public Passenger getById(Integer integer) throws IOException {
        File file = new File(FILE_PASSENGER_PATH);
        FileReader fr = new FileReader(file);
        try(BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine())!=null) {
                String [] PassengerInfoArray = line.split(",");
                String PassengerIdStr = PassengerInfoArray[0];
                if(PassengerIdStr.equals(Integer.toString(integer))) {
                    Integer passengerId = Integer.parseInt(PassengerIdStr);
                    String passengerFirstName = PassengerInfoArray[1];
                    String passengerLastName = PassengerInfoArray[2];
                    Integer passengerAge = Integer.parseInt(PassengerInfoArray[3]);

                    return new Passenger(
                            passengerId,
                            passengerFirstName,
                            passengerLastName,
                            passengerAge
                    );
                }

            }
        }
        return null;

    }
}
