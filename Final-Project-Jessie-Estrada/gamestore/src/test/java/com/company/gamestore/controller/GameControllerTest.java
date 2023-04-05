package com.company.gamestore.controller;

import com.company.gamestore.model.Game;
import com.company.gamestore.service.ServiceLayer;
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
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private ServiceLayer serviceLayerMB;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() throws Exception{

    }

    //Create
    @Test
    public void shouldCreateGame() throws Exception{
        Game game = new Game();
        game.setGameId(40);
        game.setTitle("Super Mario Odyssey");
        game.setEsrbRating("E");
        game.setDescription("Join Mario on a massive, globe-trotting 3D adventure!");
        BigDecimal price = new BigDecimal("59.99");
        game.setPrice(price);
        game.setStudio("Nintendo");
        game.setQuantity(100);


        String inputJson = mapper.writeValueAsString(game);

        mockMvc.perform(post("/games")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Console Controller Test Should Get a Console by ID
    @Test
    public void shouldGetSpecificGameById() throws Exception{
        Game game = new Game();
        game.setGameId(40);
        game.setTitle("Super Mario Odyssey");
        game.setEsrbRating("E");
        game.setDescription("Join Mario on a massive, globe-trotting 3D adventure!");
        BigDecimal price = new BigDecimal("59.99");
        game.setPrice(price);
        game.setStudio("Nintendo");
        game.setQuantity(100);


        String inputJson = mapper.writeValueAsString(game);

        mockMvc.perform(get("/games/40")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }



    // Console Controller Test Should Get all consoles
    @Test
    public void shouldGetAllGames() throws Exception{
        Game game1 = new Game();
        game1.setGameId(40);
        game1.setTitle("Super Mario Odyssey");
        game1.setEsrbRating("E");
        game1.setDescription("Join Mario on a massive, globe-trotting 3D adventure!");
        BigDecimal price1 = new BigDecimal("59.99");
        game1.setPrice(price1);
        game1.setStudio("Nintendo");
        game1.setQuantity(100);


        Game game2 = new Game();
        game2.setGameId(40);
        game2.setTitle("Mario Kart 8");
        game2.setEsrbRating("E");
        game2.setDescription("Join Mario and his friends, in a non-stop racing adventure!");
        BigDecimal price2 = new BigDecimal("50.99");
        game2.setPrice(price2);
        game2.setStudio("Nintendo");
        game2.setQuantity(80);


        Game game3 = new Game();
        game3.setGameId(40);
        game3.setTitle("Marvel's Spider-Man: Miles Morales");
        game3.setEsrbRating("T");
        game3.setDescription("Swing around the city, beat up thugs, and showcase your web slinging skills alongside Spider-Man!");
        BigDecimal price3 = new BigDecimal("75.99");
        game3.setPrice(price3);
        game3.setStudio("Insomniac Games");
        game3.setQuantity(200);


        Game game4 = new Game();
        game4.setGameId(40);
        game4.setTitle("FIFA 23");
        game4.setEsrbRating("E");
        game4.setDescription("Showcase your soccer skills by taking control of your favorite teams!");
        BigDecimal price4 = new BigDecimal("80.99");
        game4.setPrice(price4);
        game4.setStudio("EA Sports");
        game4.setQuantity(45);

        List<Game> gameList;
        gameList = Arrays.asList(game1, game2, game3, game4);

        mockMvc.perform(get("/allgameinfo")

                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Game Controller Test Should Update A Game
    @Test
    public void shouldUpdateSpecificGameById() throws Exception{
        Game game = new Game();
        game.setGameId(40);
        game.setTitle("FIFA 23");
        game.setEsrbRating("E");
        game.setDescription("Showcase your soccer skills by taking control of your favorite teams!");
        BigDecimal price = new BigDecimal("80.99");
        game.setPrice(price);
        game.setStudio("EA Sports");
        game.setQuantity(45);

        String inputJson = mapper.writeValueAsString(game);

        BigDecimal newPrice = new BigDecimal("20.99");
        game.setPrice(newPrice);

        mockMvc.perform(put("/games")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    // Game Controller Test Should Delete a Game and return 204 Status Code
    @Test
    public void shouldDeleteExistingGamesByIDAndReturn204StatusCode() throws Exception{
        mockMvc.perform(delete("/games/123"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    // Game Controller Test Should Get Games by Studio
    @Test
    public void shouldGetGamesByStudio() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/games/Studio/Nintendo"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Games Controller Test Should Get Games by ESRB
    @Test
    public void shouldGetGamesByESRB() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/games/ESRB/E"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    // Games Controller Test Should Get Games by Title
    @Test
    public void shouldGetGamesByTitle() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/games/ESRB/FIFA 23"))
                .andDo(print())
                .andExpect(status().isOk());
    }










}