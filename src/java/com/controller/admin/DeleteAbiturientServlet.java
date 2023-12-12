/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller.admin;

import com.controller.InitServlet;
import com.controller.Jumpable;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Administrator
 */
@WebServlet(name = "DeleteAbiturientServlet", urlPatterns = {"/deleteAbiturient"})
public class DeleteAbiturientServlet extends InitServlet implements Jumpable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        boolean success = abiturientService.delete(id);
if (success){
        jump("/WEB-INF/jsp/res.jsp", request, response);
    } else {
        jump("/WEB-INF/jsp/res.jsp", request, response);

}

    }
}
