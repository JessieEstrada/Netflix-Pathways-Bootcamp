package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class CustomerTest {

    @Test
    public void shouldGetPositiveBalance(){
        Customer customer = new Customer();
        List<AccountRecord> charges = new ArrayList<>();
        customer.setId(1);
        customer.setName("Jessie");

        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setChargeDate("2-31-33");
        accountRecord1.setCharge(1000);

        AccountRecord accountRecord2 = new AccountRecord();
        accountRecord2.setChargeDate("11-21-13");
        accountRecord2.setCharge(2000);

        AccountRecord accountRecord3 = new AccountRecord();
        accountRecord3.setChargeDate("6-02-26");
        accountRecord3.setCharge(3000);

        customer.getCharges().add(accountRecord1);
        customer.getCharges().add(accountRecord2);
        customer.getCharges().add(accountRecord3);

        assertEquals(6000,customer.getBalance());
    }

    @Test
    public void shouldGetNegativeBalance(){
        Customer customer = new Customer();
        List<AccountRecord> charges = new ArrayList<>();
        customer.setId(1);
        customer.setName("Jessie");

        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setChargeDate("2-31-33");
        accountRecord1.setCharge(1000);

        AccountRecord accountRecord2 = new AccountRecord();
        accountRecord2.setChargeDate("11-21-13");
        accountRecord2.setCharge(2000);

        AccountRecord accountRecord3 = new AccountRecord();
        accountRecord3.setChargeDate("6-02-26");
        accountRecord3.setCharge(3000);

        customer.getCharges().add(accountRecord1);
        customer.getCharges().add(accountRecord2);
        customer.getCharges().add(accountRecord3);

        assertEquals(6000,customer.getBalance());
    }

    @Test
    public void shouldToString(){
        Customer customer = new Customer();
        List<AccountRecord> charges = new ArrayList<>();
        customer.setId(1);
        customer.setName("Jessie");

        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setChargeDate("2-31-33");
        accountRecord1.setCharge(1000);

        customer.getCharges().add(accountRecord1);
        //*************************
//        Customer customer2 = new Customer();
//        List<AccountRecord> charges2 = new ArrayList<>();
//        customer2.setId(1);
//        customer2.setName("Jessie");
//
//        AccountRecord accountRecord2 = new AccountRecord();
//        accountRecord2.setChargeDate("2-31-33");
//        accountRecord2.setCharge(1000);
//
//        customer2.getCharges().add(accountRecord2);

        assertEquals("Customer ID: " + 1 + " | Name: " + "Jessie" + " | Balance: " + 1000,customer.toString());
    }

}