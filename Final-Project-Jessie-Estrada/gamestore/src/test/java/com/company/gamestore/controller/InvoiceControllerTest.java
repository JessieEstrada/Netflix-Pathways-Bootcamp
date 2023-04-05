package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.repository.InvoiceRepository;
import com.company.gamestore.repository.TshirtRepository;
import com.company.gamestore.service.ServiceLayer;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    ServiceLayer serviceLayerMB;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() throws Exception{

    }


    //Create
    //Read
    //Read All
    // Console Controller Test Should Create Console
    @Test
    public void shouldCreateInvoice() throws Exception{
        Invoice invoice = new Invoice();
        invoice.setId(20);
        invoice.setName("John Smith");
        invoice.setStreet("1234 Main Street");
        invoice.setCity("Los Angeles");
        invoice.setState("CA");
        invoice.setZipcode("12345");
        invoice.setItemType("Game");
        invoice.setItemId(12);
        BigDecimal unitPrice = new BigDecimal(59.99);
        invoice.setUnitPrice(unitPrice);
        invoice.setQuantity(1);
        BigDecimal subTotal = new BigDecimal(59.99);
        invoice.setSubtotal(subTotal);
        BigDecimal tax = new BigDecimal(3.5994);
        invoice.setTax(tax);
        BigDecimal processingFee = new BigDecimal(1.49);
        invoice.setProcessingFee(processingFee);
        BigDecimal total = new BigDecimal(65.0794);
        invoice.setTotal(total);



        String inputJson = mapper.writeValueAsString(invoice);

        mockMvc.perform(post("/invoices")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }



    // Invoice Controller Test Should Get a Invoice by ID
    @Test
    public void shouldGetSpecificConsoleById() throws Exception{
        Invoice invoice = new Invoice();
        invoice.setId(20);
        invoice.setName("John Smith");
        invoice.setStreet("1234 Main Street");
        invoice.setCity("Los Angeles");
        invoice.setState("CA");
        invoice.setZipcode("12345");
        invoice.setItemType("Game");
        invoice.setItemId(12);
        BigDecimal unitPrice = new BigDecimal("59.99");
        invoice.setUnitPrice(unitPrice);
        invoice.setQuantity(1);

        String inputJson = mapper.writeValueAsString(invoice);

        mockMvc.perform(get("/invoices/20")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Invoice Controller Test Should Get all Invoices
    @Test
    public void shouldGetAllConsoles() throws Exception{
        Invoice invoice1 = new Invoice();
        invoice1.setId(20);
        invoice1.setName("John Smith");
        invoice1.setStreet("1234 Main Street");
        invoice1.setCity("Los Angeles");
        invoice1.setState("CA");
        invoice1.setZipcode("12345");
        invoice1.setItemType("Game");
        invoice1.setItemId(12);
        BigDecimal unitPrice1 = new BigDecimal("59.99");
        invoice1.setUnitPrice(unitPrice1);
        invoice1.setQuantity(1);


        Invoice invoice2 = new Invoice();
        invoice2.setId(20);
        invoice2.setName("John Smith");
        invoice2.setStreet("1234 Main Street");
        invoice2.setCity("Los Angeles");
        invoice2.setState("CA");
        invoice2.setZipcode("12345");
        invoice2.setItemType("Game");
        invoice2.setItemId(12);
        BigDecimal unitPrice2 = new BigDecimal("59.99");
        invoice2.setUnitPrice(unitPrice2);
        invoice2.setQuantity(1);


        Invoice invoice3 = new Invoice();
        invoice3.setId(20);
        invoice3.setName("John Smith");
        invoice3.setStreet("1234 Main Street");
        invoice3.setCity("Los Angeles");
        invoice3.setState("CA");
        invoice3.setZipcode("12345");
        invoice3.setItemType("Game");
        invoice3.setItemId(12);
        BigDecimal unitPrice3 = new BigDecimal("59.99");
        invoice3.setUnitPrice(unitPrice3);
        invoice3.setQuantity(1);


        Invoice invoice4 = new Invoice();
        invoice4.setId(20);
        invoice4.setName("John Smith");
        invoice4.setStreet("1234 Main Street");
        invoice4.setCity("Los Angeles");
        invoice4.setState("CA");
        invoice4.setZipcode("12345");
        invoice4.setItemType("Game");
        invoice4.setItemId(12);
        BigDecimal unitPrice4 = new BigDecimal("59.99");
        invoice4.setUnitPrice(unitPrice4);
        invoice4.setQuantity(1);

        List<Invoice> invoiceList;
        invoiceList = Arrays.asList(invoice1, invoice2, invoice3, invoice4);

        mockMvc.perform(get("/invoices")

                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Invoice Controller Test Should Get Invoices by Customer Name
    @Test
    public void shouldGetInvoicesByCustomer() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/invoices/customer/John Smith"))
                .andDo(print())
                .andExpect(status().isOk());
    }








}