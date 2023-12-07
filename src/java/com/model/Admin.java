package com.model;

/**
 *
 * @author Administrator
 */
public class Admin {

    private int id;
    private String password, login;

    public Admin(int id, String login, String password) {
        this.id = id;
        this.password = password;
        this.login = login;
    }

    public Admin(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
