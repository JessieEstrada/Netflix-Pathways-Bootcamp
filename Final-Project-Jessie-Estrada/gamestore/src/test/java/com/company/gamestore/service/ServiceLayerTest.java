package com.company.gamestore.service;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.repository.GameRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ServiceLayerTest {

    ServiceLayer serviceLayer;

    @Mock
    ConsoleRepository consoleRepository;

    @Mock
    GameRepository gameRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        serviceLayer = new ServiceLayer(consoleRepository, null, gameRepository, null, null, null);
    }

    @Test
    public void testGetAllConsoles() {

        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("825GB");
        console.setProcessor("AMD Zen 2");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(10);

        Console console2 = new Console();
        console2.setConsoleId(2);
        console2.setModel("Xbox Series X");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("1TB");
        console2.setProcessor("Custom AMD Zen 2");
        console2.setPrice(new BigDecimal("499.99"));
        console2.setQuantity(5);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);
        consoleList.add(console2);

        when(consoleRepository.findAll()).thenReturn(consoleList);

        List<Console> fromService = serviceLayer.getAllConsoles();

        assertEquals(consoleList.size(), fromService.size());
        assertEquals(consoleList, fromService);

    }

    @Test
    public void testGetAllGames() {

        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Red Dead Redemption 2");
        game.setDescription("Western action-adventure game developed by Rockstar Games");
        game.setStudio("Rockstar Games");
        game.setEsrbRating("M");
        game.setPrice(new BigDecimal("59.99"));
        game.setQuantity(20);

        Game game2 = new Game();
        game2.setGameId(2);
        game2.setTitle("The Legend of Zelda: Breath of the Wild");
        game2.setDescription("Action-adventure game developed and published by Nintendo");
        game2.setStudio("Nintendo");
        game2.setEsrbRating("E");
        game2.setPrice(new BigDecimal("49.99"));
        game2.setQuantity(15);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);
        gameList.add(game2);

        when(gameRepository.findAll()).thenReturn(gameList);

        List<Game> fromService = serviceLayer.getAllGames();

        assertEquals(gameList.size(), fromService.size());
        assertEquals(gameList, fromService);

    }
}
