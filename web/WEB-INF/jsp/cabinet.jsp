<%-- 
    Document   : cabinet
    Created on : 22 мая 2023 г., 01:37:36
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style>
            <%@include file="/resources/css/cabinetcss.css"%>
        </style>
        <title>Кабинет</title>
    </head>
    <body>
        <!-- Приветственное сообщение с именем и фамилией пользователя, полученными из сессии -->
        <h2>Добро пожаловать, <%= session.getAttribute("name")%> <%= session.getAttribute("lastName")%></h2>

        <!-- Отображение среднего балла студента -->

        <!-- Ссылка для возврата на страницу index.jsp -->
        <a href="index.jsp">Назад</a>  

    </body>
</html>