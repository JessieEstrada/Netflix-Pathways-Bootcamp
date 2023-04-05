package com.company.gamestore.repository;

import com.company.gamestore.model.Game;
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
public class GameRepositoryTest {

    @Autowired GameRepository gameRepository;

    @Before
    public void setUp() throws Exception{
        gameRepository.deleteAll();

    }

    @Test
    public void addGetDeleteGame(){

        //Add
        Game game = new Game();
        game.setTitle("Super Mario Odyssey");
        game.setEsrbRating("E");
        game.setDescription("Join Mario on a massive, globe-trotting 3D adventure!");
        game.setPrice(new BigDecimal( "59.99"));
        game.setStudio("Nintendo");
        game.setQuantity(50);

        game = gameRepository.save(game);

        //Get
        Optional<Game> game1 = gameRepository.findById(game.getGameId());

        assertEquals(game1.get(),game);

        //Delete
        gameRepository.deleteById(game.getGameId());

        game1 = gameRepository.findById(game.getGameId());
        assertFalse(game1.isPresent());
    }

    @Test
    public void getAllGames(){
        //Add
        Game game = new Game();
        game.setTitle("Super Mario Odyssey");
        game.setEsrbRating("E");
        game.setDescription("Join Mario on a massive, globe-trotting 3D adventure!");
        game.setPrice(new BigDecimal( "59.99"));
        game.setStudio("Nintendo");
        game.setQuantity(50);

        game = gameRepository.save(game);

        //Second Game

        Game game2 = new Game();


        game2.setTitle("The Legend of Zelda: Breath of the Wild");
        game2.setEsrbRating("E10+");
        game2.setDescription("Explore a vast open world filled with danger and adventure!");
        game2.setPrice(new BigDecimal("59.99"));
        game2.setStudio("Nintendo");
        game2.setQuantity(25);

        game = gameRepository.save(game2);

        List<Game> gameList = gameRepository.findAll();

        assertEquals(gameList.size(), 2);

    }

    @Test
    public void updateGame(){
        //Add
        Game game = new Game();
        game.setTitle("Super Mario Odyssey");
        game.setEsrbRating("E");
        game.setDescription("Join Mario on a massive, globe-trotting 3D adventure!");
        game.setPrice(new BigDecimal( "59.99"));
        game.setStudio("Nintendo");
        game.setQuantity(50);

        game = gameRepository.save(game);

        //Update
        game.setTitle("The Legend of Zelda: Breath of the Wild");
        game.setEsrbRating("E10+");

        gameRepository.save(game);

        Optional<Game> game1 = gameRepository.findById(game.getGameId());
        assertEquals(game1.get(),game);
    }

}