package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.*;

import java.util.List;

/**
 * Created by Matze on 19.04.2015.
 */
public class SimpleKI implements at.ac.tuwien.big.we15.lab2.api.KI {
    //ki als user darstellen

    private User kiUser;

    public SimpleKI() {
       this.kiUser = new SimpleUser("ki", "");
    }

    @Override
    public User start() {
        QuestionAnswerer qa = new SimpleQuestionAnswerer();
        //if (qa.check(chooseAnswers(getQuestion(chooseCategory())))) {
            kiUser.setSaldo(kiUser.getSaldo() + 50);
            kiUser.setRound(kiUser.getRound() + 1);
        //} else {
            //ki.setSaldo(ki.getSaldo() - 50);
        //}
        return kiUser;
    }
    @Override
    public User getKiUser() {
        return kiUser;
    }

    private Question getQuestion(Category category) {
        //rnd question aus @param - category
        return null;
    }

    private Category chooseCategory() {
        //rnd category
        return null;
    }

    private List<Answer> chooseAnswers(Question question) {
        //rnd answers and rnd amount of answers out of n possible answers
        return null;
    }
}
