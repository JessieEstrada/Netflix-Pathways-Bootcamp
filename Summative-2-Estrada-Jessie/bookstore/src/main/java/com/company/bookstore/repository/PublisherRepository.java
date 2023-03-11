/**-------------------------------------------------------
 Publisher Repository
 -Used to implements JPA functionality and the connection
 with the book_store database

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */
package com.company.bookstore.repository;

import com.company.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
