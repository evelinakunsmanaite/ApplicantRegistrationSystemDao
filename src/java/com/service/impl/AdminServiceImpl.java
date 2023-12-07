package com.service.impl;

import com.dao.AdminDao;
import com.model.Admin;
import com.service.AdminService;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class AdminServiceImpl implements AdminService {

    AdminDao dao;

    public AdminServiceImpl(AdminDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(Admin admin) {
        return dao.create(admin) > 0;
    }

    @Override
    public Set<Admin> read() {
        return dao.read();
    }

    @Override
    public boolean update(int id, String login, String pass) {
        Admin admin = new Admin(id, login, pass);
        return dao.update(admin) > 0;
    }

    @Override
    public boolean delete(int id) {
        Admin admin = new Admin(id);
        return dao.delete(admin) > 0;
    }

    @Override
    public boolean loginAdmin(String login, String pass) {
        return dao.read().stream()
                .anyMatch(admin -> login.trim().equals(admin.getLogin())
                && pass.trim().equals(admin.getPassword()));
    }
}
