<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/resultcss.css" rel="stylesheet" />

        <title>Результат</title>
        
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
        <c:choose>

            <c:when test="${not empty result}">
                <table>
                    <thead>

                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Отчество</th>
                    <th>Телефон</th>
                    <th>Адрес</th>
                    <th>Оценки</th>

                </thead>
                <c:forEach var="abiturient" items="${result}">
                    <tr>
                        <td>${abiturient.firstName}</td>
                        <td>${abiturient.middleName}</td>
                        <td>${abiturient.lastName}</td>
                        <td>${abiturient.telephone}</td>
                        <td>${abiturient.address}</td>
                        <td>${abiturient.noten}</td>


                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <c:otherwise>
            <c:out value="искомые данные отсутствуют" />
        </c:otherwise>
    </c:choose>

<form action="page" method="post">
            <input type="hidden" name="page" value="toUser">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>  </body>
</html>
