/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.dao.AbiturientDao;
import com.model.Abiturient;
import com.service.AbiturientService;
import java.util.Arrays;
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
    public boolean loginAbiturient(String login, String pass) {
        return dao.read().stream()
                .anyMatch(abiturient -> login.equals(abiturient.getLogin())
                && pass.equals(abiturient.getPassword()));

    }

    @Override
    public int[] gradeArray() {
        Set<Abiturient> abiturients = dao.read();

        return abiturients.stream()
                .flatMap(abiturient -> Arrays.stream(abiturient.getNoten().split(",")))
                .mapToInt(grade -> Integer.parseInt(grade.trim()))
                .toArray();

    }

    @Override
    public double calculateAverageGrade() {
        Set<Abiturient> abiturients = dao.read();

        int[] grades = gradeArray();

        double average = grades.length > 0
                ? Arrays.stream(grades).average().orElse(0)
                : 0;

        return average;
    }

}
