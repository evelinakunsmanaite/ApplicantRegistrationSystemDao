/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.dao.UniversityDao;
import com.model.University;
import com.service.UniversityService;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class UniversityServiceImpl implements UniversityService{
     UniversityDao dao;

    public UniversityServiceImpl(UniversityDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(University university) {
        return dao.create(university) > 0;
    }

    @Override
    public Set<University> read() {
        return dao.read();
    }

    @Override
    public boolean update(int id, String universityName, double passingScore) {
   University universityUpdated = new University(id, universityName, passingScore);
        return dao.update(universityUpdated) > 0;   
    }

    @Override
    public boolean delete(int id) {
 University university = new University(id);
        return dao.delete(university) > 0;
    }
    
}
