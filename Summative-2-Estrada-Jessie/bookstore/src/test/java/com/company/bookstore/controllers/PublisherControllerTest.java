/**-------------------------------------------------------

 Publisher Controller Test

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */

package com.company.bookstore.controllers;
import com.company.bookstore.controller.PublisherController;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
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
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PublisherRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() throws Exception{

    }

    // Publisher controller test should create publisher
    @Test
    public void shouldCreatePublisher() throws Exception{
        Publisher publisher = new Publisher();
        publisher.setId(45);
        publisher.setName("HarperCollins");

        publisher.setStreet("4321 Thistreet Drive");
        publisher.setCity("Houston");
        publisher.setState("TX");
        publisher.setPostalCode("56789");
        publisher.setPhone("321-321-4321");
        publisher.setEmail("hCOllins@Netflix.com");


        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(post("/publishers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }
    // Publisher controller test should return specific publisher by ID
    @Test
    public void shouldGetSpecificPublisherById() throws Exception{
        // Create Publisher Object
        Publisher publisher = new Publisher();
        publisher.setId(25);
        publisher.setName("HarperCollins");

        publisher.setStreet("4321 Thistreet Drive");
        publisher.setCity("Houston");
        publisher.setState("TX");
        publisher.setPostalCode("56789");
        publisher.setPhone("321-321-4321");
        publisher.setEmail("hCOllins@Netflix.com");

        String outputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(get("/publishers/25"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Publisher controller test should return all Publishers
    @Test
    public void shouldGetAllPublishers() throws Exception{

        // Create Publisher Object 1
        Publisher publisher1 = new Publisher();
        publisher1.setId(25);
        publisher1.setName("HarperCollins");
        publisher1.setStreet("4321 Thistreet Drive");
        publisher1.setCity("Houston");
        publisher1.setState("TX");
        publisher1.setPostalCode("56789");
        publisher1.setPhone("321-321-4321");
        publisher1.setEmail("hCOllins@publisher.com");


        // Create Publisher Object 2
        Publisher publisher2 = new Publisher();
        publisher2.setId(25);
        publisher2.setName("Macmillan");
        publisher2.setStreet("9789 Maple Drive");
        publisher2.setCity("Houston");
        publisher2.setState("TX");
        publisher2.setPostalCode("56789");
        publisher2.setPhone("888-222-1234");
        publisher2.setEmail("macmillan@publisher.com");


        // Create Publisher Object 3
        Publisher publisher3 = new Publisher();
        publisher3.setId(25);
        publisher3.setName("Penguin Random House");
        publisher3.setStreet("7453 Third Blvd");
        publisher3.setCity("Portland");
        publisher3.setState("OR");
        publisher3.setPostalCode("76684");
        publisher3.setPhone("888-333-3214");
        publisher3.setEmail("pRHouse@publisher.com");


        // Create Publisher Object 4
        Publisher publisher4 = new Publisher();
        publisher4.setId(25);
        publisher4.setName("Pearson PLC");
        publisher4.setStreet("5576 Last Drive");
        publisher4.setCity("Miami");
        publisher4.setState("FL");
        publisher4.setPostalCode("76634");
        publisher4.setPhone("444-787-9879");
        publisher4.setEmail("pearsonplc@publisher.com");

        List<Publisher> publisherList;
        publisherList = Arrays.asList(publisher1, publisher2, publisher3, publisher4);

        mockMvc.perform(get("/publishers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Publisher controller test should update existing publisher record by ID
    @Test
    public void shouldUpdateExistingPublisherRecordById() throws Exception{

        // Create Author Object
        Publisher publisher = new Publisher();
        publisher.setId(25);
        publisher.setName("Macmillan");
        publisher.setStreet("9789 Maple Drive");
        publisher.setCity("Houston");
        publisher.setState("TX");
        publisher.setPostalCode("56789");
        publisher.setPhone("888-222-1234");
        publisher.setEmail("macmillan@publisher.com");

        String inputJson = mapper.writeValueAsString(publisher);

        // Made a change on the phone
        publisher.setPhone("323-323-322");

        mockMvc.perform(put("/publishers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Publisher controller test should delete an existing publisher and return 204 status code
    @Test
    public void shouldDeleteExistingPublisherByIDAndReturn204StatusCode() throws Exception{
        mockMvc.perform(delete("/publishers/321"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
