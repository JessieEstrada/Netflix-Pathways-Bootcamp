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
        //I need to store my customerList into a List<Customer>
        List<Customer> customerList = new ArrayList<>();


        for (int i = 0; i < customerData.size(); i++) {
            int id = 0;
            String name = null;
            List<AccountRecord> charges = new ArrayList<>();
            AccountRecord accountRecord = new AccountRecord();
            Customer currentCustomer = new Customer();
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

            boolean found = false;
            for (int k = 0; k < customerList.size(); k++) {
                if (currentCustomer.getId() == customerList.get(k).getId()) {
                    customerList.get(k).getCharges().add(accountRecord);
                    found = true;
                    break;
                }
            }
            if(found == false){
                customerList.add(currentCustomer);
            }
        }


        System.out.println("Positive accounts:");
        for(int i = 0; i < customerList.size(); i++){
            if(customerList.get(i).getBalance() > 0){
                System.out.println(customerList.get(i).toString());
            }
        }

        System.out.println("\nNegative accounts:");
        for(int i = 0; i < customerList.size(); i++){
            if(customerList.get(i).getBalance() < 0){
                System.out.println(customerList.get(i).toString());
            }
        }

    }
}
