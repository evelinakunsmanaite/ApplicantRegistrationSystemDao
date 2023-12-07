/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao.impl;

import com.dao.AdminDao;
import com.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
public class AdminDaoImpl implements AdminDao {

    private DataSource dataSource;

    public AdminDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int create(Admin admin) {
        try (Connection conn = dataSource.getConnection()) {//установление соединения (получение соединения)
            int id;

            String sql = "insert into admin(login,password) values(?,?)";//формирование запроса добавления
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {//в наш подготовленный запрос передаём строку с запросом
                preparedStatement.setString(1, admin.getLogin());
                preparedStatement.setString(2, admin.getPassword());

                int affectedRows = preparedStatement.executeUpdate();//количество добавленных строчек

                if (affectedRows == 0) {// если строчки не добавлены выбрасывается исключение 
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                sql = "SELECT * FROM abiturients ORDER BY id DESC LIMIT 1;";//сортируем в обратном порядке записи(от максимального до минимального) в бд и получаем первую строчку
                try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                    if (rs.next()) {//если результат имеет хотя бы 1у запись
                        id = rs.getInt("id"); //берём id свежесозданной строчки 
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public Set<Admin> read() {
        String req = "Select * from admin";
        Set<Admin> admin;
        try (Connection conn = dataSource.getConnection()) {
            try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(req)) {
                admin = new HashSet<>();
                while (resultSet.next()) {//пока есть записи 
                    int id = resultSet.getInt("id");
                    String login = resultSet.getString("login");
                    String password = resultSet.getString("password");

                    admin.add(new Admin(id, login, password));
                }
            }
            return admin;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(Admin admin) {
        try (Connection conn = dataSource.getConnection()) {
            String query = "UPDATE admin SET login =?,password =? WHERE id =?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, admin.getLogin());
                preparedStatement.setString(2, admin.getPassword());

                preparedStatement.setInt(3, admin.getId());
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Admin admin) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "delete from admin where id = ?";
            try (PreparedStatement preparedStmt = connection.prepareStatement(query)) {
                preparedStmt.setInt(1, admin.getId());
                int result = preparedStmt.executeUpdate();
                return result;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

}
