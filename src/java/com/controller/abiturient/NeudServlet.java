/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller.abiturient;

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
@WebServlet(name = "NeudServlet", urlPatterns = {"/neudServlet"})
public class NeudServlet extends InitServlet implements Jumpable {
    
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Создание списка для хранения результата
        Set<Abiturient> result =  abiturientService.filterAbiturientsWithUnsatisfactoryGrades();

        // Установка атрибута "result" с результатом для передачи на другую страницу
        request.setAttribute("result", result);

        // Перенаправление запроса и ответа на страницу result.jsp
                 jump("/WEB-INF/jsp/result.jsp", request, response);

    }
}
