/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller.admin;

import com.controller.InitServlet;
import com.controller.Jumpable;
import com.model.Abiturient;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "ReadAbiturientServlet", urlPatterns = {"/readAbiturient"})
public class ReadAbiturientServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Set<Abiturient> abiturients = abiturientService.read();// Получение списка абитуриентов из сервиса
        request.setAttribute("abiturients", abiturients);
        jump("/WEB-INF/jsp/adminRead.jsp", request, response);
    }

}
