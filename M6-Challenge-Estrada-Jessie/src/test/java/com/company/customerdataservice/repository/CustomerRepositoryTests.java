package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// Customer repository tests
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    // Test to add a Customer to Database
    @Test
    public void addCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("James");
        customer.setLastName("Smith");

        customer.setEmail("jSmith@Netflix.com");
        customer.setCompany("Netflix");
        customer.setPhone("323-323-323");

        customer.setAddress1("1234 Somestreet Drive");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        // Asserting if Customer is added into database
        assertEquals(customer1.get(), customer);
    }

    // Test to update an existing customer in database
    @Test
    public void updateExistingCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("James");
        customer.setLastName("Smith");

        customer.setEmail("jSmith@Netflix.com");
        customer.setCompany("Netflix");
        customer.setPhone("323-323-323");

        customer.setAddress1("1234 Somestreet Drive");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        customerRepo.save(customer);

        //Act...
        customer.setFirstName("UPDATE");
        customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        // Asserting if Customer is updated
        assertEquals(customer1.get(), customer);
    }

    // TEst to delete an existing Customer in the database
    @Test
    public void deleteExistingCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("James");
        customer.setLastName("Smith");

        customer.setEmail("jSmith@Netflix.com");
        customer.setCompany("Netflix");
        customer.setPhone("323-323-323");

        customer.setAddress1("1234 Somestreet Drive");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        customerRepo.save(customer);

        //Act...
        customerRepo.deleteById(customer.getId());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        // Asserting if customer is not present in database
        assertFalse(customer1.isPresent());
    }

    // Test to return a Customer by ID from database
    @Test
    public void getCustomerById() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("James");
        customer.setLastName("Smith");

        customer.setEmail("jSmith@Netflix.com");
        customer.setCompany("Netflix");
        customer.setPhone("323-323-323");

        customer.setAddress1("1234 Somestreet Drive");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("12345");
        customer.setCountry("United States of America");

        // Creating my second Customer object
        Customer customer2 = new Customer();
        customer2.setFirstName("Peter");
        customer2.setLastName("Parker");

        customer2.setEmail("pParker@spider.com");
        customer2.setCompany("Spider");
        customer2.setPhone("232-232-232");

        customer2.setAddress1("5678 Spidey Street");
        customer2.setCity("New York City");
        customer2.setState("New York");
        customer2.setPostalCode("67890");
        customer2.setCountry("United States of America");

        customerRepo.save(customer);

        //Act...
        customerRepo.findById(customer.getId());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        //Asserting if we return customer with particular ID
        assertEquals(customer1.get(), customer);
    }

    // Test to return Customers that are filtered by a certain State
    @Test
    public void getCustomersByState() {
        // Arrange...
        // Creating my first Customer object
        Customer customer1 = new Customer();
        customer1.setFirstName("James");
        customer1.setLastName("Smith");

        customer1.setEmail("jSmith@netflix.com");
        customer1.setCompany("Netflix");
        customer1.setPhone("323-323-323");

        customer1.setAddress1("1234 Somestreet Drive");
        customer1.setCity("Los Angeles");
        customer1.setState("California");
        customer1.setPostalCode("12345");
        customer1.setCountry("United States of America");

        customerRepo.save(customer1);

        // Creating my second Customer object
        Customer customer2 = new Customer();
        customer2.setFirstName("Peter");
        customer2.setLastName("Parker");

        customer2.setEmail("pParker@spider.com");
        customer2.setCompany("Spider");
        customer2.setPhone("232-232-232");

        customer2.setAddress1("5678 Spidey Street");
        customer2.setCity("New York City");
        customer2.setState("New York");
        customer2.setPostalCode("67890");
        customer2.setCountry("United States of America");

        customerRepo.save(customer2);

        // Creating my third Customer object
        Customer customer3 = new Customer();
        customer3.setFirstName("John");
        customer3.setLastName("Brown");

        customer3.setEmail("jBrown@netflix.com");
        customer3.setCompany("Netflix");
        customer3.setPhone("454-545-345");

        customer3.setAddress1("1234 Thistreet Drive");
        customer3.setCity("San Francisco");
        customer3.setState("California");
        customer3.setPostalCode("76548");
        customer3.setCountry("United States of America");

        customerRepo.save(customer3);

        // Creating my fourth Customer object
        Customer customer4 = new Customer();
        customer4.setFirstName("Alex");
        customer4.setLastName("Miller");

        customer4.setEmail("aMiller@compy.com");
        customer4.setCompany("Compy");
        customer4.setPhone("123-321-213");

        customer4.setAddress1("1234 Cool Street");
        customer4.setCity("Arlington");
        customer4.setState("Texas");
        customer4.setPostalCode("84659");
        customer4.setCountry("United States of America");

        customerRepo.save(customer4);

        //Assert...
        String state = ("California");
        List<Customer> customersList = customerRepo.findAllByState(state);

        // Asserting if we have a customer list with Customers in a certain state
        assertEquals(2, customersList.size());
    }
}
