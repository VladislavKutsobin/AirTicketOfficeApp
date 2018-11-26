package main.java.app.view;

import main.java.app.controller.FlightController;
import main.java.app.model.Flight;

import java.io.IOException;
import java.util.Scanner;

public class FlightView {
    FlightController flightController = new FlightController();
    Scanner scanner = new Scanner(System.in);

    public void getFlightMenu() throws IOException {

        System.out.println("Enter:" +"\n"+
                "'add' for adding new flight to flightlist" +"\n"+
                "'delete' for deleting flight from flightlist" +"\n"+
                "'show' for showing All flights in flightlist"+"\n"+
                "'search' for showing flights by params in flightlist"+"\n"+
                "'menu' for return to main menu" + "\n" +
                "'exit' for exit");

        String input = scanner.next();
        Flight flightToSave = new Flight();

        while(!input.equals("exit")) {
            switch(input) {
                case "add":
                    System.out.println("Enter flight id, please.");
                    input = scanner.next();
                    flightToSave.setId(Integer.parseInt(input));

                    System.out.println("Enter departure point for this flight");
                    input = scanner.next();
                    flightToSave.setDeparturePoint(input);

                    System.out.println("Enter arrival point for this flight");
                    input = scanner.next();
                    flightToSave.setArrivalPoint(input);

                    System.out.println("Enter information about plane for this flight");
                    input = scanner.next();
                    flightToSave.setPlane(input);

                    System.out.println("Enter economclass capacity for this flight, please.");
                    input = scanner.next();
                    flightToSave.setEconomClsCapacity(Integer.parseInt(input));

                    System.out.println("Enter businessclass capacity for this flight, please.");
                    input = scanner.next();
                    flightToSave.setBusinessClsCapacity(Integer.parseInt(input));

                    System.out.println("Enter date for this flight (ex.: DD:MM:YY:");
                    input = scanner.next();
                    flightToSave.setDate(input);

                    flightController.insert(flightToSave);

                    System.out.println("Flight was successfully saved");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;

                case "delete":
                    System.out.println("Enter id for deleting flight");
                    input = scanner.next();
                    flightController.delete(Integer.parseInt(input));
                    System.out.println("Flight was successfully deleted from flightlist");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;

                case "show":
                    System.out.println(flightController.findAll());
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;
                case "search":
                    System.out.println("Enter departure point, please:");
                    String departurePoint = scanner.next();
                    System.out.println("Enter arrival point, please:");
                    String arrivalPoint = scanner.next();
                    System.out.println("Enter first date of searching period, please(DD:MM:YY):");
                    String startDate = scanner.next();
                    System.out.println("Enter last date of searching period, please(DD:MM:YY):");
                    String endDate = scanner.next();

                    System.out.println(flightController.searchByParams(
                            departurePoint,
                            arrivalPoint,
                            startDate,
                            endDate));

                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;
                case "menu":
                    ConsoleHelper consoleHelper = new ConsoleHelper();
                    consoleHelper.getMenu();
                default:
                    System.out.println("Please, make your choice!");
                    input = scanner.next();

            }
        }
    }

}
