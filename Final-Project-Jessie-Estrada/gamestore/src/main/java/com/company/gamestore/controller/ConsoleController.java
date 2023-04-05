package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class ConsoleController {
// json body to test post. If you want to do update,
// don't forget to also put the id attribute inside this jsonbody
//    {
//        "model": "Nintendo Switch",
//            "manufacturer": "Nintendo",
//            "memoryAmount": "1T",
//            "processor": "NVIDIA Custom Tegra processor",
//            "price": 299.99,
//            "quantity": 100
//    }

    @Autowired
    ServiceLayer serviceLayer;

    // Create a console
    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public Console createNewConsole(@RequestBody @Valid Console console){
        return serviceLayer.saveConsole(console);
    }

    // Get a Console by ID
    @GetMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsoleById(@PathVariable int id){
        return serviceLayer.findConsole(id);
    }

    // Get all consoles
    @GetMapping("/consoles")
    public List<Console> getAllConsoles() {
        return serviceLayer.getAllConsoles();
    }


    // Update a console
    @PutMapping("/consoles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExistingConsole(@RequestBody @Valid Console console) {
        serviceLayer.updateConsole(console);
    }

    // Delete a console
    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        serviceLayer.deleteConsole(id);
    }

    // Get consoles by manufacturer
    @GetMapping("/consoles/manufacturers/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer){

        return serviceLayer.getAllConsolesByManufacturer(manufacturer);
    }





















}
