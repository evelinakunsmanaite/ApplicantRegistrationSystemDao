/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller.abiturient;

import com.controller.InitServlet;
import com.controller.Jumpable;
import com.model.Abiturient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AvgServlet", urlPatterns = {"/avgServlet"})
public class AvgServlet extends InitServlet implements Jumpable {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Получение заданного среднего балла из запроса
        double avg = Double.parseDouble(request.getParameter("avg"));

        // Создание списка для хранения результата
        Set<Abiturient> result = abiturientService.filterAbiturientsByAvg(avg);

        // Установка атрибута "result" с результатом для передачи на другую страницу
        request.setAttribute("result", result);

        // Перенаправление запроса и ответа на страницу result.jsp
        jump("/WEB-INF/jsp/result.jsp", request, response);

    }
}
