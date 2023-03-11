/**-------------------------------------------------------
 Book Repository
 -Used to implements JPA functionality and the connection
 with the book_store database

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */
package com.company.bookstore.repository;

import com.company.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // JPA query for finding a book list by author ID
    List<Book> findByAuthorId(Integer id);
}
