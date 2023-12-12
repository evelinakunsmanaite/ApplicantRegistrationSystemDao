package com.controller.admin;

import com.controller.InitServlet;
import com.controller.Jumpable;
import com.model.Abiturient;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AddAbiturientServlet", urlPatterns = {"/addAbiturient"})
public class AddAbiturientServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        jump("/WEB-INF/jsp/adminAdd.jsp", request, response);
    }//сработывает при нажатии на ссылку добавить 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        String noten = request.getParameter("noten");

        // Создаем объект абитуриента
        Abiturient abiturient = new Abiturient(login, password, firstName, middleName, lastName, telephone, address, noten);

        boolean isAbiturientAdd = abiturientService.create(abiturient);
        if (isAbiturientAdd) {
            jump("/WEB-INF/jsp/res.jsp", request, response);

        } else {
            jump("/WEB-INF/jsp/error.jsp", request, response);

        }
    }
}
