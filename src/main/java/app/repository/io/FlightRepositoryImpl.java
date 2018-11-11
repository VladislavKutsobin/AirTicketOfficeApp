package main.java.app.repository.io;

import main.java.app.model.Flight;
import main.java.app.repository.FlightRepository;

import java.util.List;
import java.io.*;
import java.util.ArrayList;

public class FlightRepositoryImpl implements FlightRepository{
    private static final String FILE_PATH_FLIGHTS = "src/main/resources/flights.csv";

    @Override
    public List<Flight> searchByDeparture(String departurePoint) {
        return null;
    }

    @Override
    public List<Flight> searchByArrival(String arrivalPoint) {
        return null;
    }

    @Override
    public List<Flight> searchByDate(String date) {
        return null;
    }

    @Override
    public void insert(Flight flight) throws IOException  {
        File fileWithFlights = new File(FILE_PATH_FLIGHTS);
        FileWriter fw = new FileWriter(fileWithFlights, true);
        try(BufferedWriter bw = new BufferedWriter(fw)) {
            String FlightToStringRepresentation = flight.getId() + "," + flight.getDeparturePoint() + "," +
                    flight.getArrivalPoint() + "," + flight.getPlane() + "," + flight.getEconomClsCapacity() +
                    "," + flight.getBusinessClsCapacity() + "," + flight.getDate();
            bw.write(FlightToStringRepresentation);
            bw.newLine();
        }

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Flight> findAll() throws IOException {
        File fileWithFlights = new File(FILE_PATH_FLIGHTS);
        FileReader fr = new FileReader(fileWithFlights);
        List<String> linesList = new ArrayList<>();
        List<Flight> flightsList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine()) != null) {
                linesList.add(line);
            }

            for(String lineInList : linesList) {
                String[] arrSplitByComa = lineInList.split(",");
                flightsList.add(new Flight(Integer.parseInt(arrSplitByComa[0]), arrSplitByComa[1], arrSplitByComa[2],
                        arrSplitByComa[3], Integer.parseInt(arrSplitByComa[4]), Integer.parseInt(arrSplitByComa[5])));
            }
        }
        return flightsList;
    }

    @Override
    public Flight getById(Integer integer) {
        return null;
    }
}
