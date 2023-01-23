package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        // I need to store my customerList into a List<Customer>
        List<Customer> customerList = new ArrayList<>();

        // For loop that will iterate through List<String[]> customerData
        for (int i = 0; i < customerData.size(); i++) {
            // These are starting variables and instantiated
            // objects for each String[]
            int id = 0;
            String name = null;
            AccountRecord accountRecord = new AccountRecord();
            Customer currentCustomer = new Customer();

            // In this for loop, I go through each individual
            // String[] in the customerData list and separate
            // them by ID, Name, and Account Record
            for (int j = 0; j < 4; j++) {
                String[] current = customerData.get(i);
                if (j == 0) {
                    id = Integer.parseInt(current[j]);
                    currentCustomer.setId(id);
                } else if (j == 1) {
                    name = current[j];
                    String companyName = name;
                    currentCustomer.setName(name);
                } else if (j == 2) {
                    accountRecord.setCharge(Integer.parseInt(current[j]));
                } else if (j == 3) {
                    accountRecord.setChargeDate(current[j]);
                    currentCustomer.getCharges().add(accountRecord);
                }

            }

            // Here I looped through my customer list to verify if the current customer is or isn't already in the list.
            boolean found = false;
            for (int k = 0; k < customerList.size(); k++) {
                // If customer is already in the customer list, I simply add an account record to their charges
                if (currentCustomer.getId() == customerList.get(k).getId()) {
                    customerList.get(k).getCharges().add(accountRecord);
                    found = true;
                    break;
                }
            }
            // If customer is new in the list, I add them into the list
            if(found == false){customerList.add(currentCustomer);}
        }
        // Here, I loop through my list of Customers
        // and print out Positive accounts
        System.out.println("Positive accounts:");
        for(int i = 0; i < customerList.size(); i++){
            if(customerList.get(i).getBalance() > 0){
                System.out.println(customerList.get(i).toString());
            }
        }
        // Here, I loop through my list of Customers
        // and print out Negative accounts
        System.out.println("\nNegative accounts:");
        for(int i = 0; i < customerList.size(); i++){
            if(customerList.get(i).getBalance() < 0){
                System.out.println(customerList.get(i).toString());
            }
        }
    }
}
