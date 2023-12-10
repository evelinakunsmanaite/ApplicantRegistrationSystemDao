/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.User;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface UserService {
    boolean create(User user);

    Set<User> read();

    boolean update(int id, String login, String lastName, String firstName, String middleName, String password);

    boolean delete(int id);
    
    User loginUser (String login, String pass);
}
