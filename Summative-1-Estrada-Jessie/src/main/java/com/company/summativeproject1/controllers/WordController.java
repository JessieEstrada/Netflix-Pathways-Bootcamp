/**-----------------------------------------------------------
 WordController
 -Let the user quest a random word and its definition to expand their vocabulary.

 Team: George Alvarado, Jessie Estrada and Zulymar García
 ------------------------------------------------------------*/
package com.company.summativeproject1.controllers;

import com.company.summativeproject1.models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

/**
 * WordController that will be used to return a random word when
 * a Get request is made.
 */
@RestController
public class WordController {
    private static List<Definition> wordsList;

    /**
     * Instantiates the list of words that the user will get randomly.
     */
    public WordController() {
        Definition adeptDefinition = new Definition(1, "adept",
                "very skilled or expert");

        Definition candorDefinition = new Definition(2, "candor",
                "noun that refers to honesty, being truthful and sincere");

        Definition knackDefinition = new Definition(3, "knack",
                "refers to a special skill an individual possesses " +
                        " that is difficult to teach");

        Definition malapropismDefinition = new Definition(4,
                "malapropism", "an act or habit of " +
                "misusing words ridiculously, especially by the " +
                "confusion of words that are similar in sound.");

        Definition vernacularDefinition = new Definition(5,
                "vernacular", "the native speech " +
                "or language of a place.");

        Definition platitudeDefinition = new Definition(6,
                "platitude", "a saying or phrase " +
                "that has been repeated too many times to be useful");

        Definition vitriolDefinition = new Definition(7,
                "vitriol", "bitter, harsh criticism");

        Definition arcaneDefinition = new Definition(8,
                "arcane", "requiring secret or " +
                "mysterious knowledge");

        Definition cacophonyDefinition = new Definition(9,
                "cacophony", "a harsh mixture of sounds");

        Definition serendipityDefinition = new Definition(10,
                "serendipity", "the act of finding " +
                "something valuable or interesting when you are " +
                "not looking for it");

        wordsList = Arrays.asList(candorDefinition, adeptDefinition,
                knackDefinition, malapropismDefinition,
                vernacularDefinition, platitudeDefinition,
                vitriolDefinition, arcaneDefinition,
                cacophonyDefinition, serendipityDefinition);


    }

    /**
     * Small function that will be used to get the index of
     * the Definition object being returned.
     * @return Returns a randome number between 0 and 10
     */
    private static int generateRandom() {
        int maxNum = wordsList.size();
        double doubleWholeNumber = Math.random() * maxNum;
        int random = (int) doubleWholeNumber % 10;
        System.out.println(random);
        return random;
    }

    /**
     * URI that will get the random word from the list above.
     * @return Returns a Definition object that will be
     *         randomly chosen from the list above.
     */
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getQuote() {
        return wordsList.get(generateRandom());
    }
}
