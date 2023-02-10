package com.company.summativeproject1.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuoteTest {

    Integer id1;
    Integer newId;

    String author1;
    String newAuthor;

    String quote1;
    String newQuote;

    Quote quoteObj;

    Integer sameId1;
    Integer sameId2;
    Integer sameId3;

    String sameAuthor1;
    String sameAuthor2;
    String sameAuthor3;

    String sameQuote1;
    String sameQuote2;
    String sameQuote3;

    Quote sameQuoteObj1;
    Quote sameQuoteObj2;
    Quote sameQuoteObj3;

    @Before
    public void setUp() throws Exception {
        id1 = 1;
        newId = 5;

        author1 = "R.L Stine";
        newAuthor = "Stephen King";

        quote1 = "Many adults feel that every children's book has" +
                "to teach them something.... My theory is a" +
                "children's book... can be just for fun.";
        newQuote = "Monsters are real, and ghosts are real too." +
                "They live inside us, and sometimes, they win.";
        quoteObj = new Quote(id1, author1, quote1);


        sameId1 = 9;
        sameId2 = 9;
        sameId3 = 9;

        sameAuthor1 = "Ezreal";
        sameAuthor2 = "Ezreal";
        sameAuthor3 = "Ezreal";

        sameQuote1 = "Who needs a map?";
        sameQuote2 = "Who needs a map?";
        sameQuote3 = "Who needs a map?";

        sameQuoteObj1 = new Quote(sameId1, sameAuthor1, sameQuote1);
        sameQuoteObj2 = new Quote(sameId2, sameAuthor2, sameQuote2);
        sameQuoteObj3 = new Quote(sameId3, sameAuthor3, sameQuote3);
    }

    @Test
    public void getId() {
        assertEquals(quoteObj.getId(), id1);
    }

    @Test
    public void setId() {
        assertEquals(quoteObj.getId(), id1);
        quoteObj.setId(newId);
        assertEquals(quoteObj.getId(), newId);
    }

    @Test
    public void getAuthor() {
        assertEquals(quoteObj.getAuthor(), author1);
    }

    @Test
    public void setAuthor() {
        assertEquals(quoteObj.getAuthor(), author1);
        quoteObj.setAuthor(newAuthor);
        assertEquals(quoteObj.getAuthor(), newAuthor);
    }

    @Test
    public void getQuote() {
        assertEquals(quoteObj.getQuote(), quote1);
    }

    @Test
    public void setQuote() {
        assertEquals(quoteObj.getQuote(), quote1);
        quoteObj.setQuote(newQuote);
        assertEquals(quoteObj.getQuote(), newQuote);
    }

    @Test
    public void testEquals() {
        // Reflexive
        assertTrue(sameQuoteObj1.equals(sameQuoteObj1));

        // Symmetric
        assertTrue(sameQuoteObj1.equals(sameQuoteObj1));
        assertTrue(sameQuoteObj1.equals(sameQuoteObj1));

        // Transitive
        assertTrue(sameQuoteObj1.equals(sameQuoteObj1));
        assertTrue(sameQuoteObj1.equals(sameQuoteObj1));
        assertTrue(sameQuoteObj1.equals(sameQuoteObj1));
    }

    @Test
    public void testHashCode() {
        // Reflexive
        assertEquals(sameQuoteObj1.hashCode(), sameQuoteObj1.hashCode());

        // Symmetric
        assertEquals(sameQuoteObj1.hashCode(), sameQuoteObj2.hashCode());
        assertEquals(sameQuoteObj2.hashCode(), sameQuoteObj1.hashCode());

        // Transitive
        assertEquals(sameQuoteObj1.hashCode(), sameQuoteObj2.hashCode());
        assertEquals(sameQuoteObj2.hashCode(), sameQuoteObj3.hashCode());
        assertEquals(sameQuoteObj1.hashCode(), sameQuoteObj3.hashCode());
    }

    @Test
    public void testToString() {
        // Reflexive
        assertEquals(sameQuoteObj1.toString(), sameQuoteObj1.toString());

        // Symmetric
        assertEquals(sameQuoteObj1.toString(), sameQuoteObj2.toString());
        assertEquals(sameQuoteObj2.toString(), sameQuoteObj1.toString());

        // Transitive
        assertEquals(sameQuoteObj1.toString(), sameQuoteObj2.toString());
        assertEquals(sameQuoteObj2.toString(), sameQuoteObj3.toString());
        assertEquals(sameQuoteObj1.toString(), sameQuoteObj3.toString());
    }
}