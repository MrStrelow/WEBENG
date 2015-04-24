package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Matze on 19.04.2015.
 */
public class SimpleKI implements KI {
    //ki als user darstellen

    private User kiUser;
    private Category category;

    public SimpleKI() {
        this.kiUser = new SimpleUser("ki", "");
    }

    @Override
    public User start() {
        QuestionAnswerer qa = new SimpleQuestionAnswerer(kiUser.getQuestion());
        //if (qa.check(chooseAnswers(getQuestion(chooseCategory())))) {
        kiUser.setSaldo(kiUser.getSaldo() + 50);
        kiUser.setRound(kiUser.getRound() + 1);
        //} else {
        //ki.setSaldo(ki.getSaldo() - 50);
        //}
        return kiUser;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public User getKiUser() {
        return kiUser;
    }

    @Override
    public Question getQuestion(Category category) {
        //rnd question aus @param - category
        List<Question> questions = category.getQuestions();
        Random rand = new Random();
        int i = rand.nextInt(questions.size());
        Question question = questions.get(i);
        return question;
    }

    @Override
    public Category chooseCategory() {
        //rnd category
        return null;
    }

    @Override
    public List<Answer> chooseAnswers(Question question) {
        //rnd answers and rnd amount of answers out of n possible answers
        List<Answer> correctAnswers = question.getRightAnswers();
        List<Answer> wrongAnswers = question.getWrongAnswers();
        List<Answer> chosenAnswers = new ArrayList<>(correctAnswers);
        Random rand = new Random();
        boolean unlucky = rand.nextBoolean();
        if (unlucky) {
            chosenAnswers.remove(chosenAnswers.size() - 1);
            if (wrongAnswers.size() > 0) {
                chosenAnswers.add(wrongAnswers.get(wrongAnswers.size() - 1));
            }
        }
        return chosenAnswers;
    }
}
