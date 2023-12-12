/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller.admin;

import com.controller.InitServlet;
import com.controller.Jumpable;
import com.model.Abiturient;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "UpdateAbiturientServlet", urlPatterns = {"/updateAbiturient"})
public class UpdateAbiturientServlet extends InitServlet implements Jumpable {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String id = request.getParameter("id");
        Set<Abiturient> abiturients = abiturientService.read();// Получение списка абитуриентов из сервиса
         Set<Abiturient> abiturient = new HashSet<>();
        for (Abiturient a: abiturients){
            if (a.getId() == Integer.parseInt(id)){
        abiturient.add(a);
        }
        }
    
        request.setAttribute("abiturient", abiturient);
        jump("/WEB-INF/jsp/updateAbiturient.jsp", request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        String noten = request.getParameter("noten");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        boolean isAbiturientUpdate = abiturientService.update(id, login, password, firstName, middleName, lastName, telephone, address, noten);

        if (isAbiturientUpdate) {
            jump("/WEB-INF/jsp/res.jsp", request, response);

        } else {
            jump("/WEB-INF/jsp/error.jsp", request, response);

        }
    }
}
