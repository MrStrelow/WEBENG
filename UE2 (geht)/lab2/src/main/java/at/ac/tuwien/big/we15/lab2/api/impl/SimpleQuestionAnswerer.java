package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.Answer;

import java.util.List;

/**
 * Created by Matze on 18.04.2015.
 */
public class SimpleQuestionAnswerer implements at.ac.tuwien.big.we15.lab2.api.QuestionAnswerer {

    @Override
    public boolean check(List<Answer> answers) {
        return true;
    }

    @Override
    public boolean check(String[] answers) {
        return true;
    }
}
