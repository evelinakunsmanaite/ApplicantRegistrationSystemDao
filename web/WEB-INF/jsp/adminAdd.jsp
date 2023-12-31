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
            width: 80%;
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

        form {
            margin: 20px auto;
            max-width: 400px;
            background-color: #442952;
            color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
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
   

    <!-- Форма добавления абитуриента -->
    <form action="addAbiturient" method="post">
        <label for="login"><fmt:message key="login" /></label>
        <input type="text" name="login" required/><br/>

        <label for="password"><fmt:message key="password" /></label>
        <input type="password" name="password" required/><br/>

        <label for="firstName"><fmt:message key="firstName" /></label>
        <input type="text" name="firstName" required/><br/>

        <label for="middleName"><fmt:message key="middleName" /></label>
        <input type="text" name="middleName" required/><br/>

        <label for="lastName"><fmt:message key="lastName" /></label>
        <input type="text" name="lastName" required/><br/>

        <label for="telephone"><fmt:message key="telephone" /></label>
        <input type="text" name="telephone" required/><br/>

        <label for="address"><fmt:message key="address" /></label>
        <input type="text" name="address" required/><br/>

        <label for="noten"><fmt:message key="noten" /></label>
        <input type="text" name="noten" required/><br/>

        <input type="submit" value="<fmt:message key="addAbiturient" />"/>
    </form>
   <form action="page" method="post">
            <input type="hidden" name="page" value="toAdmin">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>  
</body>
</fmt:bundle>
</html>
