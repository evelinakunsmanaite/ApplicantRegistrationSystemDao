/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao.impl;

import com.dao.*;
import com.model.Abiturient;
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
public class AbiturientDaoImpl implements AbiturientDao{
        private DataSource dataSource;

    public AbiturientDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int create(Abiturient abiturient) {
try (Connection conn = dataSource.getConnection()) {//установление соединения (получение соединения)
            int id;

            String sql = "insert into abiturients(first_name,last_name,patronimic,telephone,address,grade) values(?,?,?,?)";//формирование запроса добавления
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {//в наш подготовленный запрос передаём строку с запросом
                preparedStatement.setString(1, abiturient.getFirstName());
                preparedStatement.setString(2, abiturient.getLastName());
                preparedStatement.setString(3, abiturient.getPatronimic());
                preparedStatement.setString(4, abiturient.getTelephone());
                preparedStatement.setString(5, abiturient.getAddress());
                preparedStatement.setString(6, abiturient.getAddress());

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
    public Set<Abiturient> read() {
 String req = "Select * from abiturients";
        Set<Abiturient> abiturients;
        try (Connection conn = dataSource.getConnection()) {
            try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(req)) {
                abiturients = new HashSet<>();
                while (resultSet.next()) {//пока есть записи 
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String patronimic = resultSet.getString("patronimic");                    
                    String telephone = resultSet.getString("telephone");
                    String address = resultSet.getString("address");
                    String grade = resultSet.getString("grade");

                    
                    abiturients.add(new Abiturient(id, firstName, lastName,patronimic,telephone,address,grade));
                }
            }
            return abiturients;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
    }

    @Override
    public int update(Abiturient abiturient) {
try (Connection conn = dataSource.getConnection()) {
            String query = "UPDATE abiturients SET first_name =?,last_name =?,patronimic =?,telephone =?,address =?,grade =? WHERE id =?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, abiturient.getFirstName());
                preparedStatement.setString(2, abiturient.getLastName());
                preparedStatement.setString(3, abiturient.getPatronimic());
                preparedStatement.setString(4, abiturient.getTelephone());
                preparedStatement.setString(5, abiturient.getAddress());
                preparedStatement.setString(6, abiturient.getNoten());
                preparedStatement.setInt(7, abiturient.getId());
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        } 
    }

    @Override
    public int delete(Abiturient abiturient) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "delete from abiturients where id = ?";
            try (PreparedStatement preparedStmt = connection.prepareStatement(query)) {
                preparedStmt.setInt(1, abiturient.getId());
                int result = preparedStmt.executeUpdate();
                return result;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }     }
    
}
