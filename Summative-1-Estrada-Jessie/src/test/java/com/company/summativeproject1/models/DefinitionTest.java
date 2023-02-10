package com.company.summativeproject1.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefinitionTest {
    Integer id1;
    Integer newId;

    String word1;
    String newWord;

    String definition1;
    String newDefinition;
    Definition defObject1;

    Integer sameID1;
    Integer sameID2;
    Integer sameID3;

    String sameWord1;
    String sameWord2;
    String sameWord3;

    String sameDefinition1;
    String sameDefinition2;
    String sameDefinition3;

    Definition sameDefObj1;
    Definition sameDefObj2;
    Definition sameDefObj3;

    @Before
    public void setUp() throws Exception {
        id1 = 1;
        newId = 2;

        word1 = "banana";
        newWord = "Tilted";

        definition1 = "A yellow fruit shaped like a phone.";
        newDefinition = "Letting bad surroundings affect you.";
        defObject1 = new Definition(id1, word1, definition1);

        sameID1 = 7;
        sameID2 = 7;
        sameID3 = 7;

        sameWord1 = "Shrek";
        sameWord2 = "Shrek";
        sameWord3 = "Shrek";

        sameDefinition1 = "A green monster who lives in swamp";
        sameDefinition2 = "A green monster who lives in swamp";
        sameDefinition3 = "A green monster who lives in swamp";

        sameDefObj1 = new Definition(sameID1, sameWord1, sameDefinition1);
        sameDefObj2 = new Definition(sameID2, sameWord2, sameDefinition2);
        sameDefObj3 = new Definition(sameID3, sameWord3, sameDefinition3);
    }

    @Test
    public void getId() {
        assertEquals(defObject1.getId(), id1);
    }

    @Test
    public void setId() {
        assertEquals(defObject1.getId(), id1);
        defObject1.setId(newId);
        assertEquals(defObject1.getId(), newId);
    }

    @Test
    public void getWord() {
        assertEquals(defObject1.getWord(), word1);
    }

    @Test
    public void setWord() {
        assertEquals(defObject1.getWord(), word1);
        defObject1.setWord(newWord);
        assertEquals(defObject1.getWord(), newWord);
    }

    @Test
    public void getDefinition() {
        assertEquals(defObject1.getDefinition(), definition1);
    }

    @Test
    public void setDefinition() {
        assertEquals(defObject1.getDefinition(), definition1);
        defObject1.setDefinition(newDefinition);
        assertEquals(defObject1.getDefinition(), newDefinition);
    }

    @Test
    public void testEquals() {
        // Reflexive
        assertTrue(sameDefObj1.equals(sameDefObj1));

        // Symmetric
        assertTrue(sameDefObj1.equals(sameDefObj2));
        assertTrue(sameDefObj2.equals(sameDefObj1));

        // Transitive
        assertTrue(sameDefObj1.equals(sameDefObj2));
        assertTrue(sameDefObj2.equals(sameDefObj3));
        assertTrue(sameDefObj1.equals(sameDefObj3));
    }

    @Test
    public void testHashCode() {
        // Reflexive
        assertEquals(sameDefObj1.hashCode(), sameDefObj1.hashCode());

        // Symmetric
        assertEquals(sameDefObj1.hashCode(), sameDefObj2.hashCode());
        assertEquals(sameDefObj2.hashCode(), sameDefObj1.hashCode());

        // Transitive
        assertEquals(sameDefObj1.hashCode(), sameDefObj2.hashCode());
        assertEquals(sameDefObj2.hashCode(), sameDefObj3.hashCode());
        assertEquals(sameDefObj1.hashCode(), sameDefObj3.hashCode());
    }

    @Test
    public void testToString() {
        // Reflexive
        assertEquals(sameDefObj1.toString(), sameDefObj1.toString());

        // Symmetric
        assertEquals(sameDefObj1.toString(), sameDefObj2.toString());
        assertEquals(sameDefObj2.toString(), sameDefObj1.toString());

        // Transitive
        assertEquals(sameDefObj1.toString(), sameDefObj2.toString());
        assertEquals(sameDefObj2.toString(), sameDefObj3.toString());
        assertEquals(sameDefObj1.toString(), sameDefObj3.toString());
    }
}