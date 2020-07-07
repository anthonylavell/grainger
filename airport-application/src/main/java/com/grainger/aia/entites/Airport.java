package com.grainger.aia.entites;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Airport {

    @Id
    @SequenceGenerator(name = "get_airport_seq", sequenceName = "airport_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "get_airport_seq")
    private long id;

    @NotBlank(message="*Must give airport's name")
    private String name;

    @NotBlank(message="*Must give airport's city")
    private String city;

    @NotBlank(message="*Must give airport's country")
    private String country;


    @NotBlank(message="*Must give airport's iata code")
    private String iataCode;


    @NotBlank(message="*Must give airport's icao code")
    private String icaoCode;

    @Min(value = 1, message = "*Age must be at least 1")
    private double latitude;

    @Min(value = 1, message = "*Age must be at least 1")
    private double longitude;

    @Min(value = 1, message = "*Age must be at least 1")
    private long altitude;


    @NotBlank(message="*Must give airport's timezone")
    private String timeZone;

    public Airport(){

    }

    public Airport(String name, String city, String country, String iataCode,
                   String icaoCode, double latitude, double longitude, long altitude, String timeZone) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timeZone = timeZone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getAltitude() {
        return altitude;
    }

    public void setAltitude(long altitude) {
        this.altitude = altitude;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
