package main.java.app;

import main.java.app.view.ConsoleHelper;

import java.io.IOException;

public class AppRunner {
    public static void main(String[] args) throws IOException {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.start();
    }
}
