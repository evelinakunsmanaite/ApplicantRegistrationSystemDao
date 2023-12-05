/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.University;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface UniversityDao {
    int create(University university);
    Set<University> read();
    int update(University university);
    int delete(University university);
}
