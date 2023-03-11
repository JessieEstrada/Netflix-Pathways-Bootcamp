/**-------------------------------------------------------
 Graph Controller
 -To provide supports for querying with GraphQL

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */
package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    // Query to find author by ID, including books for the publisher and authors for the books
    @QueryMapping
    public Author findAuthorById(@Argument int id) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()){
            return author.get();
        }
        else{
            return null;
        }
    }
    // Query to find book by ID, including books by the author
    @QueryMapping
    public Book findBookById(@Argument int id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        else{
            return null;
        }
    }
    // Query to find publisher by ID, including author and publisher of the book
    @QueryMapping
    public Publisher findPublisherById(@Argument int id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        if(publisher.isPresent()){
            return publisher.get();
        }
        else{
            return null;
        }
    }

    // Schema to find and connect author of the book
    @SchemaMapping
    public Author author(Book book) {
        Optional<Author> returnVal = authorRepository.findById(book.getAuthorId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // Schema to find and connect publisher of the book
    @SchemaMapping
    public Publisher publisher(Book book) {
        Optional<Publisher> returnVal = publisherRepository.findById(book.getPublisherId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }


}