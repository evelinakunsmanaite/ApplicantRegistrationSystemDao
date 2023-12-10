package com.controller;

import com.errors.ValidationError;
import com.model.Abiturient;
import com.model.University;
import com.model.User;
import com.validators.Validator;
import java.io.IOException;
import java.util.Set;
import javax.servlet.RequestDispatcher;
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

        User isUser = userService.loginUser(login, pass);
        Abiturient isAbiturient = abiturientService.loginAbiturient(login, pass);
        boolean isAdmin = adminService.loginAdmin(login, pass);

        ValidationError errors = new ValidationError();
        Validator.validate(login, pass, isUser, isAbiturient, isAdmin, errors);
        RequestDispatcher rd;
        if (!errors.getErrorList().isEmpty()) {
            request.setAttribute("result", errors);
            rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
            rd.forward(request, response);
        }

        if (isAdmin) {
            jump("/WEB-INF/jsp/adminF.jsp", request, response);

        } else if (isUser != null) {
           request.getSession().setAttribute("name", isUser.getFirstName());
                request.getSession().setAttribute("lastName", isUser.getLastName());

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

        }

    }
}
