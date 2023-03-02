package com.company.customerdataservice.controllers;

import com.company.customerdataservice.controller.CustomerController;
import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() throws Exception{

    }

    // Test will create customer object
    @Test
    public void shouldCreateCustomer() throws Exception{
        // Create Customer Object
        Customer customer = new Customer();
        customer.setId(45);
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

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Test should update an existing record
    @Test
    public void shouldUpdateExistingCustomerRecordById() throws Exception{
        // Create Customer Object
        Customer customer = new Customer();
        customer.setId(20);
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

        String inputJson = mapper.writeValueAsString(customer);

        // Made a change on the phone
        customer.setPhone("323-323-322");

        mockMvc.perform(put("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Test should delete an existing Customer by ID
    @Test
    public void shouldDeleteExistingCustomerByIDAndReturn204StatusCode() throws Exception{
        mockMvc.perform(delete("/customers/123"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Test should return a specific Customer by ID
    @Test
    public void shouldGetSpecificCustomerById() throws Exception{
        // Create Customer Object
        Customer customer = new Customer();
        customer.setId(20);
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

        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(get("/customers/20"))
                .andDo(print())
                .andExpect(status().isAccepted());

    }

    // Test should return a specific Customer by State
    @Test
    public void shouldGetSpecificCustomersByState() throws Exception{
        // Create Customer Object
        Customer customer = new Customer();
        customer.setId(20);
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

        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(get("/customers/state/California"))
                .andDo(print())
                .andExpect(status().isAccepted());

    }
}