/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.Abiturient;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface AbiturientService {
    boolean create(Abiturient abiturient);

    Set<Abiturient> read();

    boolean update(int id, String login, String password,String firstName,String middleName, String lastName, String telephone, String address, String noten);

    boolean delete(int id);
    
    Abiturient loginAbiturient(String login, String pass);
    
    double[] gradeArray(Abiturient abiturients);

    double calculateAverageGrade(Abiturient abiturient);
    
    Set<Abiturient> filterAbiturientsWithUnsatisfactoryGrades();
    
    Set<Abiturient> filterAbiturientsByAvg(double avg);

}
