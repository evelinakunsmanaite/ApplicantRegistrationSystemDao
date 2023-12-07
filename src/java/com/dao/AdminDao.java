/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Admin;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface AdminDao {

    int create(Admin admin);

    Set<Admin> read();

    int update(Admin admin);

    int delete(Admin admin);
}
