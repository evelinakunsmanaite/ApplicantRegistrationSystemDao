package com.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import com.model.Abiturient;
import com.model.University;
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
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends InitServlet implements Jumpable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Получение введенного логина и пароля из формы
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        boolean isUser = userService.loginUser(login, pass);
        Abiturient isAbiturient = abiturientService.loginAbiturient(login, pass);
        boolean isAdmin = adminService.loginAdmin(login, pass);

        if (isAdmin) {
            jump("/WEB-INF/jsp/adminF.jsp", request, response);

        } else if (isUser) {
            jump("/WEB-INF/jsp/userCabinet.jsp", request, response);

        } else if (isAbiturient != null) {
            Set<University> universities = universityService.read();
            double avg = abiturientService.calculateAverageGrade(isAbiturient);
            
            request.getSession().setAttribute("name", isAbiturient.getFirstName());
            request.getSession().setAttribute("lastName", isAbiturient.getLastName());
            request.getSession().setAttribute("avg", avg);
            request.getSession().setAttribute("avgx", avg * 10);
            request.setAttribute("universities", universities);

            jump("/WEB-INF/jsp/cabinet.jsp", request, response);

        } else {
            jump("/WEB-INF/jsp/error.jsp", request, response);

        }
    }
}
