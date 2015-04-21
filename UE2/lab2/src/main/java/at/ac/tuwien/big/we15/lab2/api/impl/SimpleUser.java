package at.ac.tuwien.big.we15.lab2.api.impl;

import at.ac.tuwien.big.we15.lab2.api.Question;
import at.ac.tuwien.big.we15.lab2.api.User;

/**
 * Created by Matze on 18.04.2015.
 */
public class SimpleUser implements User {
    private String name;
    private String password;
    private int saldo;
    private int round;
    private int questionNr;
    private Question question;

    public SimpleUser() {
        this.round = 0;
        this.saldo = 0;
    }

    public SimpleUser(String username, String password) {
        this.name = username;
        this.password = password;
        this.saldo = 0;
        this.round = 0;
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
