package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.model.Game;
import com.company.gamestore.repository.*;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphController {

    @Autowired
    ServiceLayer serviceLayer;


    //Game

    @QueryMapping
    public List<Game> findAllGames(){
        return serviceLayer.getAllGames();
    }

    @QueryMapping
    public Game findGameById(@Argument Integer id){
        return serviceLayer.findGame(id);
    }

    @QueryMapping
    public List<Game> findGameByTitle(@Argument String title){
        return serviceLayer.getAllGamesByTitle(title);
    }

    @QueryMapping
    public  List<Game> findGameByEsrb(@Argument String esrb){
        return serviceLayer.getAllGamesByESRB(esrb);
    }

    @QueryMapping
    public  List<Game> findGameByStudio(@Argument String studio){
        return serviceLayer.getAllGamesByStudio(studio);
    }

    // CONSOLES
    @QueryMapping
    public List<Console> findAllConsoles(){
        return serviceLayer.getAllConsoles();
    }

    @QueryMapping
    public Console findConsoleById(@Argument Integer consoleId){
        return serviceLayer.findConsole(consoleId);
    }

    @QueryMapping
    public List<Console> findConsoleByManufacturer(@Argument String manufacturer){
        return serviceLayer.getAllConsolesByManufacturer(manufacturer);
    }



}
