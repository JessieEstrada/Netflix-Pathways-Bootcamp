package com.company.gamestore.controller;

import com.company.gamestore.model.Invoice;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.service.ServiceLayer;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {
// Test post and put request with this Json body
//        {
//            "name": "Customer 1",
//                "street": "100 Main Street",
//                "city": "Clovis",
//                "state": "CA",
//                "zipcode": "93612",
//                "itemType": "Game",
//                "itemId": 269,
//                "quantity": 12
//        }



    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@Valid @RequestBody  InvoiceViewModel invoice)  {
        return  serviceLayer.saveInvoice(invoice);
    }

    private double calculateProcessingFee(int quantity) {
        return 0.0;
    }

    @GetMapping("invoices/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable int id)  {
        return serviceLayer.findInvoice(id);
    }

    @GetMapping("/invoices")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllInvoices()  {
        return serviceLayer.getAllInvoices();
    }

    @GetMapping("invoices/customer/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getInvoiceByCustomerName(@PathVariable String name)  {
        return serviceLayer.getAllInvoicesByCustomerName(name);
    }



}