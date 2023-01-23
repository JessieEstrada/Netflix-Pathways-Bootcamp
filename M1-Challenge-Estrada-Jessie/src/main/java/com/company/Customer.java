package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {//update this
        // Here I iterate through each charge in the account and add them up to a total balance
        int totalBalance = 0;
        for (int i = 0; i < charges.size(); i++){
            totalBalance += charges.get(i).getCharge();
        }
        return totalBalance;
    }


    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {//update this
        // .toString() method will format a customer object as a String.
        return "Customer ID: " + id + " | Name: " + name + " | Balance: " + getBalance();
    }
}
