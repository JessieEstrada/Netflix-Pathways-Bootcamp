/**-------------------------------------------------------
Author Controller
-To get, create, update and delete an author

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */

package com.company.bookstore.controller;
import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    AuthorRepository repo;

    // Create an Author
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author createNewAuthor(@RequestBody Author author){
        return repo.save(author);
    }

    //Read by ID
    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthor(@PathVariable int id){
        Optional<Author> value = repo.findById(id);
        if(value.isPresent()){
            return value.get();
        } else{
            return null;
        }
    }

    //Read All
    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
        return repo.findAll();
    }
    //Update
    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExistingAuthor(@RequestBody Author author){
        repo.save(author);
    }
    //Delete
    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id){
        repo.deleteById(id);
    }

}
