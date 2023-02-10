package com.company.summativeproject1.controllers;

import com.company.summativeproject1.models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MagicController.class)
public class MagicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private Answer answer;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnAnswerWithQuestion() throws Exception {
        // answer.setQuestion();
        Answer answer = new Answer();
        answer.setQuestion("Test questions");

        String inputJson = mapper.writeValueAsString(answer);

        mockMvc.perform(post("/magic")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());

    }
    @Test
    public void shouldReturnAnswerWithoutQuestion() throws Exception {
        Answer answer = new Answer();

        String inputJson = mapper.writeValueAsString(answer);
        String outputJson = mapper.writeValueAsString(answer);

        mockMvc.perform(post("/magic")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());

    }
}