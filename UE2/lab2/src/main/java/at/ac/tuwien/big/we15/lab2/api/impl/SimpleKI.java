package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.*;

import java.util.List;

/**
 * Created by Matze on 19.04.2015.
 */
public class SimpleKI implements at.ac.tuwien.big.we15.lab2.api.KI {
    //ki als user darstellen

    User ki = new SimpleUser("ki", "", 0);

    @Override
    public User start() {
        QuestionAnswerer qa = new SimpleQuestionAnswerer();
        if (qa.check(chooseAnswers(getQuestion(chooseCategory())))) {
            //ki.setMoney(ki.getMoney() + 500);
        } else {
            //ki.setMoney(ki.getMoney() - 500);
        }
        return ki;
    }

    @Override
    public Question getQuestion(Category category) {
        //rnd question aus @param - category
        return null;
    }

    @Override
    public Category chooseCategory() {
        //rnd category
        return null;
    }

    @Override
    public List<Answer> chooseAnswers(Question question) {
        //rnd answers and rnd amount of answers out of n possible answers
        return null;
    }
}
