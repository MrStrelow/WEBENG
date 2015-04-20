package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.Answer;
import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.Question;

import java.util.List;

/**
 * Created by Matze on 19.04.2015.
 */
public class KI {
    //ki als user darstellen

    User ki = new User("ki","",0);

    public User start() {
        QuestionAnswerer qa = new QuestionAnswerer();
        //if(qa.check(chooseAnswers(getQuestion(chooseCategory())))){
            ki.setSaldo(ki.getSaldo() + 20);
        /*}
        else{
            ki.setSaldo(ki.getSaldo() - 20);
        }*/
        ki.setRound(ki.getRound()+1);
        return ki;
    }

    public Question getQuestion(Category category){
        //rnd question aus @param - category
        return null;
    }

    public Category chooseCategory(){
        //rnd category
        return null;
    }

    public List<Answer> chooseAnswers(Question question){
        //rnd answers and rnd amount of answers out of n possible answers
        return null;
    }
}
