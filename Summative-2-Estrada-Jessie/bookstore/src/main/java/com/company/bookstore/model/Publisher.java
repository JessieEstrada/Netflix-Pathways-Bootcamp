/**-------------------------------------------------------
 Publisher class
 -Used to get the publisher in the system. An publisher has an
 name, street, city, state, postal code, phone and email

 Authors: Jessie Estrada and Zulymar García

 -------------------------------------------------------- */
package com.company.bookstore.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="publisher")
public class Publisher implements Serializable {

    // Automatically generated ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="publisher_id")
    private int id;
    private String name;

    private String street;
    private String city;
    private String state;

    @Column(name="postal_code")
    private String postalCode;

    private String phone;
    private String email;


    //Foreign Key, One to Many Relationship
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    // Getter method that returns Publisher ID
    public int getId() {
        return id;
    }

    // Setter method that sets Publisher ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter method that returns Name
    public String getName() {
        return name;
    }

    // Setter method that sets Name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method that returns Street
    public String getStreet() {
        return street;
    }

    // Setter method that sets Street
    public void setStreet(String street) {
        this.street = street;
    }

    // Getter method that returns City
    public String getCity() {
        return city;
    }

    // Setter method that sets City
    public void setCity(String city) {
        this.city = city;
    }

    // Getter method that returns State
    public String getState() {
        return state;
    }

    // Setter method that sets State
    public void setState(String state) {
        this.state = state;
    }

    // Getter method that returns Postal Code
    public String getPostalCode() {
        return postalCode;
    }

    // Setter method that sets Postal Code
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Getter method that returns Phone
    public String getPhone() {
        return phone;
    }

    // Setter method that sets Phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter method that returns Email
    public String getEmail() {
        return email;
    }

    // Setter method that sets Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter method that returns Book Set
    public Set<Book> getBook() {
        return books;
    }

    // Setter method that sets Book Set
    public void setBook(Set<Book> books) {
        this.books = books;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id) && Objects.equals(name, publisher.name) && Objects.equals(street, publisher.street) && Objects.equals(city, publisher.city) && Objects.equals(state, publisher.state) && Objects.equals(postalCode, publisher.postalCode) && Objects.equals(phone, publisher.phone) && Objects.equals(email, publisher.email) && Objects.equals(books, publisher.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, postalCode, phone, email, books);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", book=" + books +
                '}';
    }
}
