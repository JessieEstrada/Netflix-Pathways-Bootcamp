package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Tshirt;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TshirtController.class)
public class TshirtControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    ServiceLayer serviceLayerMB;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() throws Exception{

    }

    // Tshirt Controller Test Should Create Tshirt
    @Test
    public void shouldCreateTshirt() throws Exception{
        Tshirt tshirt = new Tshirt();
        tshirt.settShirtId(10);
        tshirt.setSize("M");
        tshirt.setColor("Blue");
        tshirt.setDescription("A comfortable and stylish T-shirt");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(55);


        String inputJson = mapper.writeValueAsString(tshirt);

        mockMvc.perform(post("/tshirts")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }



    // Tshirt Controller Test Should Get a Tshirt by ID
    @Test
    public void shouldGetSpecificTshirtById() throws Exception{
        Tshirt tshirt = new Tshirt();
        tshirt.settShirtId(10);
        tshirt.setSize("M");
        tshirt.setColor("Blue");
        tshirt.setDescription("A comfortable and stylish T-shirt");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(55);


        String inputJson = mapper.writeValueAsString(tshirt);

        mockMvc.perform(get("/tshirts/20")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Tshirt Controller Test Should Get all Tshirts
    @Test
    public void shouldGetAllTshirts() throws Exception{
        Tshirt tshirt1 = new Tshirt();
        tshirt1.settShirtId(10);
        tshirt1.setSize("M");
        tshirt1.setColor("Blue");
        tshirt1.setDescription("A comfortable and stylish T-shirt");
        BigDecimal price1 = new BigDecimal("10.99");
        tshirt1.setPrice(price1);
        tshirt1.setQuantity(55);


        Tshirt tshirt2 = new Tshirt();
        tshirt2.settShirtId(10);
        tshirt2.setSize("M");
        tshirt2.setColor("Blue");
        tshirt2.setDescription("A comfortable and stylish T-shirt");
        BigDecimal price2 = new BigDecimal("10.99");
        tshirt2.setPrice(price2);
        tshirt2.setQuantity(55);


        Tshirt tshirt3 = new Tshirt();
        tshirt3.settShirtId(10);
        tshirt3.setSize("M");
        tshirt3.setColor("Blue");
        tshirt3.setDescription("A comfortable and stylish T-shirt");
        BigDecimal price3 = new BigDecimal("10.99");
        tshirt3.setPrice(price3);
        tshirt3.setQuantity(55);


        Tshirt tshirt4 = new Tshirt();
        tshirt4.settShirtId(10);
        tshirt4.setSize("M");
        tshirt4.setColor("Blue");
        tshirt4.setDescription("A comfortable and stylish T-shirt");
        BigDecimal price4 = new BigDecimal("10.99");
        tshirt4.setPrice(price4);
        tshirt4.setQuantity(55);

        List<Tshirt> tshirtList;
        tshirtList = Arrays.asList(tshirt1, tshirt2, tshirt3, tshirt4);

        mockMvc.perform(get("/tshirts")

                )
                .andDo(print())
                .andExpect(status().isOk());
    }


    // Tshirt Controller Test Should Update a Tshirt
    @Test
    public void shouldUpdateSpecificTshirtById() throws Exception{
        Tshirt tshirt = new Tshirt();
        tshirt.settShirtId(10);
        tshirt.setSize("M");
        tshirt.setColor("Blue");
        tshirt.setDescription("A comfortable and stylish T-shirt");
        BigDecimal price = new BigDecimal("10.99");
        tshirt.setPrice(price);
        tshirt.setQuantity(55);

        String inputJson = mapper.writeValueAsString(tshirt);

        tshirt.setSize("L");

        mockMvc.perform(put("/tshirts")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Tshirt Controller Test Should Delete a Tshirt and return 204 Status Code
    @Test
    public void shouldDeleteExistingConsoleByIDAndReturn204StatusCode() throws Exception{
        mockMvc.perform(delete("/tshirts/123"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Tshirt Controller Test Should Get Tshirts by Color
    @Test
    public void shouldGetTshirtsByColor() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/tshirts/color/Red"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Tshirt Controller Test Should Get Tshirts by Size
    @Test
    public void shouldGetTshirtsBySize() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/tshirts/size/Small"))
                .andDo(print())
                .andExpect(status().isOk());
    }








}