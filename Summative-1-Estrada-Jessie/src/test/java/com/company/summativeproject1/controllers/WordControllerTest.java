package com.company.summativeproject1.controllers;

import com.company.summativeproject1.models.Definition;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WordController.class)
public class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private Definition definition;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnDefinition() throws Exception {
        String outputJson = mapper.writeValueAsString(definition);

        mockMvc.perform(get("/word"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}