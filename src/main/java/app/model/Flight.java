package main.java.app.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight extends BaseEntity {
    private String departurePoint;
    private String arrivalPoint;
    private String plane;
    private int economClsCapacity;
    private int businessClsCapacity;
    private String date;

    public Flight() {

    }

    public Flight(int id, String departurePoint, String arrivalPoint, String plane, int economClsCapacity, int businessClsCapacity, String date) {
        super(id);
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.plane = plane;
        this.economClsCapacity = economClsCapacity;
        this.businessClsCapacity = businessClsCapacity;
        this.date = date;
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

    @Override
    public String toString() {
        return super.getId() + "," + departurePoint + "," + arrivalPoint + "," + plane + "," + economClsCapacity + "," +
                businessClsCapacity + "," + date;
    }
}
