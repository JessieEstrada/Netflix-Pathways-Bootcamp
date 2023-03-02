package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    // Create a new customer record
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer CreateNewCustomer(@RequestBody Customer customer){
        return repo.save(customer);
    }

    // Updates an existing customer record
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExistingCustomer(@RequestBody Customer customer){
        repo.save(customer);
    }

    // Deletes an existing customer record
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }

    // Finds a customer record by id
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer getCustomerById(@PathVariable int id){
        Optional<Customer> value = repo.findById(id);
        if (value.isPresent()) {
            return value.get();
        } else {return null;}
    }

    // Find customer records by state
    @GetMapping("/customers/state/{state}") //filter customers in that state
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Customer> getCustomerByState(@PathVariable String state){
        return repo.findAllByState(state);
    }



























}
