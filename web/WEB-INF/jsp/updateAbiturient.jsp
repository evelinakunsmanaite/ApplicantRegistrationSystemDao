<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><html>
<head>
    <meta charset="UTF-8">
    <title>Update Abiturient</title>
    <style>
        body {
            background-color: #826590;
            color: #ffffff;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #442952;
            padding: 20px;
            border: 2px solid #442952;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            text-align: center;
            width: 400px;
        }

        table {
            width: 100%;
        }

        table, th, td {
            border-collapse: collapse;
            border: 1px solid #ffffff;
            color: #ffffff;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        input {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #ffffff;
            color: #442952;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <form action="updateAbiturient" method="post">
                <c:forEach var="abiturient" items="${abiturient}">

        <input type="hidden" name="id" value="${abiturient.id}"/>
        
        <table>
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="firstName" value="${abiturient.firstName}" required/></td>
            </tr>
            <tr>
                <td>Middle Name:</td>
                <td><input type="text" name="middleName" value="${abiturient.middleName}" required/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" name="lastName" value="${abiturient.lastName}" required/></td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td><input type="text" name="telephone" value="${abiturient.telephone}" required/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" value="${abiturient.address}" required/></td>
            </tr>
            <tr>
                <td>Noten:</td>
                <td><input type="text" name="noten" value="${abiturient.noten}" required/></td>
            </tr>
            <tr>
                <td>Login:</td>
                <td><input type="text" name="login" value="${abiturient.login}" required/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="password" value="${abiturient.password}" required/></td>
            </tr>
        </table>
           </c:forEach>
        <input type="submit" value="Update Abiturient"/>
    </form>
</body>
</html>
