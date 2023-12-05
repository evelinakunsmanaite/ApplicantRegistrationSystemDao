/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.University;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface UniversityService {
    boolean create(University university);

    Set<University> read();

    boolean update(int id, String universityName, double passingScore);

    boolean delete(int id);
}
