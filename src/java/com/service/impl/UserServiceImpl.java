/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class UserServiceImpl implements UserService {

    UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(User user) {
        return dao.create(user) > 0;
    }

    @Override
    public Set<User> read() {
        return dao.read();
    }

    @Override
    public boolean update(int id, String login, String lastName, String firstName, String middleName, String password) {
        User updatedUser = new User(id, login, lastName, firstName, middleName, password);
        return dao.update(updatedUser) > 0;
    }

    @Override
    public boolean delete(int id) {
        User user = new User(id);
        return dao.delete(user) > 0;
    }

    @Override
    public boolean loginUser(String login, String pass) {
        return dao.read().stream()
                .anyMatch(user -> login.equals(user.getLogin())
                && pass.equals(user.getPassword()));
    }

}
