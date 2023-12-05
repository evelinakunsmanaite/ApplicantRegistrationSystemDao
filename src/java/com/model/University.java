/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author Administrator
 */
public class University {

    private int id;
    private String universityName;
    private double passingScore;

    public University(String universityName, double passingScore) {
        this.universityName = universityName;
        this.passingScore = passingScore;
    }
    
     public University(int id, String universityName, double passingScore) {
        this.id = id;
        this.universityName = universityName;
        this.passingScore = passingScore;
    }
     
          public University(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public double getPassingScore() {
        return passingScore;
    }

    public void setPassingScorePaid(double passingScorePaid) {
        this.passingScore = passingScore;
    }

    @Override
    public String toString() {
        return "University{" + "universityName=" + universityName + ", passingScore=" + passingScore + '}';
    }

}
