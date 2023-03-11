/**-------------------------------------------------------

 Book Controller Test

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */

package com.company.bookstore.controllers;
import com.company.bookstore.controller.BookController;
import com.company.bookstore.model.Book;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
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
import java.time.LocalDate;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        BookRepository repo;

        @MockBean
        AuthorRepository authorRepository;

        private ObjectMapper mapper = new ObjectMapper();

        @Before
        public void setup() throws Exception{

        }

        // Book controller test should create book
        @Test
        public void shouldCreateBook() throws Exception{
                Book book = new Book();

                book.setId(24);
                book.setIsbn("123456789");
                book.setAuthorId(123);
                book.setTitle("Green Eggs and Ham");
                book.setPublisherId(321);
                book.setPrice(new BigDecimal(20.34));

                String inputJson = mapper.writeValueAsString(book);

                mockMvc.perform(post("/books")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                        )
                        .andDo(print())
                        .andExpect(status().isCreated());
        }


        // Book controller test should return specific book by ID
        @Test
        public void shouldGetSpecificBookById() throws Exception{
                Book book = new Book();

                book.setId(24);
                book.setIsbn("123456789");
                book.setPublishDate(LocalDate.of(2020,1,8));
                book.setAuthorId(123);
                book.setTitle("Green Eggs and Ham");
                book.setPublisherId(321);
                book.setPrice(new BigDecimal(20.34));

                mockMvc.perform(get("/books/24"))
                        .andDo(print())
                        .andExpect(status().isOk());
        }


        // Book controller test should return all books
        @Test
        public void shouldGetAllBooks() throws Exception{
                // Create book object 1
                Book book1 = new Book();
                book1.setId(24);
                book1.setIsbn("123456789");
                book1.setPublishDate(LocalDate.of(2020,1,8));
                book1.setAuthorId(123);
                book1.setTitle("Green Eggs and Ham");
                book1.setPublisherId(321);
                book1.setPrice(new BigDecimal(20.34));

                // Create book object 2
                Book book2 = new Book();
                book2.setId(55);
                book2.setIsbn("123456789");
                book2.setPublishDate(LocalDate.of(2020,1,8));
                book2.setAuthorId(456);
                book2.setTitle("The Green Book");
                book2.setPublisherId(321);
                book2.setPrice(new BigDecimal(20.34));

                // Create book object 3
                Book book3 = new Book();
                book3.setId(77);
                book3.setIsbn("123456789");
                book3.setPublishDate(LocalDate.of(2020,1,8));
                book3.setAuthorId(123);
                book3.setTitle("Harry Potter");
                book3.setPublisherId(321);
                book3.setPrice(new BigDecimal(20.34));

                mockMvc.perform(get("/books"))
                        .andDo(print())
                        .andExpect(status().isOk());
        }


        // Book controller test should update existing book by ID
        @Test
        public void shouldUpdateBookById() throws Exception {
                Book book = new Book();

                book.setId(77);
                book.setIsbn("123456789");
                book.setAuthorId(123);
                book.setTitle("Harry Potter");
                book.setPublisherId(321);
                book.setPrice(new BigDecimal(20.34));

                String inputJson = mapper.writeValueAsString(book);



                mockMvc.perform(put("/books")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                        )
                        .andDo(print())
                        .andExpect(status().isNoContent());

        }


        // Book controller test should delete an existing book and return 204 status code
        @Test
        public void shouldDeleteExistingBookByIDAndReturn204StatusCode() throws Exception{
                mockMvc.perform(delete("/books/432"))
                        .andDo(print())
                        .andExpect(status().isNoContent());
        }


        // Book controller test should return books by author ID
        @Test
        public void shouldSearchBookByAuthorId () throws Exception{
                mockMvc.perform(MockMvcRequestBuilders.get("/books/author/13"))
                        .andDo(print())
                        .andExpect(status().isOk());
        }


}