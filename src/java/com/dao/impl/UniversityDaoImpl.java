/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao.impl;

import com.dao.*;
import com.model.University;
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
public class UniversityDaoImpl implements UniversityDao {

    private final DataSource dataSource;

    public UniversityDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int create(University university) {
        try (Connection conn = dataSource.getConnection()) {//установление соединения (получение соединения)
            int id;

            String sql = "insert into universitys(university_name,passingScore) values(?,?)";//формирование запроса добавления
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {//в наш подготовленный запрос передаём строку с запросом
                preparedStatement.setString(1, university.getUniversityName());
                preparedStatement.setDouble(2, university.getPassingScore());//переданный запрос меняем, указываем позицию ? и чем мы его занимаем, отсчёт с 1
                int affectedRows = preparedStatement.executeUpdate();//количество добавленных строчек

                if (affectedRows == 0) {// если строчки не добавлены выбрасывается исключение 
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                sql = "SELECT * FROM universitys ORDER BY id DESC LIMIT 1;";//сортируем в обратном порядке записи(от максимального до минимального) в бд и получаем первую строчку
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
    public Set<University> read() {
        String req = "Select * from universitys";
        Set<University> universitys;
        try (Connection conn = dataSource.getConnection()) {
            try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(req)) {
                universitys = new HashSet<>();
                while (resultSet.next()) {//пока есть записи 
                    int id = resultSet.getInt("id");
                    String universityName = resultSet.getString("university_name");
                    Double passingScore = resultSet.getDouble("passingScore");

                    universitys.add(new University(id, universityName, passingScore));
                }
            }
            return universitys;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(University university) {
        try (Connection conn = dataSource.getConnection()) {
            String query = "UPDATE universitys SET university_name =?, passingScore =? WHERE id =?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, university.getUniversityName());
                preparedStatement.setDouble(2, university.getPassingScore());

                preparedStatement.setInt(3, university.getId());
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(University university) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "delete from universitys where id = ?";
            try (PreparedStatement preparedStmt = connection.prepareStatement(query)) {
                preparedStmt.setInt(1, university.getId());
                int result = preparedStmt.executeUpdate();
                return result;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

}
