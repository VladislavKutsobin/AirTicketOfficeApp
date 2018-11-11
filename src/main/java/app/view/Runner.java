package main.java.app.view;

import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        Date date = new Date();
        String data = date.toString();
        System.out.println(data);
        System.out.println(data.substring(4, 10) + " " + data.substring(data.length()-4) + " " +data.substring(11, data.length()-8));
    }
}
