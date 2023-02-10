package com.company.summativeproject1.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnswerTest {

    Integer sameId;
    String sameAnswer;
    String sameQuestion;
    Integer expectedID;
    String expectedQuestion;
    String expectedAnswer;

    Answer sameAnswer1;
    Answer sameAnswer2;
    Answer sameAnswer3;



    @Before
    public void setUp() throws Exception {

        // Since the generation of id and answer is random, I set
        // the next 3 to the same variables to test for equality.
        sameId = 2319;
        sameAnswer = "Should be same answer for these 3";
        sameQuestion = "Question for all 3";
        expectedID = 56;
        expectedQuestion = "New Expected Question";
        expectedAnswer = "This is your new Expected Answer";

        sameAnswer1 = new Answer();
        sameAnswer1.setId(sameId);
        sameAnswer1.setAnswer(sameAnswer);
        sameAnswer1.setQuestion(sameQuestion);

        sameAnswer2 = new Answer();
        sameAnswer2.setId(sameId);
        sameAnswer2.setAnswer(sameAnswer);
        sameAnswer2.setQuestion(sameQuestion);

        sameAnswer3 = new Answer();
        sameAnswer3.setId(sameId);
        sameAnswer3.setAnswer(sameAnswer);
        sameAnswer3.setQuestion(sameQuestion);

    }

    @Test
    public void getId() {
        assertEquals(sameAnswer1.getId(), sameId);

    }

    @Test
    public void setId() {
        assertEquals(sameAnswer1.getId(), sameId);
        sameAnswer1.setId(expectedID);
        assertEquals(sameAnswer1.getId(), expectedID);
    }

    @Test
    public void getQuestion() {
        assertEquals(sameAnswer1.getQuestion(), sameQuestion);

    }

    @Test
    public void setQuestion() {
        assertEquals(sameAnswer1.getQuestion(), sameQuestion);
        sameAnswer1.setQuestion(expectedQuestion);
        assertEquals(sameAnswer1.getQuestion(), expectedQuestion);
    }

    @Test
    public void getAnswer() {
        assertEquals(sameAnswer1.getAnswer(), sameAnswer);
    }

    @Test
    public void setAnswer() {
        assertEquals(sameAnswer1.getAnswer(), sameAnswer);
        sameAnswer1.setAnswer(expectedAnswer);
        assertEquals(sameAnswer1.getAnswer(), expectedAnswer);
    }

    @Test
    public void testEquals() {
        // Reflexive
        assertTrue(sameAnswer1.equals(sameAnswer1));

        // Symmetric
        assertTrue(sameAnswer1.equals(sameAnswer2));
        assertTrue(sameAnswer2.equals(sameAnswer1));

        // Transitive
        assertTrue(sameAnswer1.equals(sameAnswer2));
        assertTrue(sameAnswer2.equals(sameAnswer3));
        assertTrue(sameAnswer1.equals(sameAnswer3));
    }

    @Test
    public void testHashCode() {
        // Reflexive
        assertEquals(sameAnswer1.hashCode(), sameAnswer1.hashCode());

        // Symmetric
        assertEquals(sameAnswer1.hashCode(), sameAnswer2.hashCode());
        assertEquals(sameAnswer2.hashCode(), sameAnswer1.hashCode());

        // Transitive
        assertEquals(sameAnswer1.hashCode(), sameAnswer2.hashCode());
        assertEquals(sameAnswer2.hashCode(), sameAnswer3.hashCode());
        assertEquals(sameAnswer1.hashCode(), sameAnswer3.hashCode());
    }

    @Test
    public void testToString() {
        // Reflexive
        assertEquals(sameAnswer1.toString(), sameAnswer1.toString());

        // Symmetric
        assertEquals(sameAnswer1.toString(), sameAnswer2.toString());
        assertEquals(sameAnswer2.toString(), sameAnswer1.toString());

        // Transitive
        assertEquals(sameAnswer1.toString(), sameAnswer2.toString());
        assertEquals(sameAnswer2.toString(), sameAnswer3.toString());
        assertEquals(sameAnswer1.toString(), sameAnswer3.toString());
    }
}