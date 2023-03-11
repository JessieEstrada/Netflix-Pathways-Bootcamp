/**-------------------------------------------------------
 Author class
 -Used to get the authors in the system. An Author has an
 id, first name, last name, street, city, state, postal
 code, phone and email

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
@Table(name="author")
public class Author implements Serializable {

    // Automatically generated ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String street;
    private String city;
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    private String phone;
    private String email;

    //Foreign Key, One to Many Relationship
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Set<Book> books = new HashSet<>();

    // Getter method which returns Author ID
    public int getId() {
        return id;
    }

    // Setter method which sets ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter method which returns First Name
    public String getFirstName() {
        return firstName;
    }

    // Setter method which sets First Name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter method which returns Last Name
    public String getLastName() {
        return lastName;
    }

    // Setter method which sets Last Name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter method which returns Street
    public String getStreet() {
        return street;
    }

    // Setter method which sets Street
    public void setStreet(String street) {
        this.street = street;
    }

    // Getter method which returns City
    public String getCity() {
        return city;
    }

    // Setter method which sets City
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

    // Getter method that Returns Book Set
    public Set<Book> getBooks() {
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
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) && Objects.equals(street, author.street) &&
                Objects.equals(city, author.city) && Objects.equals(state, author.state) &&
                Objects.equals(postalCode, author.postalCode) && Objects.equals(phone, author.phone) &&
                Objects.equals(email, author.email) && Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, street, city, state, postalCode, phone, email, books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", books=" + books +
                '}';
    }
}
