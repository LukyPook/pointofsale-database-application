package com.example.se;

import java.util.ArrayList;
import java.util.Arrays;

public class Account {
    public String email;
    public String password;
    public String name;
    public String lastName;
    public static ArrayList<Account> database = new ArrayList<>();

    public Account(String email, String password, String name, String lastName) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }
    public static void addDatabase(Account acc) {
        database.add(acc);
    }
    public static ArrayList<Account> returnList() {
        return database;
    }

    public static ArrayList<Account> returnData(ArrayList<Account> database) {
        return database;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
