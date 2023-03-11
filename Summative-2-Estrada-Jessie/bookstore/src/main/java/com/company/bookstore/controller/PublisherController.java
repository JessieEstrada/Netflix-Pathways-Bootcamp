/**-------------------------------------------------------
 Publisher Controller
 -To get, create, update, and delete a publisher

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */

package com.company.bookstore.controller;

import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    PublisherRepository repo;

    // Create
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher createNewPublisher(@RequestBody Publisher publisher){
        return repo.save(publisher);
    }

    // Read by ID
    @GetMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisher(@PathVariable int id){
        Optional<Publisher> value = repo.findById(id);
        if(value.isPresent()){
            return value.get();
        } else{
            return null;
        }
    }

    // Read All
    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers(){
        return repo.findAll();
    }

    // Update
    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExistingPublisher(@RequestBody Publisher publisher){
        repo.save(publisher);
    }

    // Delete
    @DeleteMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id){
        repo.deleteById(id);
    }
}
