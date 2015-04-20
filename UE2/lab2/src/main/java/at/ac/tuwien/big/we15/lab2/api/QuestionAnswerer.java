package at.ac.tuwien.big.we15.lab2.api;

import java.util.List;

/**
 * Created by rafalwlo on 21.04.2015.
 */
public interface QuestionAnswerer {
    boolean check(List<Answer> answers);

    boolean check(String[] answers);
}
