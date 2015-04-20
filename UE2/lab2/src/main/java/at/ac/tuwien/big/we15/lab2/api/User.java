package at.ac.tuwien.big.we15.lab2.api;

/**
 * Created by rafalwlo on 21.04.2015.
 */
public interface User {
    int getQuestionNr();

    void setQuestionNr(int questionNr);

    int getSaldo();

    void setSaldo(int saldo);

    int getRound();

    void setRound(int round);

    Question getQuestion();

    void setQuestion(Question question);

    String getName();

    void setName(String name);

    String getPassword();

    void setPassword(String password);
}
