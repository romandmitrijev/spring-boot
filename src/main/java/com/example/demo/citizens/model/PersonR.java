package com.example.demo.citizens.model;

public class PersonR {

    private String name;
    private int amountOfCities;

    public PersonR() {
    }

    public PersonR(String name, int amountOfCities) {
        this.name = name;
        this.amountOfCities = amountOfCities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfCities() {
        return amountOfCities;
    }

    public void setAmountOfCities(int amountOfCities) {
        this.amountOfCities = amountOfCities;
    }
}
