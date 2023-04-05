package com.company.gamestore.repository;

import com.company.gamestore.model.Game;
import com.company.gamestore.model.Invoice;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository;



    @Autowired
    GameRepository gameRepository;


    @Before
    public void setUp() throws Exception{
        invoiceRepository.deleteAll();
    }

    @Test
    public void addGetDeleteInvoice(){
        //Add Game - We are going to use it to pretend buying a game
        Game game = new Game();
        game.setTitle("Super Mario Odyssey");
        game.setEsrbRating("E");
        game.setDescription("Join Mario on a massive, globe-trotting 3D adventure!");
        game.setPrice(new BigDecimal( "59.99"));
        game.setStudio("Nintendo");
        game.setQuantity(50);

        game = gameRepository.save(game);

        //Add
        Invoice invoice = new Invoice();
        invoice.setName("Customer 1");
        invoice.setStreet("100 Main Street");
        invoice.setCity("Clovis");
        invoice.setState("CA");
        invoice.setZipcode("93612");
        invoice.setItemType("Game");
        invoice.setItemId(game.getGameId()); // getting the id from the game we created
        invoice.setQuantity(50);

        invoice = invoiceRepository.save(invoice);

        //Get
        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getId());
        assertEquals(invoice1.get(),invoice);

        invoiceRepository.deleteById(invoice.getId());

        invoice1 = invoiceRepository.findById(invoice.getId());

        assertFalse(invoice1.isPresent());

    }

    @Test
    public void getAllInvoices(){
        //Add Game - We are going to use it to pretend buying a game
        Game game = new Game();
        game.setTitle("Super Mario Odyssey");
        game.setEsrbRating("E");
        game.setDescription("Join Mario on a massive, globe-trotting 3D adventure!");
        game.setPrice(new BigDecimal( "59.99"));
        game.setStudio("Nintendo");
        game.setQuantity(50);

        game = gameRepository.save(game);

        //Add
        Invoice invoice = new Invoice();
        invoice.setName("Customer 1");
        invoice.setStreet("100 Main Street");
        invoice.setCity("Clovis");
        invoice.setState("CA");
        invoice.setZipcode("93612");
        invoice.setItemType("Game");
        invoice.setItemId(game.getGameId()); // getting the id from the game we created
        invoice.setQuantity(50);

        invoice = invoiceRepository.save(invoice);

        //Adding Second Invoice
        Game game2 = new Game();
        game2.setTitle("The Last of Us Part II");
        game2.setEsrbRating("M");
        game2.setDescription("Survive a post-apocalyptic world filled with danger and difficult choices!");
        game2.setPrice(new BigDecimal("69.99"));
        game2.setStudio("Naughty Dog");
        game2.setQuantity(75);

        game2 = gameRepository.save(game2);

        Invoice invoice2 = new Invoice();
        invoice2.setName("Customer 2");
        invoice2.setStreet("200 Broadway");
        invoice2.setCity("New York");
        invoice2.setState("NY");
        invoice2.setZipcode("10007");
        invoice2.setItemType("Game");
        invoice2.setItemId(game2.getGameId());
        invoice2.setQuantity(25);

        invoice2 = invoiceRepository.save(invoice2);

        List<Invoice> invoiceList = invoiceRepository.findAll();

        assertEquals(invoiceList.size(), 2);


    }

    @Test
    public void updateInvoice(){
        //Add Game - We are going to use it to pretend buying a game
        Game game = new Game();
        game.setTitle("Super Mario Odyssey");
        game.setEsrbRating("E");
        game.setDescription("Join Mario on a massive, globe-trotting 3D adventure!");
        game.setPrice(new BigDecimal( "59.99"));
        game.setStudio("Nintendo");
        game.setQuantity(50);

        game = gameRepository.save(game);

        //Add
        Invoice invoice = new Invoice();
        invoice.setName("Customer 1");
        invoice.setStreet("100 Main Street");
        invoice.setCity("Clovis");
        invoice.setState("CA");
        invoice.setZipcode("93612");
        invoice.setItemType("Game");
        invoice.setItemId(game.getGameId()); // getting the id from the game we created
        invoice.setQuantity(50);

        invoice = invoiceRepository.save(invoice);

        //Update
        invoice.setStreet("200 Broadway");
        invoice.setCity("New York");

        invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getId());
        assertEquals(invoice1.get(),invoice);
    }
}