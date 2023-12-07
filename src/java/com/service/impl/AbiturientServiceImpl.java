/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.dao.AbiturientDao;
import com.model.Abiturient;
import com.service.AbiturientService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class AbiturientServiceImpl implements AbiturientService {

    AbiturientDao dao;

    public AbiturientServiceImpl(AbiturientDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(Abiturient abiturient) {
        return dao.create(abiturient) > 0;
    }

    @Override
    public Set<Abiturient> read() {
        return dao.read();
    }

    @Override
    public boolean update(int id, String login, String password, String firstName, String middleName, String lastName, String telephone, String address, String noten) {
        Abiturient abiturient = new Abiturient(id, login, password, firstName, middleName, lastName, telephone, address, noten);
        return dao.update(abiturient) > 0;
    }

    @Override
    public boolean delete(int id) {
        Abiturient abiturient = new Abiturient(id);
        return dao.delete(abiturient) > 0;
    }

    @Override
    public Abiturient loginAbiturient(String login, String pass) {
        return dao.read().stream()
                .filter(abiturient -> login.equals(abiturient.getLogin())
                && pass.equals(abiturient.getPassword()))
                .findFirst().orElse(null);
    }

    @Override
    public double[] gradeArray(Abiturient abiturient) {
        return Arrays.stream(abiturient.getNoten().split(","))
                .mapToDouble(Double::parseDouble).toArray();
    }

    @Override
    public double calculateAverageGrade(Abiturient abiturient) {
        double[] grades = gradeArray(abiturient);

        return grades.length > 0
                ? Arrays.stream(grades).average().orElse(0)
                : 0;
    }

    @Override
    public Set<Abiturient> filterAbiturientsWithUnsatisfactoryGrades() {
        Set<Abiturient> abiturients = dao.read();
        Set<Abiturient> abiturientsNeud = new HashSet<>();
        for (Abiturient abiturient : abiturients) {
            for (double note : gradeArray(abiturient)) {
                if (note < 4) {
                    abiturientsNeud.add(abiturient);
                }
            }
        }
        return abiturientsNeud;
    }
    
 @Override
    public Set<Abiturient> filterAbiturientsByAvg(double avg) {
        Set<Abiturient> abiturients = dao.read();
        Set<Abiturient> abiturientsNeud = new HashSet<>();
        for (Abiturient abiturient : abiturients) {
            if (calculateAverageGrade(abiturient) > avg) {
                abiturientsNeud.add(abiturient);
            }
        }
        return abiturientsNeud;
    }

}
