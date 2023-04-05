package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private ServiceLayer serviceLayerMB;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() throws Exception{

    }

    // Console Controller Test Should Create Console
    @Test
    public void shouldCreateConsole() throws Exception{
        Console console = new Console();
        console.setConsoleId(20);
        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Eight-core AMD Zen 2 CPU");
        BigDecimal price = new BigDecimal("499.99");
        console.setPrice(price);
        console.setQuantity(100);


        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(post("/consoles")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }



    // Console Controller Test Should Get a Console by ID
    @Test
    public void shouldGetSpecificConsoleById() throws Exception{
        Console console = new Console();
        console.setConsoleId(20);
        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Eight-core AMD Zen 2 CPU");
        BigDecimal price = new BigDecimal("499.99");
        console.setPrice(price);
        console.setQuantity(100);


        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(get("/consoles/20")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Console Controller Test Should Get all consoles
    @Test
    public void shouldGetAllConsoles() throws Exception{
        Console console1 = new Console();
        console1.setConsoleId(21);
        console1.setModel("Playstation 5");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("2TB");
        console1.setProcessor("Eight-core AMD Zen 2 CPU");
        BigDecimal price = new BigDecimal("499.99");
        console1.setPrice(price);
        console1.setQuantity(100);


        Console console2 = new Console();
        console2.setConsoleId(22);
        console2.setModel("Playstation 4");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("3TB");
        console2.setProcessor("Nine-core AMD Zen 3 CPU");
        BigDecimal price2 = new BigDecimal("499.99");
        console2.setPrice(price2);
        console2.setQuantity(100);


        Console console3 = new Console();
        console3.setConsoleId(23);
        console3.setModel("Playstation 3");
        console3.setManufacturer("Sony");
        console3.setMemoryAmount("1TB");
        console3.setProcessor("Ten-core AMD Zen 10 CPU");
        BigDecimal price3 = new BigDecimal("499.99");
        console3.setPrice(price3);
        console3.setQuantity(100);


        Console console4 = new Console();
        console4.setConsoleId(24);
        console4.setModel("Xbox One");
        console4.setManufacturer("Microsoft");
        console4.setMemoryAmount("1TB");
        console4.setProcessor("Eight-core AMD Zen 2 CPU");
        BigDecimal price4 = new BigDecimal("499.99");
        console4.setPrice(price4);
        console4.setQuantity(100);

        List<Console> consoleList;
        consoleList = Arrays.asList(console1, console2, console3, console4);

        mockMvc.perform(get("/consoles")

                )
                .andDo(print())
                .andExpect(status().isOk());
    }


    // Console Controller Test Should Update a console
    @Test
    public void shouldUpdateSpecificConsoleById() throws Exception{
        Console console = new Console();
        console.setConsoleId(20);
        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Eight-core AMD Zen 2 CPU");
        BigDecimal price = new BigDecimal("499.99");
        console.setPrice(price);
        console.setQuantity(100);

        String inputJson = mapper.writeValueAsString(console);

        console.setModel("Playstation 7");

        mockMvc.perform(put("/consoles")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Console Controller Test Should Delete a console and return 204 Status Code
    @Test
    public void shouldDeleteExistingConsoleByIDAndReturn204StatusCode() throws Exception{
        mockMvc.perform(delete("/consoles/123"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }





    // Console Controller Test Should Get consoles by manufacturer
    @Test
    public void shouldGetConsolesByManufacturer() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/consoles/manufacturers/Sony"))
                .andDo(print())
                .andExpect(status().isOk());
    }


















}