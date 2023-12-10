<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
<fmt:bundle basename="com.localization.messages.msg">
        <style>
            <%@include file="/resources/css/cabinetcss.css"%>
        </style>
        <title><fmt:message key="pageTitle" /></title>
    </head>
    <body>
        <!-- Приветственное сообщение с именем и фамилией пользователя, полученными из сессии -->
        <h2><fmt:message key="welcomeMessage"/> <%= session.getAttribute("name")%> <%= session.getAttribute("lastName")%></h2>
        <h3><fmt:message key="yourScore" /><fmt:formatNumber type="number" maxFractionDigits="2"><%= session.getAttribute("avg")%> </fmt:formatNumber> </h3>  

            <!-- Таблица со списком университетов -->
            <table>
                <tr>
                <th><fmt:message key="universityList" /></th>
                <th><fmt:message key="requiredScore" /></th>
                <th><fmt:message key="needToAchieve" /></th>
                </tr>

                <!-- Цикл для прохода по университетам и отображения информации -->
            <c:forEach var="university" items="${universities}" varStatus="loop">
                <tr>
                    <td>${university.universityName}</td>
                    <td>${university.passingScore}</td>
                    <c:set var="difference" value="${university.passingScore - sessionScope.avgx}" />
                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${difference}" /></td>
                </tr>           
            </c:forEach>
    </table>

    <!-- Ссылка для возврата на страницу index.jsp -->
<form action="page" method="post">
            <input type="hidden" name="page" value="toLogin">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>  
</body>
</fmt:bundle>
</html>