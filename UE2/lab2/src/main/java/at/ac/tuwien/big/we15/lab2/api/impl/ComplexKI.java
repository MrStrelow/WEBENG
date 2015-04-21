package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.*;

import java.util.List;

/**
 * Created by Matze on 19.04.2015.
 */
public class ComplexKI implements KI {
    //ki als user darstellen

    User ki = new SimpleUser("ki", "");

    @Override
    public User start() {
        QuestionAnswerer qa = new SimpleQuestionAnswerer();
        //if(qa.check(chooseAnswers(getQuestion(chooseCategory())))){
        ki.setSaldo(ki.getSaldo() + 20);
        /*}
        else{
            ki.setSaldo(ki.getSaldo() - 20);
        }*/
        ki.setRound(ki.getRound() + 1);
        return ki;
    }

    @Override
    public User getKiUser() {
        return null;
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
