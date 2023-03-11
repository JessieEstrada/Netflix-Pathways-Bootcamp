/**-------------------------------------------------------

 Author Repository Test

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */

package com.company.bookstore.repository;
import com.company.bookstore.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepo;

    @Before
    public void setUp() throws Exception{
        authorRepo.deleteAll();
    }

    // Author repository test to add an author into database
    @Test
    public void addAuthor() {
        //Arrange...
        Author author = new Author();
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");

        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");

        //Act...
        author = authorRepo.save(author);

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getId());

        // Asserting if Customer is added into database
        assertEquals(author1.get(), author);
    }

    // Author repository test to get and author by ID from database
    @Test
    public void getAuthorById() {
        //Arrange...
        Author author = new Author();
        author.setFirstName("Pepe");
        author.setLastName("Aguilar");
        author.setStreet("1234 Somestreet Drive");
        author.setCity("Los Angeles");
        author.setState("CA");
        author.setPostalCode("54321");
        author.setPhone("123-123-1234");
        author.setEmail("pAguilar@Netflix.com");

        // Creating my second Customer object
        Author author2 = new Author();
        author2.setFirstName("James");
        author2.setLastName("Smith");
        author2.setStreet("9867 Main Street");
        author2.setCity("San Diego");
        author2.setState("CA");
        author2.setPostalCode("85564");
        author2.setPhone("321-098-3649");
        author2.setEmail("jSmith@Netflix.com");

        authorRepo.save(author);
        authorRepo.save(author2);

        //Act...
        authorRepo.findById(author.getId());

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getId());

        //Asserting if we return customer with particular ID
        assertEquals(author1.get(), author);
    }

    // Author repository test to get all authors from database
    @Test
    public void shouldGetAllAuthors() {
        //Arrange...
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

        // Creating my second Customer object
        Author author2 = new Author();
        author2.setFirstName("James");
        author2.setLastName("Smith");

        author2.setStreet("9867 Main Street");
        author2.setCity("San Diego");
        author2.setState("CA");
        author2.setPostalCode("85564");
        author2.setPhone("321-098-3649");
        author2.setEmail("jSmith@Netflix.com");

        authorRepo.save(author2);

        // Creating my third Customer object
        Author author3 = new Author();
        author3.setFirstName("Lionel");
        author3.setLastName("Messi");

        author3.setStreet("5637 Champ Street");
        author3.setCity("Houston");
        author3.setState("TX");
        author3.setPostalCode("83374");
        author3.setPhone("101-010-1010");
        author3.setEmail("lMessi@Netflix.com");

        authorRepo.save(author3);


        List<Author> authorList = authorRepo.findAll();
        assertEquals(authorList.size(), 3);
    }

    // Author repository test to update an existing author by ID from database
    @Test
    public void shouldUpdateAuthor() {
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

        author.setFirstName("UPDATE");
        authorRepo.save(author);

        Optional<Author> author1 = authorRepo.findById(author.getId());

        assertEquals(author1.get(), author);
    }

    // Author repository test to delete existing author by ID from database
    @Test
    public void deleteExistingAuthor() {
        //Arrange...
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

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getId());

        assertEquals(author1.get(), author);

        //Act...
        authorRepo.deleteById(author.getId());

        author1 = authorRepo.findById(author.getId());

        // Asserting if customer is not present in database
        assertFalse(author1.isPresent());
    }

}
