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
            background-color: #826590;
        }

        h2 {
            font-size: 40px;
            color: #442952;
        }

        .signin-form {
            padding: 30px 60px;
            background: white;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            box-shadow: 10px 5px 20px rgba(0, 0, 0, 0.3);
            text-align: center;
            opacity: 0.5;
        }

        .nav-menu {
            list-style-type: none;
            padding: 0;
        }

        .nav-menu li {
            margin-bottom: 20px;
        }

        .nav-menu a {
            display: block;
            padding: 10px;
            background-color: #442952;
            color: white;
            text-decoration: none;
            border-radius: 10px;
        }

        .nav-menu a i {
            margin-right: 10px;
        }
        .round {
    width: 300px; /* Adjust the width of the image */
}
    </style>
</head>
<body>
<div class="signin-form">
                    <img src="resources/img/icon-university.png" alt="" class="round">

    <ul class="nav-menu">
        <li>
            <a href="addAbiturient" method="post">
                <i class="fas fa-plus"></i> <fmt:message key="addAbiturient" />
            </a>
        </li>
        <li>
            <a href="readAbiturient">
                <i class="fas fa-user"></i> <fmt:message key="readAbiturient" />
            </a>
        </li>
    </ul>
                    
                    <form action="page" method="post">
            <input type="hidden" name="page" value="toLogin">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>  
</div>
</body>
</fmt:bundle>
</html>
