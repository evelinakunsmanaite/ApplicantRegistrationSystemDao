/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.Abiturient;
import com.model.Admin;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface AdminService {
     boolean create(Admin admin);

    Set<Admin> read();

    boolean update(int id, String universityName, String pass);

    boolean delete(int id);
    
    boolean loginAdmin(String login, String pass);

}
