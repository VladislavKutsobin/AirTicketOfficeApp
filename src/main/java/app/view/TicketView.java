package main.java.app.view;

import main.java.app.controller.FlightController;
import main.java.app.controller.PassengerController;
import main.java.app.controller.TicketController;
import main.java.app.model.Flight;
import main.java.app.model.Passenger;
import main.java.app.model.Ticket;

import java.io.IOException;
import java.util.Scanner;

public class TicketView {
    TicketController ticketController = new TicketController();
    FlightController flightController = new FlightController();
    PassengerController passengerController = new PassengerController();
    Scanner scanner = new Scanner(System.in);

    public void getTicketMenu() throws IOException {

        System.out.println("Enter:" +"\n"+
                "'buy' for buying ticket" +"\n"+
                "'return' for returning ticket " +"\n"+
                "'show' for showing All flights in flightlist"+"\n"+
                "'menu' for return to main menu" + "\n" +
                "'exit' for exit");

        String input = scanner.next();
        Ticket ticketToSave = new Ticket();
        Passenger passengerToSave = new Passenger();
        Flight flightToSave = new Flight();

        while(!input.equals("exit")) {
            switch (input) {
                case "buy":
                    System.out.println("Enter ticket id, please:");
                    input = scanner.next();
                    ticketToSave.setId(Integer.parseInt(input));

                    System.out.println("Enter flight id, please:");
                    input = scanner.next();
                    flightToSave = flightController.getById(Integer.parseInt(input));
                    ticketToSave.setFlight(flightToSave);

                    System.out.println("Enter passenger id, please:");
                    input = scanner.next();
                    passengerToSave = passengerController.getById(Integer.parseInt(input));
                    System.out.println(passengerToSave);
                    ticketToSave.setPassenger(passengerToSave);

                    System.out.println("Enter E - econom class, B - business class");
                    input = scanner.next();
                    ticketToSave.setCls(input);

                    ticketController.buyTicket(ticketToSave);

                    System.out.println("Ticket was successfully bought.");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;
                case "return":
                    System.out.println("Enter ticket id for return:");
                    input = scanner.next();
                    ticketController.returnTicket(ticketController.getById(Integer.parseInt(input)));
                    System.out.println("You successfully returned ticket.");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;
                case "show":
                    System.out.println(ticketController.findAll());
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;
                case "menu":
                    ConsoleHelper consoleHelper = new ConsoleHelper();
                    consoleHelper.getMenu();
                default:
                    System.out.println("Please, make your choice.");
                    input = scanner.next();
            }
        }
    }
}
