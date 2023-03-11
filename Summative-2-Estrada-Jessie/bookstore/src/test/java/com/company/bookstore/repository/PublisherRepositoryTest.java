/**-------------------------------------------------------

 Publisher Repository Test

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */

package com.company.bookstore.repository;
import com.company.bookstore.model.Publisher;
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
public class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepo;

    @Before
    public void setUp() throws Exception {
        publisherRepo.deleteAll();
    }

    // Publisher repository test to add a publisher into database
    @Test
    public void shouldCreatePublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");

        publisher = publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);
    }

    // Publisher repository test to get a publisher by ID from database
    @Test
    public void shouldGetPublisherById(){
        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");

        publisher = publisherRepo.save(publisher);

        publisherRepo.findById(publisher.getId());

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);
    }

    // Publisher repository test to get all publishers from database
    @Test
    public void shouldGetAllPublishers() {
        //Arrange...
        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");

        publisherRepo.save(publisher);

        // Creating my second Customer object
        Publisher publisher2 = new Publisher();
        publisher2.setName("King Kong Books");
        publisher2.setStreet("1234 First Street");
        publisher2.setCity("San Diego");
        publisher2.setState("CA");
        publisher2.setPostalCode("48839");
        publisher2.setPhone("321-321-5774");
        publisher2.setEmail("kKongBooks@Netflix.com");

        publisherRepo.save(publisher2);

        // Creating my third Customer object
        Publisher publisher3 = new Publisher();
        publisher3.setName("Champion Publishing");
        publisher3.setStreet("4938 Thistreet Drive");
        publisher3.setCity("Los Angeles");
        publisher3.setState("CA");
        publisher3.setPostalCode("94475");
        publisher3.setPhone("321-321-7436");
        publisher3.setEmail("cPublishing@Netflix.com");

        publisherRepo.save(publisher3);


        List<Publisher> publisherList = publisherRepo.findAll();
        assertEquals(publisherList.size(), 3);
    }


    // Publisher repository test to update an existing publisher by ID from database
    @Test
    public void shouldUpdatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");

        publisherRepo.save(publisher);

        publisher.setName("UPDATE");
        publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);
    }

    // Publisher repository test to delete existing publisher by ID from database
    @Test
    public void deleteExistingPublisher() {
        //Arrange...
        Publisher publisher = new Publisher();
        publisher.setName("Godilla Books");
        publisher.setStreet("1234 Main Street");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setPostalCode("23374");
        publisher.setPhone("123-123-4553");
        publisher.setEmail("godillaBooks@Netflix.com");

        publisherRepo.save(publisher);

        //Assert...
        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);

        //Act...
        publisherRepo.deleteById(publisher.getId());

        publisher1 = publisherRepo.findById(publisher.getId());

        // Asserting if customer is not present in database
        assertFalse(publisher1.isPresent());
    }

}
