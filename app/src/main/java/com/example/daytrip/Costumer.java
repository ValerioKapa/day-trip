package com.example.daytrip;

public class Costumer {
    String name, sirname, hotel, trip;

    public Costumer(){}

    public Costumer(String name, String sirname, String hotel, String trip) {
        this.name = name;
        this.sirname = sirname;
        this.hotel = hotel;
        this.trip = trip;
    }

    public String getTrip() { return trip; }

    public void setTrip(String trip) { this.trip = trip; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSirname() {
        return sirname;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
}
