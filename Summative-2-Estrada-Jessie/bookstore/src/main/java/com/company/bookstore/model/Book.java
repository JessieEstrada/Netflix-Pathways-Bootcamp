/**-------------------------------------------------------
 Book class
 -Used to get the books in the system. A Book has an
 id, isbn, publish date, its author id, title, its publisher
 id, and price.

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */
package com.company.bookstore.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="book")
public class Book implements Serializable {

    // Automatically generated ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;

    private String isbn;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "author_id")
    private int authorId;

    private String title;

    @Column(name = "publisher_id")
    private int publisherId;

    private BigDecimal price;



    // Getter method that returns Book ID
    public int getId() {
        return id;
    }

    // Setter method that sets Book ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter method that returns ISBN
    public String getIsbn() {
        return isbn;
    }

    // Setter method that sets ISBN
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Getter method that returns ISBN
    public LocalDate getPublishDate() {
        return publishDate;
    }

    // Setter method that sets ISBN
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    // Getter method that returns Author ID
    public int getAuthorId() {
        return authorId;
    }

    // Setter method that sets Author ID
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    // Getter method that returns Title
    public String getTitle() {
        return title;
    }

    // Setter method that sets Title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method that returns Publisher ID
    public int getPublisherId() {
        return publisherId;
    }

    // setter method that sets Publisher ID
    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    // Getter method that returns Book Price
    public BigDecimal getPrice() {
        return price;
    }

    // Setter method that sets Book Price
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && authorId == book.authorId && publisherId == book.publisherId && Objects.equals(isbn, book.isbn) && Objects.equals(publishDate, book.publishDate) && Objects.equals(title, book.title) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, publishDate, authorId, title, publisherId, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + id +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", publisherId=" + publisherId +
                ", price=" + price +
                '}';
    }
}
