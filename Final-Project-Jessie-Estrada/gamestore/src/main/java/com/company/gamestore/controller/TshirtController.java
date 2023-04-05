package com.company.gamestore.controller;

import com.company.gamestore.model.Tshirt;
import com.company.gamestore.repository.TshirtRepository;
import com.company.gamestore.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class TshirtController {

//    {
//        "tShirtId": 3,
//            "size": "L",
//            "color": "Blue",
//            "description": "A comfortable and stylish T-shirt for everyday wear",
//            "price": 19.99,
//            "quantity": 20
//    }




    @Autowired
    ServiceLayer serviceLayer;

    // Create a Tshirt
    @PostMapping("/tshirts")
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt createNewTshirt(@RequestBody @Valid Tshirt tshirt){
        return serviceLayer.saveTshirt(tshirt);
    }

    // Get a Tshirt by ID
    @GetMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tshirt getTshirt(@PathVariable int id){
        return serviceLayer.findTshirt(id);
    }

    // Get all Tshirts
    @GetMapping("/tshirts")
    public List<Tshirt> getAllTshirts() {
        return serviceLayer.getAllTshirts();
    }


    // Update a Tshirt
    @PutMapping("/tshirts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExistingTshirt(@RequestBody @Valid Tshirt tshirt) {
        serviceLayer.updateTshirt(tshirt);
    }

    // Delete a Tshirt
    @DeleteMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id) {
        serviceLayer.deleteTshirt(id);
    }

    // Search for Tshirts by color
    @GetMapping("/tshirts/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> GetTshirtsByColor(@PathVariable String color){
        return serviceLayer.getAllTshirtsByColor(color);
    }

    // Search for Tshirts by size
    @GetMapping("/tshirts/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> GetTshirtsBySize(@PathVariable String size){
        return serviceLayer.getAllTshirtBySize(size);
    }

}
