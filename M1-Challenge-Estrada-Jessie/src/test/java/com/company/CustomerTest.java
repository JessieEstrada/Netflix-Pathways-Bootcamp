package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class CustomerTest {

    // This test will check that the .getBalance() method will work with a positive balance for the customer
    @Test
    public void shouldGetPositiveBalance(){
        Customer customer = new Customer();
        List<AccountRecord> charges = new ArrayList<>();

        customer.setName("Build Industries");
        customer.setId(1);

        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setChargeDate("02-31-21");
        accountRecord1.setCharge(1000);
        customer.getCharges().add(accountRecord1);

        AccountRecord accountRecord2 = new AccountRecord();
        accountRecord2.setChargeDate("11-21-21");
        accountRecord2.setCharge(-278);
        customer.getCharges().add(accountRecord2);

        AccountRecord accountRecord3 = new AccountRecord();
        accountRecord3.setChargeDate("01-02-22");
        accountRecord3.setCharge(3000);
        customer.getCharges().add(accountRecord3);

        assertEquals(3722,customer.getBalance());
    }

    // This test will check that the .getBalance() method will work with a
    // negative balance on for the customer
    @Test
    public void shouldGetNegativeBalance(){
        Customer customer = new Customer();
        List<AccountRecord> charges = new ArrayList<>();

        customer.setName("Weekly Planet");
        customer.setId(1);

        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setChargeDate("04-21-13");
        accountRecord1.setCharge(202456);
        customer.getCharges().add(accountRecord1);

        AccountRecord accountRecord2 = new AccountRecord();
        accountRecord2.setChargeDate("05-01-14");
        accountRecord2.setCharge(-50000);
        customer.getCharges().add(accountRecord2);

        AccountRecord accountRecord3 = new AccountRecord();
        accountRecord3.setChargeDate("06-04-15");
        accountRecord3.setCharge(-10876);
        customer.getCharges().add(accountRecord3);

        AccountRecord accountRecord4 = new AccountRecord();
        accountRecord4.setChargeDate("08-23-15");
        accountRecord4.setCharge(1200);
        customer.getCharges().add(accountRecord4);

        AccountRecord accountRecord5 = new AccountRecord();
        accountRecord5.setChargeDate("09-19-15");
        accountRecord5.setCharge(-156000);
        customer.getCharges().add(accountRecord5);

        assertEquals(-13220,customer.getBalance());
    }

    // This test will check that the .getBalance() method will work when there is only one charge for the customer
    @Test
    public void shouldGetOneChargeBalance(){
        Customer customer = new Customer();
        List<AccountRecord> charges = new ArrayList<>();

        customer.setName("Broke Chemical");
        customer.setId(1);

        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setChargeDate("10-16-23");
        accountRecord.setCharge(112000);
        customer.getCharges().add(accountRecord);

        assertEquals(112000,customer.getBalance());
    }

    // This test will check that the .getBalance() method will work when there is a balance of 0 for the customer
    @Test
    public void shouldGetNoChargesBalance(){
        Customer customer = new Customer();
        List<AccountRecord> charges = new ArrayList<>();

        customer.setName("Monthly Planet");
        customer.setId(4);

        AccountRecord accountRecord = new AccountRecord();
        customer.getCharges().add(accountRecord);

        assertEquals(0,customer.getBalance());
    }

    // This test will check that the .shouldToString() method will correctly return a correctly
    // formatted string with customer ID, customer name, and customer balance.
    @Test
    public void shouldToString1(){
        Customer customer = new Customer();
        List<AccountRecord> charges = new ArrayList<>();

        customer.setName("Dwayne Enterprises");
        customer.setId(2);

        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setChargeDate("08-11-15");
        accountRecord1.setCharge(1000);

        customer.getCharges().add(accountRecord1);

        assertEquals("Customer ID: " + 2 + " | Name: " + "Dwayne Enterprises" + " | Balance: " + 1000,customer.toString());
    }



    // This test will check that the .shouldToString() method will correctly return a correctly
    // formatted string with customer ID, customer name, and customer balance. (Different variation of expected)
    @Test
    public void shouldToString2(){
        Customer customer1 = new Customer();
        List<AccountRecord> charges1 = new ArrayList<>();

        customer1.setName("Stark Industries");
        customer1.setId(2);

        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setChargeDate("11-11-22");
        accountRecord1.setCharge(1000);
        customer1.getCharges().add(accountRecord1);



        Customer customer2 = new Customer();
        List<AccountRecord> charges2 = new ArrayList<>();
        customer2.setId(2);
        customer2.setName("Stark Industries");

        AccountRecord accountRecord2 = new AccountRecord();
        accountRecord2.setChargeDate("11-11-22");
        accountRecord2.setCharge(1000);
        customer2.getCharges().add(accountRecord2);

        assertEquals(customer2.toString(),customer1.toString());
    }

}