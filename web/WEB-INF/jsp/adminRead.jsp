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
    <title>JSP Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #826590;
            color: #442952;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        table {
            border-collapse: collapse;
            width: 90%;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #442952;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #442952;
            color: white;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: white;
        }

        input {
            width: calc(100% - 16px);
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #826590;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>
     <!-- Таблица с абитуриентами -->
    <table>
        <thead>
            <th><fmt:message key="id" /></th>
            <th><fmt:message key="firstName" /></th>
            <th><fmt:message key="middleName" /></th>
            <th><fmt:message key="lastName" /></th>
            <th><fmt:message key="telephone" /></th>
            <th><fmt:message key="address" /></th>
            <th><fmt:message key="noten" /></th>
            <th><fmt:message key="login" /></th>
            <th><fmt:message key="password" /></th>
            <th><fmt:message key="delete" /></th>
            <th><fmt:message key="edit" /></th>
        </thead>
        <c:forEach var="abiturient" items="${abiturients}">
            <tr>
                <td>${abiturient.id}</td>
                <td>${abiturient.firstName}</td>
                <td>${abiturient.middleName}</td>
                <td>${abiturient.lastName}</td>
                <td>${abiturient.telephone}</td>
                <td>${abiturient.address}</td>
                <td>${abiturient.noten}</td>
                <td>${abiturient.login}</td>
                <td>${abiturient.password}</td>
                <td>
                    <form action="deleteAbiturient" method="post">
                        <input type="hidden" name="id" value="${abiturient.id}"/>
                        <input type="submit" value="<fmt:message key="delete" />"/>
                    </form>
                </td>
                <td>
                    <form action="updateAbiturient">
                        <input type="hidden" name="id" value="${abiturient.id}"/>
                        <input type="submit" value="<fmt:message key="edit" />"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
       <form action="page" method="post">
            <input type="hidden" name="page" value="toAdmin">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>
</body>
</fmt:bundle>
</html>
