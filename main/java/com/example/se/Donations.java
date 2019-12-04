package com.example.se;

import java.util.ArrayList;

public class Donations {
    public String firstName;
    public String lastName;
    public double donation;
    public String email;
    public static ArrayList<Donations> donateDatabase = new ArrayList<>();

    public Donations(String firstName, String lastName, double donation, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.donation = donation;
        this.email = email;
    }
    public static void addDatabase(Donations donations) {
        donateDatabase.add(donations);
    }
    public static ArrayList<Donations> returnList() {
        return donateDatabase;
    }

    public static ArrayList<Donations> returnData(ArrayList<Donations> donateDatabase) {
        return donateDatabase;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getDonation() {
        return donation;
    }
    public void setDonation(double donation) {
        this.donation = donation;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}

