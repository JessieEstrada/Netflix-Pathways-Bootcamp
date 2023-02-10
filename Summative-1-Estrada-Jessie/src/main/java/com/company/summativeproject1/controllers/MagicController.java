/**-----------------------------------------------------------
 MagicController
 -To request a random answer to a question so the user can be entertained.

 Team: George Alvarado, Jessie Estrada and Zulymar García
 ------------------------------------------------------------*/
package com.company.summativeproject1.controllers;

import com.company.summativeproject1.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MagicController that will be used to give a user an answer with or without
 * a question given with a Post request.
 */
@RestController
public class MagicController {

    /**
     * URI that will Post a question and return an answer to the user.
     * @param question question that the user is inputing. (This
     *                 can be left blank as well).
     * @return Returns an answer, regardless if a question was given.
     */
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer createAnswer(@RequestBody Answer question) {
        Answer tempAnswer = new Answer();
        if (question != null){
            tempAnswer.setQuestion(question.getQuestion());
        }


        return tempAnswer;
    }
}
