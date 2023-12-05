/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Abiturient;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface AbiturientDao {
     int create(Abiturient abiturient);
    Set<Abiturient> read();
    int update(Abiturient abiturient);
    int delete(Abiturient abiturient);
}
