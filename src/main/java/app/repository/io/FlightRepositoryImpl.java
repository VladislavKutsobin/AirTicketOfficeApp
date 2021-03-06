package main.java.app.repository.io;

import com.sun.xml.internal.bind.v2.TODO;
import main.java.app.model.Flight;
import main.java.app.repository.FlightRepository;

import java.net.Inet4Address;
import java.util.Date;
import java.util.List;
import java.io.*;
import java.util.ArrayList;

public class FlightRepositoryImpl implements FlightRepository{
    private static final String FILE_PATH_FLIGHTS = "src/main/resources/flights.csv";

    @Override
    public List<Flight> searchByDeparture(String departurePoint) throws IOException {
        File fileWithFlights = new File(FILE_PATH_FLIGHTS);
        FileReader fr = new FileReader(fileWithFlights);
        String line;
        List<Flight> flightsByDepartureList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                String[] lineSplitArray = line.split(",");
                if(lineSplitArray[1].equals(departurePoint)) {
                    Integer flightId = Integer.parseInt(lineSplitArray[0]);
                    String flightDeparturePoint = lineSplitArray[1];
                    String flightArrivalPoint = lineSplitArray[2];
                    String flightPlaneInfo = lineSplitArray[3];
                    Integer flightEconomClsCapacity = Integer.parseInt(lineSplitArray[4]);
                    Integer flightBusinessClsCapacity = Integer.parseInt(lineSplitArray[5]);
                    String flightDate = lineSplitArray[6];
                    flightsByDepartureList.add(new Flight(
                            flightId,
                            flightDeparturePoint,
                            flightArrivalPoint,
                            flightPlaneInfo,
                            flightEconomClsCapacity,
                            flightBusinessClsCapacity,
                            flightDate
                    ));
                }
            }
        }

        return flightsByDepartureList;
    }

    @Override
    public List<Flight> searchByArrival(String arrivalPoint) throws IOException {
        File fileWithFlights = new File(FILE_PATH_FLIGHTS);
        FileReader fr = new FileReader(fileWithFlights);
        String line;
        List<Flight> flightsByArrivalList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                String[] lineSplitArray = line.split(",");
                if(lineSplitArray[2].equals(arrivalPoint)) {
                    Integer flightId = Integer.parseInt(lineSplitArray[0]);
                    String flightDeparturePoint = lineSplitArray[1];
                    String flightArrivalPoint = lineSplitArray[2];
                    String flightPlaneInfo = lineSplitArray[3];
                    Integer flightEconomClsCapacity = Integer.parseInt(lineSplitArray[4]);
                    Integer flightBusinessClsCapacity = Integer.parseInt(lineSplitArray[5]);
                    String flightDate = lineSplitArray[6];
                    flightsByArrivalList.add(new Flight(
                            flightId,
                            flightDeparturePoint,
                            flightArrivalPoint,
                            flightPlaneInfo,
                            flightEconomClsCapacity,
                            flightBusinessClsCapacity,
                            flightDate
                    ));
                }
            }
        }

        return flightsByArrivalList;
    }

    @Override
    public List<Flight> searchByDate(String date) throws IOException {
        File fileWithFlights = new File(FILE_PATH_FLIGHTS);
        FileReader fr = new FileReader(fileWithFlights);
        String line;
        List<Flight> flightsByDateList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                String[] lineSplitArray = line.split(",");
                if(lineSplitArray[6].equals(date)) {
                    Integer flightId = Integer.parseInt(lineSplitArray[0]);
                    String flightDeparturePoint = lineSplitArray[1];
                    String flightArrivalPoint = lineSplitArray[2];
                    String flightPlaneInfo = lineSplitArray[3];
                    Integer flightEconomClsCapacity = Integer.parseInt(lineSplitArray[4]);
                    Integer flightBusinessClsCapacity = Integer.parseInt(lineSplitArray[5]);
                    String flightDate = lineSplitArray[6];
                    flightsByDateList.add(new Flight(
                            flightId,
                            flightDeparturePoint,
                            flightArrivalPoint,
                            flightPlaneInfo,
                            flightEconomClsCapacity,
                            flightBusinessClsCapacity,
                            flightDate
                    ));
                }
            }
        }

        return flightsByDateList;
    }

    @Override
    public List<Flight> searcheByAllParams(String departurePoint, String arrivalPoint, String startDate, String endDate)
            throws IOException {
        File fileWithFlights = new File(FILE_PATH_FLIGHTS);
        FileReader fr = new FileReader(fileWithFlights);
        List<Flight> flightsByParamsList = new ArrayList<>();
        List<String> flightByDepartureAndArrival = new ArrayList<>();
        String line;
        String[] startDateArray = startDate.split(":");
        String[] endDateArray = endDate.split(":");
        int startDateDay = Integer.parseInt(startDateArray[0]);
        int startDateMonth = Integer.parseInt(startDateArray[1]);
        int startDateYear = Integer.parseInt(startDateArray[2]);
        int endDateDay = Integer.parseInt(endDateArray[0]);
        int endDateMonth = Integer.parseInt(endDateArray[1]);
        int endDateYear = Integer.parseInt(endDateArray[2]);

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                String[] lineSplitArray = line.split(",");

                if((lineSplitArray[1].equals(departurePoint)) && (lineSplitArray[2].equals(arrivalPoint))) {
                    flightByDepartureAndArrival.add(line);
                } else {
                    continue;
                }
            }

            for(String lineInArray : flightByDepartureAndArrival) {
                String[] lineInArraySplit = lineInArray.split(",");
                String[] flightDateSplitOnDDMMYY = lineInArraySplit[6].split(":");

                int flightId = Integer.parseInt(lineInArraySplit[0]);
                String flightDeparturePoint = lineInArraySplit[1];
                String flightArrivalPoint = lineInArraySplit[2];
                String flightPlaneInfo = lineInArraySplit[3];
                int flightEconomClsCapacity = Integer.parseInt(lineInArraySplit[4]);
                int flightBusinessClsCapacity = Integer.parseInt(lineInArraySplit[5]);
                String flightDate = lineInArraySplit[6];

                int day = Integer.parseInt(flightDateSplitOnDDMMYY[0]);
                int month = Integer.parseInt(flightDateSplitOnDDMMYY[1]);
                int year = Integer.parseInt(flightDateSplitOnDDMMYY[2]);

                if((day>=startDateDay) && (day<=endDateDay)) {
                    if((month>=startDateMonth) && (month<=endDateMonth)) {
                        if((year>=startDateYear) && (year<=endDateYear)) {
                            flightsByParamsList.add(new Flight(
                                    flightId,
                                    flightDeparturePoint,
                                    flightArrivalPoint,
                                    flightPlaneInfo,
                                    flightEconomClsCapacity,
                                    flightBusinessClsCapacity,
                                    flightDate
                            ));
                        }
                    }
                }
            }
        }
        return flightsByParamsList;
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
    public void delete(Integer integer) throws IOException{
        File fileWithFlights = new File(FILE_PATH_FLIGHTS);
        FileReader fr = new FileReader(fileWithFlights);
        List<String> flightsList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                String [] splitArray = line.split(",");
                if(splitArray[0].equals(Integer.toString(integer))) {
                    continue;
                } else {
                    flightsList.add(line);
                }
            }

            FileWriter fw = new FileWriter(fileWithFlights, false);
            try(BufferedWriter bw = new BufferedWriter(fw)) {
                for(String str : flightsList) {
                    bw.write(str + "\n");
                }
            }
        }
    }

    @Override
    public void decreaseClsCapacity(Flight flight, String cls) throws IOException {
        File fileWithFlights = new File(FILE_PATH_FLIGHTS);
        FileReader fr = new FileReader(fileWithFlights);
        List<String> listWithFlights = new ArrayList<>();
        String line;
        String strIdForCompare = Integer.toString(flight.getId());

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                listWithFlights.add(line);
            }

            for(int i=0;i<listWithFlights.size(); i++) {
                String[] listWithFlightSplitArray = listWithFlights.get(i).split(",");
                if(strIdForCompare.equals(listWithFlightSplitArray[0])) {
                    if(cls.equals("E")) {
                        int changedEconomCapacity = Integer.parseInt(listWithFlightSplitArray[4]);
                        if(changedEconomCapacity>=1) changedEconomCapacity--;
                        listWithFlights.set(i, listWithFlightSplitArray[0] + "," + listWithFlightSplitArray[1] + "," +
                        listWithFlightSplitArray[2] + "," + listWithFlightSplitArray[3] + "," +
                        changedEconomCapacity + "," + listWithFlightSplitArray[5] + "," + listWithFlightSplitArray[6]);
                    } else if (cls.equals("B")){
                        int changedBusinessCapacity = Integer.parseInt(listWithFlightSplitArray[5]);
                        if(changedBusinessCapacity>=1) changedBusinessCapacity--;
                        listWithFlights.set(i, listWithFlightSplitArray[0] + "," + listWithFlightSplitArray[1] + "," +
                                listWithFlightSplitArray[2] + "," + listWithFlightSplitArray[3] + "," +
                                listWithFlightSplitArray[4] + "," + changedBusinessCapacity + ","
                                + listWithFlightSplitArray[6]);
                    }
                }
            }
        }

        FileWriter fw = new FileWriter(fileWithFlights);
        try(BufferedWriter bw = new BufferedWriter(fw)) {
            for(String str : listWithFlights) {
                bw.write(str + "\n");
            }
        }
    }

    @Override
    public void increaseClsCapacity(Flight flight, String cls) throws IOException {
        File fileWithFlights = new File(FILE_PATH_FLIGHTS);
        FileReader fr = new FileReader(fileWithFlights);
        List<String> listWithFlights = new ArrayList<>();
        String line;
        String strIdForCompare = Integer.toString(flight.getId());

        try(BufferedReader br = new BufferedReader(fr)) {
            while((line = br.readLine())!=null) {
                listWithFlights.add(line);
            }

            for(int i=0;i<listWithFlights.size(); i++) {
                String[] listWithFlightSplitArray = listWithFlights.get(i).split(",");
                if(strIdForCompare.equals(listWithFlightSplitArray[0])) {
                    if(cls.equals("E")) {
                        int changedEconomCapacity = Integer.parseInt(listWithFlightSplitArray[4]);
                        changedEconomCapacity++;
                        listWithFlights.set(i, listWithFlightSplitArray[0] + "," + listWithFlightSplitArray[1] + "," +
                                listWithFlightSplitArray[2] + "," + listWithFlightSplitArray[3] + "," +
                                changedEconomCapacity + "," + listWithFlightSplitArray[5] + "," + listWithFlightSplitArray[6]);
                    } else if (cls.equals("B")){
                        int changedBusinessCapacity = Integer.parseInt(listWithFlightSplitArray[5]);
                        changedBusinessCapacity++;
                        listWithFlights.set(i, listWithFlightSplitArray[0] + "," + listWithFlightSplitArray[1] + "," +
                                listWithFlightSplitArray[2] + "," + listWithFlightSplitArray[3] + "," +
                                listWithFlightSplitArray[4] + "," + changedBusinessCapacity + ","
                                + listWithFlightSplitArray[6]);
                    }
                }
            }
        }

        FileWriter fw = new FileWriter(fileWithFlights);
        try(BufferedWriter bw = new BufferedWriter(fw)) {
            for(String str : listWithFlights) {
                bw.write(str + "\n");
            }
        }
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
                        arrSplitByComa[3], Integer.parseInt(arrSplitByComa[4]), Integer.parseInt(arrSplitByComa[5]),
                        arrSplitByComa[6]));
            }
        }
        return flightsList;
    }

    @Override
    public Flight getById(Integer integer) throws IOException {
        //need add date
        File file = new File(FILE_PATH_FLIGHTS);
        FileReader fr = new FileReader(file);
        try(BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine())!=null) {
                String [] flightInfoSplitByComa = line.split(",");
                String flightIdStr = flightInfoSplitByComa[0];
                if(flightIdStr.equals(Integer.toString(integer))) {
                    Integer flightId = Integer.parseInt(flightIdStr);
                    String flightDeparturePoint = flightInfoSplitByComa[1];
                    String flightArrivalPoint = flightInfoSplitByComa[2];
                    String flightPlaneInfo = flightInfoSplitByComa[3];
                    Integer flightEconomClsCapacity = Integer.parseInt(flightInfoSplitByComa[4]);
                    Integer flightBusinessClsCapacity = Integer.parseInt(flightInfoSplitByComa[5]);
                    String flightDate = flightInfoSplitByComa[6];

                    return new Flight(
                            flightId,
                            flightDeparturePoint,
                            flightArrivalPoint,
                            flightPlaneInfo,
                            flightEconomClsCapacity,
                            flightBusinessClsCapacity,
                            flightDate
                    );
                }

            }
        }
        return null;
    }
}
