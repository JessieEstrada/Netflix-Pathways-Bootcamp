package com.company.summativeproject1.models;

import java.util.Objects;

/**
 * Quote class that will be used to return a random quote when a
 * Get request is called. A Quote has an Integer id, String author, and
 * a String quote.
 */
public class Quote {
    private Integer id;
    private String author;
    private String quote;

    /**
     * Constructor for a Quote Object.
     * @param id id of the Quote
     * @param author author of the Quote
     * @param quote quote text of the Quote
     */
    public Quote(Integer id, String author, String quote) {
        this.id = id;
        this.author = author;
        this.quote = quote;
    }

    public Quote() {
    }

    /**
     * Getter for the id of a Quote.
     * @return Returns an Integer of the Quote's id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for the id of a Quote
     * @param id Takes in an Integer id that will be set to the id
     *           of the Quote Object.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for the author of a Quote.
     * @return Returns a String which is the author of the Quote.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter for the author of a Quote.
     * @param author Takes in a String author that will be set to
     *               the author of the Quote Object.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter for the quote text of a Quote Object.
     * @return Returns a String of the Quote's text.
     */
    public String getQuote() {
        return quote;
    }

    /**
     * Setter for the quote text of a Quote Object.
     * @param quote Takes in a String quote that will be set to
     *              the quote text of the Quote Object.
     */
    public void setQuote(String quote) {
        this.quote = quote;
    }

    /**
     * equals() for a Quote object.
     * @param o Object o that the Quote will be compared to.
     * @return Returns true if the Quote object is equal to another
     *         Quote object in all of its instance variables.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return Objects.equals(getId(), quote1.getId()) && Objects.equals(getAuthor(), quote1.getAuthor()) && Objects.equals(getQuote(), quote1.getQuote());
    }

    /**
     * hashCode() for a Quote Object. Will be used to test equality.
     * @return Returns an int of this object's hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getQuote());
    }

    /**
     * toString() for a Quote Object. Will be used to test equality.
     * @return Returns a Quote object as a String
     */
    @Override
    public String toString() {
        return "Quote{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}
