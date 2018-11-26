package main.java.app.view;

import main.java.app.controller.PassengerController;
import main.java.app.model.Passenger;

import java.io.IOException;
import java.util.Scanner;

public class PassengerView {
    PassengerController passengerController = new PassengerController();
    Scanner scanner = new Scanner(System.in);

    public void getPassengerMenu() throws IOException {

        System.out.println("Enter:" +"\n"+
                "'add' for adding new passenger to passengerlist" +"\n"+
                "'delete' for deleting passenger from passengerlist" +"\n"+
                "'show' for showing all passengers in passengerlist"+"\n"+
                "'menu' for return to main menu" + "\n" +
                "'exit' for exit");

        String input = scanner.next();
        Passenger passengerToSave = new Passenger();

        while(!input.equals("exit")) {
            switch (input) {
                case "add":
                    System.out.println("Enter passenger id, please:");
                    input = scanner.next();
                    passengerToSave.setId(Integer.parseInt(input));

                    System.out.println("Enter passenger first name, please:");
                    input = scanner.next();
                    passengerToSave.setFirstName(input);

                    System.out.println("Enter passenger last name, please:");
                    input = scanner.next();
                    passengerToSave.setLastName(input);

                    System.out.println("Enter passenger age, please:");
                    input = scanner.next();
                    passengerToSave.setAge(Integer.parseInt(input));

                    passengerController.insert(passengerToSave);

                    System.out.println("Information of passenger was successfully add to database.");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;
                case "delete":
                    System.out.println("Enter passenger id for deleting, please:");
                    input = scanner.next();
                    passengerController.delete(Integer.parseInt(input));
                    System.out.println("Information about passenger with id " + input + " was successfully deleted.");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;
                case "show":
                    System.out.println("Information about all passengers in database:");
                    System.out.println(passengerController.findAll());
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;
                case "menu":
                    ConsoleHelper consoleHelper = new ConsoleHelper();
                    consoleHelper.getMenu();
                default:
                    System.out.println("Please make your, choice:");
                    input = scanner.next();
            }
        }
    }
}
