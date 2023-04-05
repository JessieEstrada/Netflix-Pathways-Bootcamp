package com.company.gamestore.controller;

import com.company.gamestore.model.Game;
import com.company.gamestore.repository.GameRepository;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

//    {
//        "title": "Super Mario Odyssey",
//            "esrbRating": "E",
//            "description": "Join Mario on a massive, globe-trotting 3D adventure!",
//            "price": 59.99,
//            "studio": "Nintendo",
//            "quantity": 50
//    }

    @Autowired
    ServiceLayer serviceLayer;


    // Create a new Game information
    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGameInformation (@RequestBody @Valid Game game){
        return serviceLayer.saveGame(game);
    }

    // Find a  Game  by id
    @GetMapping("/games/{id}")
    public Game findGameInfoById(@PathVariable int id){
        return serviceLayer.findGame(id);
    }

    //Update  Game
    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGameInfo(@RequestBody @Valid Game game){
        //When  updating, the user must provide the json body of the  game including its id
        // send to this path in order for JPA to update  and not add a new game info
        serviceLayer.updateGame(game);
    }


    //Delete  Game
    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGameInfo(@PathVariable int id){
        serviceLayer.deleteGame(id);
    }

    //Read all Game info's
    @GetMapping("/allgameinfo")
    public List<Game> findAllGames(){
        return serviceLayer.getAllGames();
    }




    // Search game  by Studio
    @GetMapping("/games/Studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> GetGameByStudio(@PathVariable String studio){

        return serviceLayer.getAllGamesByStudio(studio);
    }

    // Search game ESRB
    @GetMapping("/games/ESRB/{esrb}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> GetGameByESRB(@PathVariable String esrb){

        return serviceLayer.getAllGamesByESRB(esrb);
    }

    // Search game Title
    @GetMapping("/games/Title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> GetGameByTitle(@PathVariable String title){

        return serviceLayer.getAllGamesByTitle(title);
    }



}
