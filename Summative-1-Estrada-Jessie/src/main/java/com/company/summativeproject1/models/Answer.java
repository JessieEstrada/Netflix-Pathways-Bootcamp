package com.company.summativeproject1.models;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Math.abs;

/**
 * Answer class that will be used to return an answer with or
 * without a provided question when a Post request is called.
 * An Answer has an Integer id, String question, and a String
 * answer.
 */
public class Answer {
    /**
     * Modulus Value used to make the ID smaller and more
     * readable.
     */
    private static final Integer MODULUS_VALUE = 100;
    private Integer id;
    private String question;
    private String answer;

    /**
     * answerList contains a list of the possible answers
     * a user can get from the MagicController.
     */
    private static List<String> answerList =
            new ArrayList<>(Arrays.asList(
                    "yes", "no", "maybe",
                    "Ask again later",
                    "Very Doubtful",
                    "I don't think so!",
                    "Don't count on it",
                    "My sources say no",
                    "Outlook is not so good",
                    "Reply not clear, try again!",
                    "Better not tell you now",
                    "Cannot predict now",
                    "Concentrate and ask again",
                    "As I see it, yes!",
                    "Most likely",
                    "Outlook good!",
                    "Signs point to yes",
                    "Certainly!",
                    "it is decidedly so!",
                    "You may rely on it",
                    "Without a doubt!",
                    "I honestly don't know"));

    /**
     * Constructor that doesn't take in anything.
     */
    public Answer() {
        this.id = randomId();
        this.answer = randomAnswer();
        this.question = "";
    }

    /**
     * Gets a randomAnswer from the answerList and gives it
     * back as a String.
     * @return Returns a String of an answer from answerList.
     */
    public String randomAnswer() {
        int randomNumber = randomNumFromListSize();
        String answer = answerList.get(randomNumber);
        return answer;
    }

    /**
     * Gets a random Integer. I got this random Int generator from the
     * link below, but I put it into a function and added a modulus
     * value to make the ID smaller.
     * https://www.digitalocean.com/community/tutorials/random-number-generator-java
     * @return Returns a random Integer, but because of the modulus value,
     *         it will never be smaller than 100 and greater than 9999 I
     *         believe.
     */
    public static int randomId() {
        Random random = new Random();

        int rand = random.nextInt();
        return abs(rand) % MODULUS_VALUE;
    }

    /**
     * Gets a random number from 0 to the size of the answerList
     * that will be used to get an answer.
     * @return Returns an int that will be used to get an index
     *         in the answerList.
     */
    public static int randomNumFromListSize(){
        int maxNum = answerList.size();
        double doubleWholeNumber = Math.random() * maxNum;
        return (int)doubleWholeNumber;
    }

    /**
     * Getter for the id of an Answer.
     * @return Returns an Integer of the Answer's id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for the id of an Answer.
     * @param id Takes in an Integer id that will be set to the id
     *           of the quote Object.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for the question of an Answer.
     * @return Returns a String question of an Answer Object.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Setter for the question of an Answer.
     * @param question Takes in a String question that will be
     *                 set to the question of an Answer Object.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Getter for the answer text of an Answer Object.
     * @return Returns a String of the answer text in an
     *         Answer Object.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Setter for the answer text of an Answer Object.
     * @param answer Takes in a String answer that will be
     *               set to the answer text of the Answer
     *               Object.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * equals() for an Answer object.
     * @param o Object o that the Answer will be compared to.
     * @return Returns true if the Answer object is equal to another
     *         Answer object in all of its instance variables.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return Objects.equals(getId(), answer1.getId()) && Objects.equals(getQuestion(), answer1.getQuestion()) && Objects.equals(getAnswer(), answer1.getAnswer());
    }

    /**
     * hashCode() for an Answer Object. Will be used to test equality.
     * @return Returns an int of this object's hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuestion(), getAnswer());
    }

    /**
     * toString() for an Answer Object. Will be used to test equality.
     * @return Returns an Answer object as a String
     */
    @Override
    public String toString() {
        return "Answer{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
