package main.java.app.model;

import java.util.Date;

public class Flight extends BaseEntity {
    private String departurePoint;
    private String arrivalPoint;
    private String plane;
    private int economClsCapacity;
    private int businessClsCapacity;
    private String date;

    public Flight(int id, String departurePoint, String arrivalPoint, String plane, int economClsCapacity, int businessClsCapacity) {
        super(id);
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.plane = plane;
        this.economClsCapacity = economClsCapacity;
        this.businessClsCapacity = businessClsCapacity;
        Date date = new Date();
        this.date = date.toString();
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public int getEconomClsCapacity() {
        return economClsCapacity;
    }

    public void setEconomClsCapacity(int economClsCapacity) {
        this.economClsCapacity = economClsCapacity;
    }

    public int getBusinessClsCapacity() {
        return businessClsCapacity;
    }

    public void setBusinessClsCapacity(int businessClsCapacity) {
        this.businessClsCapacity = businessClsCapacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
