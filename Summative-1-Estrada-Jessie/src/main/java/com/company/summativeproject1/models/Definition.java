package com.company.summativeproject1.models;

import java.util.Objects;

/**
 * Definition class that will be used to return a random definition of
 * a word when a Get request is called. A definition has an Integer id,
 * String word, and a String definition.
 */
public class Definition {
    private Integer id;
    private String word;
    private String definition;

    /**
     * Constructor for a Definition Object.
     * @param id id of a Definition Object.
     * @param word word of a Definition object.
     * @param definition definition text of a Definition Object.
     */
    public Definition(Integer id, String word, String definition) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    public Definition() {
    }

    /**
     * Getter for the id of a Definition Object.
     * @return Returns an Integer id of a Definition Object.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for the id of a Definition Object.
     * @param id Takes in an Integer id that will be
     *           set to the id of a Definition Object.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for the word of a Definition Object.
     * @return Returns a String word of a Definition Object.
     */
    public String getWord() {
        return word;
    }

    /**
     * Setter for the word of a Definition Object.
     * @param word Takes in a String word that will be set
     *             to the word of a Definition Object.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Getter for the text definition of a Definition Object.
     * @return Returns the String definition text of a
     *         Definition Object.
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Setter for the text defintion of a Definition Object.
     * @param definition Takes in a String definition that
     *                   will be set to the text definition
     *                   of a Definition Object.
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    /**
     * equals() for a Definition object.
     * @param o Object o that the Definition will be compared to.
     * @return Returns true if the Definition object is equal to another
     *         Definition object in all of its instance variables.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getWord(), that.getWord()) && Objects.equals(getDefinition(), that.getDefinition());
    }

    /**
     * hashCode() for a Definition Object. Will be used to test equality.
     * @return Returns an int of this object's hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWord(), getDefinition());
    }

    /**
     * toString() for a Definition Object. Will be used to test equality.
     * @return Returns a Definition object as a String
     */
    @Override
    public String toString() {
        return "Definition{" +
                "id='" + id + '\'' +
                ", word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
