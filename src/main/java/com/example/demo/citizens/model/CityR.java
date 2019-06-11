package com.example.demo.citizens.model;

public class CityR {

    private String name;
    private int amountOfUsers;

    public CityR() {
    }

    public CityR(String name, int amountOfUsers) {
        this.name = name;
        this.amountOfUsers = amountOfUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfUsers() {
        return amountOfUsers;
    }

    public void setAmountOfUsers(int amountOfUsers) {
        this.amountOfUsers = amountOfUsers;
    }
}
