/**-------------------------------------------------------

 Author Controller Test

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */

package com.company.bookstore.controllers;
import com.company.bookstore.controller.AuthorController;
import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
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
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AuthorRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() throws Exception{

    }

    // Author controller test should create author
    @Test
    public void shouldCreateAuthor() throws Exception{
        Author author = new Author();
        author.setId(45);
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");

        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");


        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(post("/authors")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Author controller test should return specific author by ID
    @Test
    public void shouldGetSpecificAuthorById() throws Exception{
        // Create Customer Object
        Author author = new Author();
        author.setId(45);
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");

        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");

        String outputJson = mapper.writeValueAsString(author);

        mockMvc.perform(get("/authors/45"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Author controller test should update existing author by ID
    @Test
    public void shouldUpdateExistingAuthorRecordById() throws Exception{

        // Create Author Object
        Author author = new Author();
        author.setId(45);
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");

        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");

        String inputJson = mapper.writeValueAsString(author);

        // Made a change on the phone
        author.setPhone("323-323-322");

        mockMvc.perform(put("/authors")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Author controller test should return all authors
    @Test
    public void shouldGetAllAuthors() throws Exception{
        // Create Author Object 1
        Author author1 = new Author();
        author1.setId(45);
        author1.setFirstName("Pepe");
        author1.setLastName("Aguilar");

        author1.setStreet("1234 Somestreet Drive");
        author1.setCity("Los Angeles");
        author1.setState("CA");
        author1.setPostalCode("54321");
        author1.setPhone("123-123-1234");
        author1.setEmail("pAguilar@Netflix.com");


        // Create Author Object 2
        Author author2 = new Author();
        author2.setId(45);
        author2.setFirstName("James");
        author2.setLastName("Smith");

        author2.setStreet("4538 Coolstreet Blvd");
        author2.setCity("San Antonio");
        author2.setState("TX");
        author2.setPostalCode("54322");
        author2.setPhone("111-222-4321");
        author2.setEmail("jSmith@Netflix.com");


        // Create Author Object 3
        Author author3 = new Author();
        author3.setId(45);
        author3.setFirstName("Maria");
        author3.setLastName("Hernandez");

        author3.setStreet("1235 Main Street");
        author3.setCity("Los Angeles");
        author3.setState("CA");
        author3.setPostalCode("54332");
        author3.setPhone("222-111-9867");
        author3.setEmail("mHernandez@Netflix.com");


        // Create Author Object 4
        Author author4 = new Author();
        author4.setId(45);
        author4.setFirstName("Antonio");
        author4.setLastName("Fernandez");

        author4.setStreet("3286 Finals Drive");
        author4.setCity("San Jose");
        author4.setState("CA");
        author4.setPostalCode("43562");
        author4.setPhone("333-777-0842");
        author4.setEmail("aFernandez@Netflix.com");

        List<Author> authorList;
        authorList = Arrays.asList(author1, author2, author3, author4);

        mockMvc.perform(get("/authors")

                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Author controller test should delete an existing author and return 204 status code
    @Test
    public void shouldDeleteExistingAuthorByIDAndReturn204StatusCode() throws Exception{
        mockMvc.perform(delete("/authors/123"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }














}
