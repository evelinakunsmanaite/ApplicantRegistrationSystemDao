package com.controller;

import com.dao.AbiturientDao;
import com.dao.AdminDao;
import com.dao.UniversityDao;
import com.dao.UserDao;
import com.dao.impl.AbiturientDaoImpl;
import com.dao.impl.AdminDaoImpl;
import com.dao.impl.UniversityDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.service.AbiturientService;
import com.service.AdminService;
import com.service.UniversityService;
import com.service.UserService;
import com.service.impl.AbiturientServiceImpl;
import com.service.impl.AdminServiceImpl;
import com.service.impl.UniversityServiceImpl;
import com.service.impl.UserServiceImpl;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;

public abstract class InitServlet extends HttpServlet {

    private @Resource(name = "jdbc/applicantregsys")//испальзование листнера
    DataSource dataSource;
    
    protected UserDao userDao;
    protected AdminDao adminDao;
    protected AbiturientDao abiturientDao;
    protected UniversityDao universityDao;
    
    protected UserService userService;
    protected AdminService adminService;
    protected AbiturientService abiturientService;
    protected UniversityService universityService;

    @Override
    public void init() {//инициализация объектов с которыми работает сервлеты
        userDao = new UserDaoImpl(dataSource);
        userService = new UserServiceImpl(userDao);
        
        abiturientDao = new AbiturientDaoImpl(dataSource);
        abiturientService = new AbiturientServiceImpl(abiturientDao);
       
        universityDao = new UniversityDaoImpl(dataSource);
        universityService = new UniversityServiceImpl(universityDao);
        
        adminDao = new AdminDaoImpl(dataSource);
        adminService = new AdminServiceImpl(adminDao);
    }
}
