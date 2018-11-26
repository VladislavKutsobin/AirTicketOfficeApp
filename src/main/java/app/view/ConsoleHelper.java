package main.java.app.view;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleHelper {
    Scanner scanner = new Scanner(System.in);

    FlightView flightView = new FlightView();
    PassengerView passengerView = new PassengerView();
    TicketView ticketView = new TicketView();

    public void start() throws IOException{
        getMenu();
    }

    public void getMenu() throws IOException {
        System.out.println("Please choice F - flightmenu");
        System.out.println("Please choice P - paseengermenu");
        System.out.println("Please choice T - ticketmenu");

        String choice = scanner.next();

        switch (choice) {
            case "F":
                flightView.getFlightMenu();
                break;
            case "P":
                passengerView.getPassengerMenu();
                break;
            case "T":
                ticketView.getTicketMenu();
                break;
            default:
                System.out.println("You make incorrect choice! Closing app...");
        }
    }
}
