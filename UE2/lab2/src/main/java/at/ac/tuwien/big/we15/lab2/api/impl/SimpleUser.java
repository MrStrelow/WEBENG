package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.Question;

/**
 * Created by Matze on 18.04.2015.
 */
public class SimpleUser implements at.ac.tuwien.big.we15.lab2.api.User {
    private String name;
    private String password;
    private int saldo;
    private int round;
    private int questionNr;
    private Question question;

<<<<<<< HEAD:UE2/lab2/src/main/java/at/ac/tuwien/big/we15/lab2/api/impl/SimpleUser.java
    public SimpleUser() {
        this.round = 1;
        this.saldo = 0;
    }

    public SimpleUser(String username, String password, int saldo) {
        this.name = username;
        this.password = password;
        this.saldo = saldo;
=======
    public User() {
        this.round = 0;
        this.saldo = 0;
    }

    public User(String username, String password, int saldo) {
        this.round = 0;
        this.name = username;
        this.password = password;
        this.saldo = saldo;
    }

    public void setQuestionNr(int questionNr) {
        this.questionNr = questionNr;
>>>>>>> parent of edc21ef... Revert "Servlets "fertig".":UE2/lab2/src/main/java/at/ac/tuwien/big/we15/lab2/api/impl/User.java
    }

    @Override
    public int getQuestionNr() {
        return questionNr;

    }

    @Override
    public void setQuestionNr(int questionNr) {
        this.questionNr = questionNr;
    }

    @Override
    public int getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public int getRound() {
        return round;
    }

    @Override
    public void setRound(int round) {
        this.round = round;
    }

    @Override
    public Question getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(Question question) {
        this.question = question;
    }

<<<<<<< HEAD:UE2/lab2/src/main/java/at/ac/tuwien/big/we15/lab2/api/impl/SimpleUser.java
    @Override
=======
    private Question question;

>>>>>>> parent of edc21ef... Revert "Servlets "fertig".":UE2/lab2/src/main/java/at/ac/tuwien/big/we15/lab2/api/impl/User.java
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
