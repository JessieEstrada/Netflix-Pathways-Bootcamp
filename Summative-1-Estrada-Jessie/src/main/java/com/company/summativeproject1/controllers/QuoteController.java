/**-----------------------------------------------------------
 QuoteController
 -Let the user request a random quote so they can expand their knowledge

 Team: George Alvarado, Jessie Estrada and Zulymar García
 ------------------------------------------------------------*/
package com.company.summativeproject1.controllers;

import com.company.summativeproject1.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


/**
 * Quote controller that will be used to return a random
 * quote when a Get request is made.
 */
@RestController
public class QuoteController {
    private static List<Quote> quoteList;

    /**
     * Instantiates the list of quotes that the user will
     * get randomly.
     */
    public QuoteController() {
        // I got these quotes from this blog:
        // https://blog.hubspot.com/sales/famous-quotes
        Quote bruceLeeQuote = new Quote(1,
                "Bruce Lee",
                "Willing is not enough, we must do.");

        Quote kobeBryantQuote = new Quote(2,
                "Kobe Bryant",
                "Once you know what failure feels like, " +
                        "determination chases success.");

        Quote nelsonMandelaQuote = new Quote(3,
                "Nelson Mandela",
                "The greatest glory in living " +
                        "lies not in never falling, " +
                        "but in rising every time we fall.");

        Quote jamesCameronQuote = new Quote(4,
                "James Cameron",
                "If you set your goals ridiculously " +
                        "high and it's a failure, you will " +
                        "fail above everyone else's success.");

        Quote benjaminFranklinQuote = new Quote(5,
                "Benjamin Franklin",
                "Tell me and I forget. Teach me " +
                        "and I remember. Involve me and " +
                        "I learn.");

        Quote mayaAngelouQuote = new Quote(6,
                "Maya Angelou",
                "You will face many defeats in " +
                        "life, but never let yourself " +
                        "be defeated.");

        Quote babeRuthQuote = new Quote(7,
                "Babe Ruth",
                "Never let the fear of " +
                        "striking out keep you " +
                        "from playing the game.");

        Quote bobMarleyQuote = new Quote(8,
                "Bob Marley",
                "Love the life you live. " +
                        "Live the life you love.");

        Quote winstonChurchillQuote = new Quote(9,
                "Winston S. Churchill",
                "Success is not final; failure " +
                        "is not fatal: It is the courage " +
                        "to continue that counts.");

        Quote barackObamaQuote = new Quote(10,
                "Barack Obama",
                "The real test is not whether " +
                        "you avoid this failure, because " +
                        "you won't. It's whether you " +
                        "let it harden or shame you " +
                        "into inaction, or whether you " +
                        "learn from it; whether you choose " +
                        "to persevere.");


        quoteList = Arrays.asList(bruceLeeQuote, kobeBryantQuote,
                nelsonMandelaQuote, jamesCameronQuote,
                benjaminFranklinQuote, mayaAngelouQuote,
                babeRuthQuote, bobMarleyQuote,
                winstonChurchillQuote, barackObamaQuote);
    }

    /**
     * Gets a random number from 0 through 10.
     * @return Returns an int, randomly from 0 through 10.
     */
    public static int randomNum(){
        int maxNum = quoteList.size();
        double doubleWholeNumber = Math.random() * maxNum;
        return (int)doubleWholeNumber;
    }

    /**
     * URI that will get the random quote from the list above.
     * @return Returns a Quote object that will be
     *         randomly chosen from the list above.
     */
    @RequestMapping(value ="/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {
        return quoteList.get(randomNum());
    }
}
