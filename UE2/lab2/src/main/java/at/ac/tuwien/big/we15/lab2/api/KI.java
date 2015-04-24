package at.ac.tuwien.big.we15.lab2.api;

import java.util.List;

/**
 * Created by rafalwlo on 21.04.2015.
 */
public interface KI {
    User start();

    void setCategory(Category category);

    User getKiUser();

    Question getQuestion(Category category);

    Category chooseCategory();

    List<Answer> chooseAnswers(Question question);
}
