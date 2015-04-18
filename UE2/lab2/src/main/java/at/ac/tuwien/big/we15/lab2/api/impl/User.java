package at.ac.tuwien.big.we15.lab2.api.impl;

/**
 * Created by Matze on 18.04.2015.
 */
public class User {
    private String name;
    private String password;
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public User(String username, String password) {
        this.name = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String email) {
        this.password = password;
    }
}
