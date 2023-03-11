/**-------------------------------------------------------

 Book Repository Test

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */
package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorRepository authorRepo;

    @Autowired
    PublisherRepository publisherRepo;


    @Before
    public void setUp() throws Exception {
        bookRepo.deleteAll();
        authorRepo.deleteAll();
        publisherRepo.deleteAll();
    }

    // Book repository test to add aa book into database
    @Test
    public void addBook() {
        Author author = new Author();
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");
        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");
        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("1112223345");
        book.setPublishDate(LocalDate.of(2010, 10, 10));
        book.setAuthorId(author.getId());
        book.setTitle("Green Eggs and Ham");
        book.setPublisherId(publisher.getId());
        book.setPrice(BigDecimal.valueOf(28.99));
        bookRepo.save(book);

        Optional<Book> book1 = bookRepo.findById(book.getId());

        assertEquals(book1.get(), book);
    }

    // Book repository test to get a book by ID from database
    @Test
    public void shouldGetSpecificBookById() {

        Author author = new Author();
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");
        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");
        publisherRepo.save(publisher);


        Book book = new Book();
        book.setIsbn("1112223345");
        book.setPublishDate(LocalDate.of(2010, 10, 10));
        book.setAuthorId(author.getId());
        book.setTitle("Green Eggs and Ham");
        book.setPublisherId(publisher.getId());
        book.setPrice(BigDecimal.valueOf(28.99));

        Book book2 = new Book();
        book2.setIsbn("8493738");
        book2.setPublishDate(LocalDate.of(2001, 03, 02));
        book2.setAuthorId(author.getId());
        book2.setTitle("Lord of the Rings");
        book2.setPublisherId(publisher.getId());
        book2.setPrice(BigDecimal.valueOf(31.99));

        bookRepo.save(book);
        bookRepo.save(book2);


        Optional<Book> book1 = bookRepo.findById(book.getId());

        assertEquals(book1.get(), book);
    }

    // Book repository test to get all books from database
    @Test
    public void shouldGetAllBooks() {

        Author author = new Author();
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");
        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");
        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("1112223345");
        book.setPublishDate(LocalDate.of(2010, 10, 10));
        book.setAuthorId(author.getId());
        book.setTitle("Green Eggs and Ham");
        book.setPublisherId(publisher.getId());
        book.setPrice(BigDecimal.valueOf(28.99));


        Book book2 = new Book();
        book2.setIsbn("8493738");
        book2.setPublishDate(LocalDate.of(2001, 03, 02));
        book2.setAuthorId(author.getId());
        book2.setTitle("Lord of the Rings");
        book2.setPublisherId(publisher.getId());
        book2.setPrice(BigDecimal.valueOf(31.99));



        Book book3 = new Book();
        book3.setIsbn("9978356");
        book3.setPublishDate(LocalDate.of(2002, 05, 12));
        book3.setAuthorId(author.getId());
        book3.setTitle("James and the Giant Peach");
        book3.setPublisherId(publisher.getId());
        book3.setPrice(BigDecimal.valueOf(10.99));

        bookRepo.save(book);
        bookRepo.save(book2);
        bookRepo.save(book3);

        List<Book> bookList = bookRepo.findAll();
        assertEquals(bookList.size(), 3);
    }




    // Book repository test to update an existing book by ID from database
    @Test
    public void shouldUpdateBook() {

        Author author = new Author();
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");
        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");
        publisherRepo.save(publisher);


        Book book = new Book();
        book.setIsbn("1112223345");
        book.setPublishDate(LocalDate.of(2010, 10, 10));
        book.setAuthorId(author.getId());
        book.setTitle("Green Eggs and Ham");
        book.setPublisherId(publisher.getId());
        book.setPrice(BigDecimal.valueOf(28.99));

        bookRepo.save(book);

        book.setTitle("UPDATED TITLE");
        bookRepo.save(book);

        Optional<Book> book1 = bookRepo.findById(book.getId());

        assertEquals(book1.get(), book);
    }


    // Book repository test to delete existing book by ID from database
    @Test
    public void shouldDeleteBook() {

        Author author = new Author();
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");
        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");
        publisherRepo.save(publisher);


        Book book = new Book();
        book.setIsbn("1112223345");
        book.setPublishDate(LocalDate.of(2010, 10, 10));
        book.setAuthorId(author.getId());
        book.setTitle("Green Eggs and Ham");
        book.setPublisherId(publisher.getId());
        book.setPrice(BigDecimal.valueOf(28.99));

        bookRepo.save(book);

        Optional<Book> book1 = bookRepo.findById(book.getId());

        assertEquals(book1.get(), book);

        bookRepo.deleteById(book.getId());

        book1 = bookRepo.findById(book.getId());

        assertFalse(book1.isPresent());
    }

    // Book repository test to get books from an existing author by ID from database
    @Test
    public void shouldGetBooksByAuthorId() {

        Author author = new Author();
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");
        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");
        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");
        publisherRepo.save(publisher);


        Book book = new Book();
        book.setIsbn("100110101");
        book.setPublishDate(LocalDate.of(2019, 10, 20));
        book.setAuthorId(author.getId());
        book.setTitle("Book of Thieves");
        book.setPublisherId(publisher.getId());
        book.setPrice(BigDecimal.valueOf(18.99));

        bookRepo.save(book);

        Book book2 = new Book();
        book2.setIsbn("8493738");
        book2.setPublishDate(LocalDate.of(2001, 03, 02));
        book2.setAuthorId(author.getId());
        book2.setTitle("Lord of the Rings");
        book2.setPublisherId(publisher.getId());
        book2.setPrice(BigDecimal.valueOf(31.99));
        bookRepo.save(book2);

        Book book3 = new Book();
        book3.setIsbn("9978356");
        book3.setPublishDate(LocalDate.of(2002, 05, 12));
        book3.setAuthorId(author.getId());
        book3.setTitle("James and the Giant Peach");
        book3.setPublisherId(publisher.getId());
        book3.setPrice(BigDecimal.valueOf(10.99));
        bookRepo.save(book3);

        List<Book> bookList = bookRepo.findByAuthorId(author.getId());
        assertEquals(bookList.size(), 3);
    }
}