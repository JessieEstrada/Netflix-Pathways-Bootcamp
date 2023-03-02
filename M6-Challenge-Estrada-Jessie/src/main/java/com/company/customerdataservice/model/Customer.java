package com.company.customerdataservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// This is the Customer model
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="customer")
public class Customer implements Serializable {

    // ID is automatically generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;

    private String email;
    private String company;
    private String phone;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    // Getter method which returns ID
    public Integer getId() {
        return id;
    }

    // Setter method which sets ID
    public void setId(Integer id) {
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

    // Getter method which returns email
    public String getEmail() {
        return email;
    }

    // Setter method which sets email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter method which returns company
    public String getCompany() {
        return company;
    }

    // Setter method which sets company
    public void setCompany(String company) {
        this.company = company;
    }

    // Getter method which returns Phone
    public String getPhone() {
        return phone;
    }

    // Setter method which sets Phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter method which returns Address 1
    public String getAddress1() {
        return address1;
    }

    // Setter method which sets Address 1
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    // Getter method which returns Address 2
    public String getAddress2() {
        return address2;
    }

    // Setter method which sets Address 2
    public void setAddress2(String address2) {
        this.address2 = address2;
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

    // Getter method that returns Country
    public String getCountry() {
        return country;
    }

    // Setter method that sets Country
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(company, customer.company) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(address1, customer.address1) &&
                Objects.equals(address2, customer.address2) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(state, customer.state) &&
                Objects.equals(postalCode, customer.postalCode) &&
                Objects.equals(country, customer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getFirstName(),
                getLastName(),
                getEmail(),
                getCompany(),
                getPhone(),
                getAddress1(),
                getAddress2(),
                getCity(),
                getState(),
                getPostalCode(),
                getCountry());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", county='" + country + '\'' +
                '}';
    }
}
