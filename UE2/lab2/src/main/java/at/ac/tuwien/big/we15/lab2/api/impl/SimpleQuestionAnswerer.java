package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.Answer;
import at.ac.tuwien.big.we15.lab2.api.Question;
import at.ac.tuwien.big.we15.lab2.api.QuestionAnswerer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matze on 18.04.2015.
 */
public class SimpleQuestionAnswerer implements QuestionAnswerer {

    private Question question;

    public SimpleQuestionAnswerer(Question question) {
        this.question = question;
    }

    @Override
    public boolean check(List<Answer> answers) {
        List<Answer> correctAnswers = question.getRightAnswers();
        for (Answer ca : correctAnswers) {
            if (!answers.contains(ca)) {
                return false;
            }
        }
        for (Answer a : answers) {
            if (!correctAnswers.contains(a)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean check(String[] answers) {
        List<Answer> answersList = new ArrayList<>();
        for (String text : answers) {
            answersList.add(new SimpleAnswer(text));
        }
        return check(answersList);
    }
}