package com.grainger.aia.services;

import org.springframework.stereotype.Service;

@Service
public class Travel {
    private String departure;
    private String arrival;
    private long miles =0;

    public Travel(){

    }

    public Travel(String departure, String arrival, long miles) {
        this.departure = departure;
        this.arrival = arrival;
        this.miles = miles;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public long getMiles() {
        return miles;
    }

    public void setDistance(long miles) {
        this.miles = miles;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "\ndeparture = '" + departure + '\'' +
                ", \narrival = '" + arrival + '\'' +
                ", \nmiles = " + miles + "miles"+
                '}';
    }
}
