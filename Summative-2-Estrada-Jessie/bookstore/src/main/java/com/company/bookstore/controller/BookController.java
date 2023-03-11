/**-------------------------------------------------------
 Book controller
 -To get, create, update, and delete a book

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */

package com.company.bookstore.controller;
import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class BookController {


    @Autowired
    BookRepository repo;

    // Create a book
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createNewBook(@RequestBody Book book) {
        return repo.save(book);
    }


    // Read by ID
    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id) {
        Optional<Book> value = repo.findById(id);
        if (value.isPresent()) {
            return value.get();
        } else {
            return null;
        }
    }


    // Read All
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repo.findAll();
    }


    // Update
    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExistingBook(@RequestBody Book book) {
        repo.save(book);
    }


    // Delete
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        repo.deleteById(id);
    }


    // Search Book by Author ID
    @GetMapping("/books/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Set<Book> getBookByAuthorId(@PathVariable int id){
        Set<Book> bookList= new HashSet<>();
        for (Book b: repo.findAll()) {
            if (b.getAuthorId() == id) {
                bookList.add(b);
            }
        }
        return bookList;
    }
}