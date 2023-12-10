<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
         <fmt:bundle basename="com.localization.messages.msg">
        <style>
            <%@include file="/resources/css/userCabinetcss.css"%>
        </style>
        <title><fmt:message key="pageTitle" /></title>
    </head>
    <body>
        <div class="registration">

            <!-- Приветственное сообщение с отображением имени и отчества пользователя, полученных из сессии -->
            <h2><fmt:message key="welcomeMessage" /></h2>

            <img src="resources/img/icon-university.png" alt="" class="round">

            <!-- Форма для получения списка студентов с неудовлетворительные оценками -->
            <form  action="neudServlet" method="get">
                <div class="form-group"> 
                    <div class="input-container">
                        <label><h3><fmt:message key="listUnsatisfactoryGrades" /></h3>
                            <input class="form-control item" type="submit" value="<fmt:message key='send' />">
                        </label>    
                    </div>

                </div>
            </form>

            <!-- Форма для получения списка студентов с средним баллом выше указанного значения -->
            <form action="avgServlet" method="post">
                <div class="form-group"> <div class="input-container">
                        <label><h3><fmt:message key="listAboveAverage" /></h3>
                            <input class="form-control item" type="text" name="avg" required placeholder="<fmt:message key='enterAverageScore' />">
                            <input class="form-control item" type="submit" value="<fmt:message key='send' />">
                        </label>    
                    </div> 
                </div>
            </form>
            
 <form action="page" method="post">
            <input type="hidden" name="page" value="toLogin">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>    
    </body>
    </fmt:bundle>
</html>